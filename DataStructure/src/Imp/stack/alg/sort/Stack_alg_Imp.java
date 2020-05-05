package Imp.stack.alg.sort;

import java.util.Stack;

// 문제: Stack을 정렬하는 함수를 만드시오. 단 하나의 Stack을 추가로 사용할 수 있고
// Array(배열) 등을 다른 데이터 구조는 사용할 수 없다.
// s1: 정렬이 되어 있지 않은 Stack
// s2: 그냥 비어 있는 Stack
// Solution: 맨 위에가 작은 수로 되어서 오름차순으로 정렬

//Stack_alg_Imp 클래스
public class Stack_alg_Imp {

	//sort 메서드: stack s1을 맨 위에부터 오름차순으로 정렬하는 메서드
	private static void sort(Stack<Integer> s1) {

		//s2: 비어있는 스택 선언
		Stack<Integer> s2 = new Stack<Integer>();

		//s1이 빌때까지 반복
		while (!s1.isEmpty()) {
			
			//s1의 맨 위에 있는 것을 꺼내기
			int tmp = s1.pop();

			//s2가 비어 있지 않으면서, 맨 위에 있는 것이 s1에서 꺼낸 것 보다 클 때 반복
			while (!s2.isEmpty() && s2.peek() > tmp) {
			
				//s2의 맨 위에 것을 꺼내서 s1에 넣는다.
				s1.push(s2.pop());
			
			}
			
			//s2에 s1에서 꺼낸 것을 넣는다.
			s2.push(tmp);
		}

		//s2가 빌때까지 다 꺼내서 오름차순으로 s1에 넣기.
		while (!s2.isEmpty()) {
			
			//s2에 있는 것을 꺼내서 s1에 넣기 = 정렬됨.
			s1.push(s2.pop());
		
		}
	}

	//main 메서드: 실행 함수
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		
		//stack s1: 3 5 1 6 = 입구
		
		//정렬
		sort(s1);
		
		//stack s1: 6 5 3 1 = 입구
		
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());

		
	}//main 메서드 종료

}//Stack_alg_Imp 클래스 종료