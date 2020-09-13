package chapter07;

// p.214
// 문제: 경로 탐새
// 솔루션: 동적계획법(다이나믹 프로그래밍)
public class Routes_Search_Sol_03 {
	static final int h = 5;
	static final int w = 4;
	static int[][] dp = new int[h+1][w+1];
	
	static void calc() {
		int i;
		int j;
		dp[0][0] = 1;
		for(i=0; i<=h; i++) {
			for(j=0; j<=w; j++) {
				if(i != 0) {
					dp[i][j] +=dp[i-1][j];
				}
				
				if(j != 0) {
					dp[i][j] += dp[i][j-1];
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		calc();
		for(int k=0; k<dp.length; k++) {
			for(int l=0; l<dp[0].length; l++) {
				System.out.print(dp[k][l]+ " ");
			}
			System.out.println("");
		}
	}
}
