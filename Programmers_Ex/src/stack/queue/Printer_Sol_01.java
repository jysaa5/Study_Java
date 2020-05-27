package stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// 문제: 프린터
// 인쇄 대기목록의 가장 앞에 있는 문서 = J, 중요도가 있는 프린터
// 솔루션 1: queue 2개를 사용하자. (내가 푼 것.)

class Solution {

	public int solution(int[] priorities, int location) {
		// 반환 값
		int answer = 1;

		// 제일 중요도 높은 것
		int max = 0;

		// 프린트 대기열에 제일 맨 앞에 있는 프린터 목록
		int j = 0;

		// 프린트 대기열 큐 선언
		Queue<Integer> printer = new LinkedList<Integer>();

		// 인덱스 큐
		Queue<Integer> printerIndex = new LinkedList<Integer>();

		// 큐에 프린트 대기열 넣기
		for (int i = 0; i < priorities.length; i++) {

			printer.add(priorities[i]);
			printerIndex.add(i);

			if (max < priorities[i]) {

				max = priorities[i];

			}
		}

		// 프린터 대기열 큐에 프린트 할 것이 없을 때까지
		while (printer.peek() != null) {

			// 프린터 대기열 앞에 있는 프린트 꺼내기
			j = printer.poll();

			// 중요도가 가장 높을 때
			if (j == max) {

				// 원하는 위치에 있는 프린트일때
				if (location == printerIndex.poll()) {

					break;

				} else {

					answer++;

					// max인 값 초기화
					for (int i = 0; i < priorities.length; i++) {

						if (max == priorities[i]) {
							priorities[i] = 0;
							max = 0;
						}
					}

					// 새로운 max 값
					for (int i = 0; i < priorities.length; i++) {

						if (max < priorities[i]) {

							max = priorities[i];

						}
					}

				}

			} else {

				printer.add(j);
				printerIndex.add(printerIndex.poll());

			}

		}
		return answer;
	}
}

public class Printer_Sol_01 {

	public static void main(String[] args) {

		Solution sol = new Solution();

		// int[] priorities = {2,1,3,2};
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		// int location = 2;
		int location = 0;

		System.out.println(sol.solution(priorities, location));

	}

}