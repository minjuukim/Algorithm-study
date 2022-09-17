import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj_11724 {
static boolean[][] conn;
static boolean[] visited;
static int ans, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		conn = new boolean[N+1][N+1];
		for(int i = 0; i < M ; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			conn[a][b] = true;
			conn[b][a] = true;
		}
		
		visited = new boolean[N + 1];
		ans = 0;
		for(int i = 1; i <= N ;i ++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int num) {
		if(visited[num]) {
			return;
		}
		visited[num] = true;
		for(int i = 1; i <= N ; i++) {
			if(conn[num][i]) {
				dfs(i);
			}
		}
	}

}
