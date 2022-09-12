package day0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1253_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// ���� ����
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		
		for (int k = 0; k < N; k++) {
			int i = 0;
			int j = N-1;
			long key = arr[k];
			
			// �������� �˰���
			while(i<j) {
				
				int sum = arr[i] + arr[j];
				
				if(sum == key) {	// key�� ���� �ٸ� �� ���� ���̾�� ���� üũ.
					// �ڱ� �ڽ��� �����ϸ� �ȵ� -> ����ó��
					if(i!=k && j!=k) {
						count++;
						break;
					} else if(i == k) {	
						i++;
					} else if(j == k){
						j--;
					}
				}
				else if(sum < key) {
					i++;
				} else {
					j--;
				}
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
