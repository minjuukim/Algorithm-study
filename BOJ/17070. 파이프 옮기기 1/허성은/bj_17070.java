import java.util.Scanner;

public class bj_17070 {
static final int WIDTH = 0;
static final int VERTICAL = 1;
static final int CROSS = 2;
static int[][] map;
static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		for(int r = 1; r <= N ; r++) {
			for(int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		ans = 0;
		move(WIDTH, 1, 2);
		System.out.println(ans);
	}
	private static void move(int dir, int r, int c) {
		if(r == N && c == N) {
			ans++;
			return;
		}
		if(dir == WIDTH) {
			if(check(WIDTH, r, c)) {
				move(WIDTH, r, c + 1);
			}
			if(check(CROSS, r, c)) {
				move(CROSS, r + 1, c + 1);
			}
		}
		else if(dir == VERTICAL) {
			if(check(VERTICAL, r, c)) {
				move(VERTICAL, r+1, c);
			}
			if(check(CROSS, r, c)) {
				move(CROSS, r+1, c+1);
			}
		}
		else {
			if(check(WIDTH, r, c))
				move(WIDTH, r, c +1);
			if(check(VERTICAL, r, c))
				move(VERTICAL, r+1, c);
			if(check(CROSS, r, c))
				move(CROSS, r+1, c+1);
		}
	}
	private static boolean check(int dir, int r, int c) {
		if(dir == WIDTH) {
			if(c + 1 > N || map[r][c+1] == 1) return false;
		}
		else if(dir == VERTICAL) {
			if(r + 1 > N || map[r+1][c] == 1) return false;
		}
		else {
			if(r == N || c == N || map[r][c+1] == 1 || map[r+1][c] == 1 || map[r+1][c+1] == 1) return false;
		}
		return true;
	}

}
