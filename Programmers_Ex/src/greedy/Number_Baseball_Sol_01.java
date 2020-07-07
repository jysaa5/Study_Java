package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 문제: 숫자 야구
/*
문제 설명
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

제한사항
질문의 수는 1 이상 100 이하의 자연수입니다.
baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

입출력 예
baseball                                             | return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] |	2

입출력 예 설명
문제에 나온 예와 같습니다.
*/
// 솔루션: 

class Number_Baseball_Solution_01 {
	public int solution(int[][] baseball) {
		int[] tmp = new int[3];

		// 가능한 모든 경우의 수를 stack에 넣는다.
		Stack<String> stack = new Stack<>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					if (i != j && j != k && i != k) {
						stack.add(String.valueOf(i * 100 + j * 10 + k));
					}
				}
			}
		}

		// 맞는 경우의 수를 넣어줄 answerList 선언
		Stack<String> answerList = new Stack<>();

		// 조건의 개수는 baseball.length
		// 조건이 하나라도 안맞는 경우 flag를 통해서 걸러낸다.
		while (!stack.isEmpty()) {
			String out = stack.pop();

			boolean flag = false;
			for (int i = 0; i < baseball.length; i++) {
				int strike = strike(out, String.valueOf(baseball[i][0]));
				int ball = ball(out, String.valueOf(baseball[i][0])) - strike;

				if (strike != baseball[i][1] || ball != baseball[i][2]) {
					flag = true;
					break;
				}
			}

			if (flag == false) {
				answerList.add(out);
			}
		}

		return answerList.size();
	}

	static int strike(String n1, String n2) {
		int rtn = 0;
		for (int i = 0; i < 3; i++) {
			if (n1.charAt(i) == n2.charAt(i)) {
				rtn++;
			}
		}
		return rtn;
	}

	static int ball(String n1, String n2) {
		int rtn = 0;

		List<Character> tmp = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			tmp.add(n2.charAt(i));
		}

		for (int i = 0; i < 3; i++) {
			if (tmp.contains(n1.charAt(i))) {
				rtn++;
			}
		}

		return rtn;
	}
}

public class Number_Baseball_Sol_01 {

	public static void main(String[] args) {

		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };

		Number_Baseball_Solution_01 sol = new Number_Baseball_Solution_01();

		System.out.println(sol.solution(baseball));

	}

}
