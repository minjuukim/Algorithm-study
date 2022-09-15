package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_S2_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());	// 수열의 개수
		int[] numbers = new int[n];		// 수열
		
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int idx = 0;
		while (idx < n) {
			i++;
			if(i>n) break;
			
			if(i <= numbers[idx]) {
				stack.add(i);
				sb.append("+").append("\n");
			}
			
			while(!stack.isEmpty()) {
				if(stack.peek() == numbers[idx]) {
					stack.pop();
					sb.append("-").append("\n");
					idx++;
				} else {
					break;
				}
			}
		}
		
		if(stack.size() != 0) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}

}
