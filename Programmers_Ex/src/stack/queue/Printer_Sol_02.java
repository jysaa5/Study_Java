package stack.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 문제: 프린터
// 인쇄 대기목록의 가장 앞에 있는 문서 = J, 중요도가 있는 프린터
// 솔루션 2: 중요도를 순서대로 정렬 후, 그 정렬 순서에 맞춰서 큐에 순서를 확인한다. 

class Solution_02 {
	public int solution(int[] priorities, int location) {

		int answer = 0;
		int l = location;

		// 큐 션언
		Queue<Integer> que = new LinkedList<Integer>();

		for (int i : priorities) {
			que.add(i);
		}

		// 정렬: 중요도 정렬 -> 오름차순으로 정렬
		Arrays.sort(priorities);

		// 배열의 마지막 인덱스 번호
		int size = priorities.length - 1;

		while (!que.isEmpty()) {

			// queue에서 빼내기
			Integer i = que.poll();

			// 꺼낸 값이 가장 큰 중요도 일 때
			if (i == priorities[size - answer]) {

				// 프린트가 되는 순서 1증가
				answer++;

				// 큐에서 데이터가 나갔으므로 위치를 1감소
				l--;

				if (l < 0)
					break;

				// 꺼낸 값이 가장 큰 중요도가 아닐 때.
			} else {

				// 큐 뒤에 데이터 붙이기
				que.add(i);

				// 큐에서 데이터가 나갔으므로 위치를 1감소
				l--;

				// 위치가 맨 처음일 때, 다시 뒤에 붙였으므로 위치가 큐의 맨 뒤이다
				if (l < 0)
					l = que.size() - 1;
			}
		}

		return answer;
	}
}

public class Printer_Sol_02 {

	public static void main(String[] args) {
		Solution_02 sol = new Solution_02();

		// int[] priorities = {2,1,3,2};
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		// int location = 2;
		int location = 0;

		System.out.println(sol.solution(priorities, location));

	}
}