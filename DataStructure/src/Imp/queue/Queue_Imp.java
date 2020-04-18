package Imp.queue;

import java.util.NoSuchElementException;

// Queue(큐): 먼저 넣은 데이터를 먼저 꺼내는 자료구조이다.
// FIFO: First In, First Out
// add(): 맨 끝에 데이터 추가하는 기능
// remove(): 맨 앞에서 데이터를 한 개 꺼내고 지우기 기능
// peek(): 맨 앞에 있는 데이터를 보는 기능
// isEmpty(): 큐가 비어있는지 확인하는 기능

// Queue 클래스
class Queue<T> {

	// Node 클래스
	class Node<T> {

		// 데이터
		private T data;
		// 다음 노드
		private Node<T> next;

		// 생성자
		public Node(T data) {
			this.data = data;
		}

	}// Node 클래스 종료

	// 큐는 앞과 뒤의 주소를 알고 있어야 한다.
	// 맨 처음 노드
	private Node<T> first;

	// 맨 마지막 노드
	private Node<T> last;

	// add 메서드: 데이터 추가
	public void add(T item) {
	
		// 노드 생성
		Node<T> t = new Node<T>(item);

		// 마지막 노드가 있을 때
		if (last != null) {
		
			last.next = t;
	
		}

		// 추가한 노드가 맨 마지막 노드
		last = t;

		// 큐가 비어있을 때
		if (first == null) {
		
			first = last;
		
		}

	}// add 메서드 종료

	
	//remove 메서드
	public T remove() {
		
		// 큐가 비어 있을 때
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}

		// 데이터 임시 저장
		T data = first.data;
		
		// 맨 처음 노드의 다음 노드에 있던 것을 맨 처음으로 만든다.
		first = first.next;

		//큐가 비어 있을 때
		if (first == null) {
		
			last = null;
		
		}
		
		return data;

	}// remove 메서드 종료

	
	// peek 메서드
	public T peek() {
		
		//큐가 비어 있을 때
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}
	
		return first.data;
	
	}// peek 메서드 종료

	
	//isEmpty 메서드
	public boolean isEmpty() {
	
		return first == null;

	}//isEmpty 메서드 종료

}//Queue 클래스 종료

//Queue_Imp 클래스
public class Queue_Imp {
	
	//main 메서드: 실행 함수
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
	
	}//main 함수 종료

}//Queue_Imp 클래스 종료