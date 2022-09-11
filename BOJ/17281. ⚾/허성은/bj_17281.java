import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj_17281 {
	
static int ans, N;
static Map<Integer, int[]> sim;
static boolean[] pos;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 이닝 수
		sim = new HashMap<>();
		for(int i = 0; i < N; i++) {
			for(int j = 1; j <= 9; j++) {
				if(i == 0) {
					sim.put(j, new int[N]);
				}
				sim.get(j)[i] = sc.nextInt();				
			}
		} // 입력 끝
		
		ans = 0;
		boolean[] visited = new boolean[10];
		visited[1] = true; // 1번 선수는 4번 타자로 배정
		setOrder(1, visited, new int[10]);
		System.out.println(ans);
	}

	private static void setOrder(int idx, boolean[] visited, int[] res) {
		// 4번 타자 고정
		if(idx == 4) {
			res[idx] = 1;
			setOrder(idx + 1, visited, res);
		}
		// 타자 순서 정해지면 시뮬레이션
		if(idx > 9) {
			int score = play(res);
			ans = ans > score ? ans : score;
			return;
		}
		for(int i = 2; i <= 9; i++) {
			if(!visited[i]) {
				res[idx] = i;
				visited[i] = true;
				setOrder(idx + 1, visited, res);
				visited[i] = false;
			}
		}
	}

	private static int play(int[] order) {
		int score = 0;
		int idx = 1;
		
		// 이닝 만큼 돌기
	next : for(int i = 0; i < N ; i++) {
			int out = 0;
			pos = new boolean[4];
			
			while(out < 3) {
				int hit = sim.get(order[idx++])[i];
				// 아웃일 경우 1 증가
				if(hit == 0) {
					out++;
				}
				// 홈런일 경우 
				else if(hit == 4) {
					for(int k = 1; k <=3; k++) {
						if(pos[k]) {
							score++;
							pos[k] = false;
						}
					}
					// 타자 점수 추가
					score++;
				}
				else {
					score += move(hit);
				}
				if(idx > 9 ) idx = 1;
			}
		}
		return score;
	}

	private static int move(int hit) {
		int res = 0;
		for(int i = 3; i> 0 ; i--) {
			if(pos[i]) { 
				if(i + hit > 3) res++;
				else pos[i + hit] = true;
				pos[i] = false;
			}
		}
		pos[hit] = true;
		return res;
	}
}
