import java.util.Scanner;

public class bj_12891 {
static int aCnt, cCnt, gCnt, tCnt, a, c, g, t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();
		char[] str = sc.next().toCharArray();
		a = sc.nextInt();
		c = sc.nextInt();
		g = sc.nextInt();
		t = sc.nextInt();
		
		aCnt = 0;
		cCnt = 0;
		gCnt = 0;
		tCnt = 0;
		
		int ans = 0;
		for(int i = 0; i < S; i++) {
			if(i < P - 1) {
				add(str[i]);			
			}
			else if (i == P - 1){
				add(str[i]);			
				ans += check();
			}
			else {
				minus(str[i-P]);
				add(str[i]);
				ans += check();
			}
		}
		System.out.println(ans);
	}
	private static void minus(char ch) {
		if(ch == 'A')
			aCnt--;
		else if(ch == 'C')
			cCnt--;
		else if(ch == 'G')
			gCnt--;
		else
			tCnt--;	
	}
	private static int check() {
		if(aCnt >= a && cCnt >= c && gCnt >= g && tCnt >= t)
			return 1;
		return 0;
	}
	private static void add(char ch) {
		if(ch == 'A')
			aCnt++;
		else if(ch == 'C')
			cCnt++;
		else if(ch == 'G')
			gCnt++;
		else
			tCnt++;		
	}

}
