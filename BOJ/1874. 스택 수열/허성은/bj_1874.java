import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class bj_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		스택을 직접 구현해서 시뮬레이션을 돌렸는데
//		그렇게 하면 출력오류나 시간초과가 잘뜨는거 같음
//		규칙성을 찾자
		
//		큰 수 다음에 작은 수를 출력해야 할 때 그 사이에 출력되지 않은 값이 있으면 안됨
//		boolean 배열을 이용해서 출력하면 0으로 바꿔주기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer> arr = new ArrayList<>();
		boolean[] flag = new boolean[N+1];
		for(int i =0 ; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		int tmp = 0;
	loop : while(!arr.isEmpty()) {
//			바로 전 수 보다 크면 그 차이 만큼 + 추가
			if(arr.get(0) > tmp) {
				for(int i = tmp; i < arr.get(0); i++) {
					sb.append("+\n");
				}
			}
//			작을 때는 불가능 구현인지 검사해야함..
			else {
				for(int i = tmp - 1 ; i > arr.get(0); i--) {
					if(!flag[i]) {
						sb.setLength(0);
						sb.append("NO");
						break loop;
					}
				}
			}
			sb.append("-\n");
			flag[arr.get(0)] = true;
			tmp = Math.max(tmp, arr.get(0));
			arr.remove(0);
		}
		System.out.println(sb.toString());
	}
}