

import java.util.LinkedList;
import java.util.Scanner;

public class bj_16637 {
	
static int ans;
static int[] nums, numsCopy;
static LinkedList<Character> ops;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		nums = new int[N/2 + 1]; // 숫자 저장
		ops = new LinkedList<>(); // 연산자 저장
		char[] cal = sc.next().toCharArray();
		for(int i = 1; i <= N; i ++) {
			if(i%2 == 1)
				nums[i/2] = cal[i-1] - '0';
			else
				ops.add(cal[i-1]);
		}
		ans = Integer.MIN_VALUE;
		comb(0, N/2 + 1, new boolean[N/2 + 1]);
		System.out.println(ans);
	}
	
//	조합 구하기
	private static void comb(int idx, int n, boolean[] result) {
		if(n == 1) {
			ans = nums[0];
			return;
		}
		if(idx >= n) {
			int res = Integer.MIN_VALUE;
			numsCopy = nums.clone();
			
			for(int i = 0; i < n - 1 ; i++) {
				if(result[i]) {
					calculate(i, ops.get(i), numsCopy[i], numsCopy[i+1]);
				}
			}
			for(int i = 0; i < n - 1; i++) {
				if(!result[i]) {
					if(res == Integer.MIN_VALUE) res = numsCopy[i];
					res = calculate(i, ops.get(i), res, numsCopy[i+1]);
				}
			}
			if(res > ans) ans = res;
			return;
		}
		// 괄호 처리된 바로 다음 연산자에 또 괄호 처리 할 순 없으니 2칸 전진
		result[idx] = true;
		comb(idx + 2, n, result);
		result[idx] = false;
		comb(idx + 1, n, result);
	}

private static int calculate(int i, Character op, Integer num1, Integer num2) {
	int tmp;
	if(op == '+') {
		tmp = num1 + num2;
	}
	else if (op == '-') {
		tmp = num1 - num2;
	}
	else {
		tmp = num1 * num2;
	}
	numsCopy[i] = tmp;
	numsCopy[i+1] = tmp;
	return tmp;
}

}
