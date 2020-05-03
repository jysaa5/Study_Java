package Imp.stack;

import java.util.EmptyStackException;

// stack(스택): 쌓다. 맨 마지막에 넣은 데이터가 맨 처음에 나온다.
// LIFO (후입선출): Last In, First Out
// pop(): 맨 마지막에 넣은 데이터를 꺼내면서 지우는 기능
// push(): 새로운 데이터를 맨 위에 쌓아 올리는 기능
// peek(): 맨 마지막 데이터를 보는 기능
// isEmpty(): 스택에 데이터가 있는지 없는지 확인하는 기능

//stack 클래스 선언
class Stack<T>{
	
	// 같은 타입을 받는 객체
	class Node<T>{
		
		//데이터
		private T data;
		
		//다음 노드
		private Node<T> next;
		
		//생성자
		public Node (T data) {
		
			this.data = data;
		
		}
		
	}//Node 클래스 종료
	
	// 스택은 맨 위에 올라가 있는 객체 주소만 알면 된다.
	// 스택 구조에서 맨 위에 있는 데이터
	private Node<T> top;
	
	//pop 메서드: 맨 마지막에 넣은 데이터를 꺼내면서 지우는 기능.
	public T pop() {
		
		//top이 아무것도 없을 때
		if(top == null) {
			throw new EmptyStackException();
		}
		
		// 반환할 데이터 저장.
		T item = top.data;
		
		//맨 위에 있는 데이터를 반환하기 전에, 그 다음에 있는 데이터를 top으로 만들어야 한다. 
		top = top.next;
		
		return item;
		
	}//pop 종료
	
	
	//push 메서드: 새로운 데이터를 맨 위에 쌓아 올리는 기능
	public void push(T item) {
		
		//item을 가지고 노드 생성
		Node<T> t = new Node<T>(item);
		
		//top 앞에 생성한 노드를 위치시킨다.
		t.next = top;
		
		//생성한 노드가 top이 된다.
		top = t;
		
	}//push 종료
	
	
	//peek 메서드: 맨 마지막 데이터를 보는 기능
	public T peek() {
		
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
		
	}//peek 종료
	
	
	//isEmpty 메서드: 스택에 데이터가 있는지 없는지 확인하는 기능
	public boolean isEmpty() {
		
		return top == null;
		
	}//isEmpty 종료
	
}//Stack 클래스 종료


//Stack_Imp 클래스
public class Stack_Imp {

	//main 메서드: 실행 함수
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	
	}//main 종료
	
}//Stack_Imp 종료
