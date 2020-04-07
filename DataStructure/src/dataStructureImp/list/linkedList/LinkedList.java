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
	
	//가장 앞에 노드를 추가하는 메서드
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
	
	//가장 뒤에 노드를 추가하는 메서드
	public void addLast(Object input) {
		
		Node newNode = new Node(input);
		
		//size = 0 이면 데이터가 아예 없는 상태이다. 앞에서 넣건 뒤에서 넣건 똑같으므로.
		//데이터가 아예 없을 때는 tail이 없으므로 addFirst 메서드를 사용한다.
		if(size == 0) {
			addFirst(input);
		}else {
			
			//tail: 가장 뒤에 있는 노드 
			//기존 tail 노드의 다음 노드가 새로 생성된 노드이다.
			tail.next = newNode;
			//그리고 tail이 새로 생긴 노드가 된다.
			tail = newNode;
			size ++;
		
		}
		
	}
	
	//내부적으로만 사용될 API
	//테스트를 위해서 public으로 지정
	//public Node node(int index){}
	//내부적으로만 사용되어야 하므로 public을 제거한다.
	Node node(int index) {
		
		//head를 먼저 찾아야 된다.
		Node x = head;
		
		//두 번째
		//x = x.next;
		
		//세번째
		//x = x.next;
		
		for(int i =0; i<index; i++) {
			
			x = x.next;
		
		}
		return x;
	}
	
	//k: 추가하려고 하는 노드의 리스트상의 index값
	//add: 중간에 노드를 삽입 = 이전 노드를 알아야 된다. 그래야 삽입된 노드가 다음 노드를 가리킬수 있다.
	public void add(int k, Object input) {
		//데이터가 아무것도 없을 때
		if(k == 0) {
			
			addFirst(input);
		
		}else {
			
			//삽입될 노드의 이전 노드
			Node temp1 = node(k-1);
			//삽입될 노드의 이후 노드
			Node temp2 = temp1.next;
			//새로운 노드 추가
			Node newNode = new Node(input);
			temp1.next = newNode;
			newNode.next = temp2;
			size ++;
			
			//삽입한 노드가 맨 마지막 노드일 때
			if(newNode.next ==null) {
				tail = newNode;
			}
		
		}
	}
	
}//LinkedList 종료