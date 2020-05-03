package Imp.queue.alg.twoStackMakeQueue;

import java.util.Stack;

//문제: 두 개의 Stack(스택)으로 하나의 Queue(큐)를 구현하라.
//풀이: 
//1. New Stack, Old Stack 만들기
//2. add 할 때는 New에 넣는다.
//3. peek, remove를 할 때는 New에 있는 것을 old로 옮긴 후에 진행한다.

class MyQueue<T> {
	
	//스택 객체 선언
	Stack<T> stackNewest, stackOldest;

	// 생성자
	MyQueue() {
		
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();

	}

	// size 메서드: 스택의 전체 사이즈 반환 하는 메서드
	public int size() {
	
		return stackNewest.size() + stackOldest.size();
	
	}// size 종료

	
	//add 메서드: 스택 데이터 추가 
	public void add(T value) {
		
		stackNewest.push(value);

	}//add 메서드 종료

	
	//shiftStacks 메서드: stackOldest가 비어 있을 때만 실행되어야 한다.
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			
			//stackNewest에 모든 데이터가 빌 때까지 반복
			while(!stackNewest.isEmpty()) {
				//stackNewest에 있는 데이터를 꺼내어서 stackOldest에 넣는다.
				stackOldest.push(stackNewest.pop());
			}
			
		}
	
	}//shiftStacks 메서드 종료
	
	//peek 메서드: 데이터 맨 위에 있는 거 꺼내서 보는 기능
	public T peek() {
		
		shiftStacks();
		return stackOldest.peek();
	
	}//peek 메서드 종료
	
	
	//remove 메서드: 데이터 맨 위에 있는 거 꺼내서 반환하고 지우는 기능
	public T remove() {
		
		shiftStacks();
		return stackOldest.pop();
	
	}//remove 메서드 종료
	
	
}//MyQueue 클래스 종료

//Queue_alg_Imp 클래스 
public class Queue_alg_Imp {

	// main 메서드: 실행 함수
	public static void main(String[] args) {

		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		
	}// main 메서드 종료
	
}//Queue_alg_Imp 종료
