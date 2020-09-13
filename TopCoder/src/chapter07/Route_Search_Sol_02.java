package chapter07;

//p. 211
//문제: 경로 탐색
//솔루션: 메모화 재귀를 사용한 깊이우선 탐색
public class Route_Search_Sol_02 {

	static final int h = 5;
	static final int w = 4;
	// 메모화하기 위한 2차원 배열
	static int[][] dp = new int[h + 1][w + 1];

	static int dfs(int nowh, int noww) {

		if (nowh > h || noww > w) {
			return 0;
		}

		if (nowh == h && noww == w) {
			return 1;
		}

		if (dp[nowh][noww] != 0) {
			return dp[nowh][noww];
		}

		// 새로운 길일때 왼족으로 가는 방법과 오른쪽으로 가는 방법을 찾는다.
		return dp[nowh][noww] = dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
	}

	public static void main(String[] args) {
		System.out.println("경로의 수: "+dfs(0, 0));

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
