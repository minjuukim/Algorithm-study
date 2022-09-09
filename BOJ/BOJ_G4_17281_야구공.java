package day0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_17281_�߱��� {
	
	static int N;
	static int[][] game;
	static boolean[] visit;	
	static int[] player;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// �̴� ��
		game = new int[N+1][10];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		
		// 4�� Ÿ�ڴ� 1������ ����
		visit[4] = true;
		player[4] = 1;
		
		perm(2);
		System.out.println(ans);

	}
	
	// ���� => Ÿ�� ���ϱ�
	public static void perm(int count) {
		
		if(count == 10) {
			play();
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(visit[i]) continue;
			
			player[i] = count;
			visit[i] = true;
			perm(count+1);
			visit[i] = false;
		}
	}
	
	// ��� ����
	public static void play() {
		int score = 0;
		int startPlayer = 1;	// �̴׿��� ó�� �����ϴ� Ÿ��
		boolean[] base;		// Ȩ, 1��, 2��, 3�� ǥ��
		
		for (int i = 1; i <= N; i++) {	// N��° �̴ױ��� ���� 
			int outCnt = 0;
			base = new boolean[4];		// base�� ���Ӱ� �ʱ�ȭ.
			
			outer: while(true) {
				for(int j = startPlayer; j <= 9; j++) {
					int hitter = game[i][player[j]];		// j��° Ÿ���� �ൿ
					
					switch(hitter) {
					case 0:		// �ƿ�
						outCnt++;
						break;
						
					case 1:		// 1��Ÿ
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								
								if(k==3) {		// 3�翡 �ִ� ������ Ȩ���� ������ ����ȹ��.
									score++;
									base[k] = false;	// 3��� ����ְ� ��.
									continue;
								}
								
								// 1, 2���� ��� 1�羿 �����ϰ�, ���� �ִ� �ڸ��� ����ְ� ��.
								base[k] = false;
								base[k+1] = true;
							}
						}
						
						base[1] = true;		// Ȩ���� 1��� ����.
						break;
					
					case 2:		// 2��Ÿ
						for(int k=3; k>=1; k--) {
							if(base[k]) {
								if(k==3 || k==2) {	// 3�� or 2�翡 �ִ� ������ Ȩ���� ������ ���� ȹ��.
									score++;
									base[k] = false;	// 3�� or 2��� ����ְ� ��.
									continue;
								}
								
								// 1���� ��� 2�羿 �����ϰ�, ���� �ִ� �ڸ��� ����ְ� ��.
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;		// Ȩ���� 2��� ����.
						break;
					
					case 3:		// 3��Ÿ
						for(int k=3; k>=1; k--) {
							if(base[k]) {		// Ȩ ���� ��� ������ Ȩ���� ������, ���� ȹ��.
								score++;
								base[k] = false;
							}
						}
						// Ȩ���� 3��� ����.
						base[3] = true;
						break;
						
					case 4:		// Ȩ��
						for(int k=1; k<=3; k++) {
							if(base[k]) {		// �� �� ��� ���ڰ� Ȩ���� ������, ���� ȹ��.
								score++;
								base[k] = false;
							}
						}
						score++;	// Ȩ��ģ Ÿ���� ���� 1�� �߰�.
						break;
					}
					
					if(outCnt == 3) {
						startPlayer = j+1;		// startPlayer�� �� ���� Ÿ�ڷ� �ʱ�ȭ
						if(startPlayer == 10) {
							startPlayer = 1;
						}
						break outer;
					}
				}
				
				// 1~9������ Ÿ�ڰ� �� �̴׿� ���� ��Ÿ�� �ļ� �ƿ�ī��Ʈ�� �߻����� �ʰ� �Ǹ�,
                // �� �ݺ����� ���� ������ ���⶧���� startPlayer = 1�� �ʱ�ȭ�ؾ� ��.
				startPlayer = 1;
				
			}//outer
		}
		
		ans = Math.max(ans, score);
	}

}
