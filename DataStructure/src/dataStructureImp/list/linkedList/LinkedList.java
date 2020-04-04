package dataStructureImp.list.linkedList;

public class LinkedList {
	
	//제일 처음 노드
	private Node head;
	
	//제일 끝에 노드
	private Node tail;

	//LinkedList 크기
	private int size = 0; 
	
	//노드 = 버텍스 = 객체 
	//데이터 저장, 다음 노드가 누구인지 저장해야 됨.
	private class Node{
		
		private Object data; 
		
		//다음 노드의 정보
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
		
	}
	
	//가장 앞에 노드 추가하는 메서드
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		
		//새로 만들어진 노드가 이전의 노드의 주소를 head를 경유해서 알게 된다.
		newNode.next = head;
		
		//head가 생성한 노드를 가리킨다.
		head = newNode;
		//리스트 사이즈 증가
		size ++;
		
		//전체 노드가 1개일때: tail이 노드를 가리켜야 한다.
		if(head.next == null ) {
			tail = head;
		}
	}
	
}
