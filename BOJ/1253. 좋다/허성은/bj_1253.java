import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class bj_1253 {
static int[] nums;
static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Map<Integer, Integer> cnt = new HashMap<>();
		nums = new int[N];
		for(int i = 0; i < N ; i++) {
			nums[i] = sc.nextInt();
			cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
		}
		int ans = 0;
		for(int i = 0; i < N ; i++) { // 좋다 판단할 숫자 idx
			for(int j = 0; j < N; j++) { // 더할 수 1 idx
				if(i == j) continue;
				int num = nums[i] - nums[j]; // 구해야 하는 수
				if(cnt.get(num) != null) {
					if(num == nums[j] && num == nums[i]) {
						if(cnt.get(nums[j]) > 2) {
							ans++;
							break;							
						}
					}
					else if(num == nums[j]) {
						if(cnt.get(nums[j]) > 1) {
							ans++;
							break;							
						}
					}
					else if(num == nums[i]) {
						if(cnt.get(nums[i]) > 1) {
							ans++;
							break;							
						}
					}
					else {
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
	