package kakao.developer.internship;

// 문제: 크레인 인형뽑기 게임
// 풀이: for문 이용

class Solution {
	public int solution(int[][] board, int[] moves) {
		// 반환값
		int answer = 0;

		// 꺼낼 위치의 인덱스 값
		int idx = 0;

		int[] basket = new int[moves.length];

		int k = 0;

		for (int i = 0; i < moves.length; i++) {

			idx = moves[i] - 1;

			for (int j = 0; j < board.length; j++) {

				if (board[j][idx] > 0) {

					basket[k] = board[j][idx];
					
					board[j][idx] = 0;

					if (k > 0 && basket[k - 1] == basket[k]) {

						basket[k - 1] = -1;
						basket[k] = -1;
						
						answer = answer+2;
						k--;

					} else {

						k++;
					}

					break;

				}

			}

		}

		return answer;
	}
}

public class Crane_Doll_Drawing_Game {

	public static void main(String[] args) {

		Solution sol = new Solution();

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println("answer:" + sol.solution(board, moves));

	}

}
