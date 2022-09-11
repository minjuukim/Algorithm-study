import java.util.Arrays;
import java.util.Scanner;

public class bj_1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] ing = new int[N];
		for(int i = 0; i < N ; i++) {
			ing[i] = sc.nextInt();
		}// 입력 끝
		
		Arrays.sort(ing);
		int ans = 0;
		next : for(int i = 0; i < N -1 ;i++) {
			for(int j = i + 1; j < N; j++) {
				if( ing[i] + ing[j] == M) {
					ans++;
				}
				else if( ing[i] + ing[j] > M) {
					continue next;
				}
			}
		}
		System.out.println(ans);
	}
}
