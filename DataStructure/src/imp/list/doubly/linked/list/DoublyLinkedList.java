package imp.list.doubly.linked.list;

//이중연결 리스트
//양방향 연결 리스트
//Java collection Framework의 연결리스트 = doubly linked list 이다.
public class DoublyLinkedList {

	// 제일 처음 노드
	private Node head;

	// 제일 끝에 노드
	private Node tail;

	// LinkedList 크기
	private int size = 0;

	// 노드 = 버텍스 = 객체
	// 데이터 저장, 다음 노드가 누구인지 저장해야 됨.
	private class Node {

		private Object data;

		// 다음 노드의 정보
		private Node next;

		// 이전 노드의 정보
		private Node prev;

		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}

	}

	// addFirst: 가장 앞에 노드를 추가하는 메서드
	// DoublyLinkedList는 이전 노드와 다음 노드의 정보를 모두 갖고 있다.
	public void addFirst(Object input) {
		Node newNode = new Node(input);

		// 새로 만들어진 노드가 이전의 노드의 주소를 head를 경유해서 알게 된다.
		newNode.next = head;

		// head가 null이 아닐때: 맨 처음 추가되는 노드가 아닐 때만.
		if (head != null) {
			// 이전에 맨 처음 노드의 이전노드를 새롭게 추가한 노드를 가리킨다.
			head.prev = newNode;
		}

		// head가 새롭게 추가한 노드를 가리킨다.
		head = newNode;
		// 리스트 사이즈 증가
		size++;

		// 전체 노드가 1개일때: tail이 노드를 가리켜야 한다.
		if (head.next == null) {
			tail = head;
		}
	}

	// addLast: 가장 뒤에 노드를 추가하는 메서드
	public void addLast(Object input) {

		Node newNode = new Node(input);

		// size = 0 이면 데이터가 아예 없는 상태이다. 앞에서 넣건 뒤에서 넣건 똑같으므로.
		// 데이터가 아예 없을 때는 tail이 없으므로 addFirst 메서드를 사용한다.
		if (size == 0) {
			addFirst(input);
		} else {

			// tail: 가장 뒤에 있는 노드
			// 기존 tail 노드의 다음 노드가 새로 생성된 노드이다.
			tail.next = newNode;

			// 새로 추가된 노드의 이전 노드는 추가 하기 이전의 맨 마지막 노드로 가리킨다.
			newNode.prev = tail;

			// 그리고 tail이 새로 생긴 노드가 된다.
			tail = newNode;
			size++;

		}

	}

	// 내부적으로만 사용될 API
	// 테스트를 위해서 public으로 지정
	// public Node node(int index){}
	// 내부적으로만 사용되어야 하므로 public을 제거한다.
	// node 메서드: head부터 쭈욱 찾는 것
	Node node(int index) {

		// 전체 크기로 찾고하자 하는 위치를 판별
		// head에서부터 찾기
		if (index < size / 2) {
			// head를 먼저 찾아야 된다.
			Node x = head;

			for (int i = 0; i < index; i++) {

				x = x.next;

			}
			return x;

			// tail부터 찾기
		} else {

			Node x = tail;

			for (int i = size - 1; i > index; i--) {

				x = x.prev;

			}
			return x;
		}

		// 두 번째
		// x = x.next;

		// 세번째
		// x = x.next;

	}

	// k: 추가하려고 하는 노드의 리스트상의 index값
	// add: 중간에 노드를 삽입 = 이전 노드를 알아야 된다. 그래야 삽입된 노드가 다음 노드를 가리킬수 있다.
	public void add(int k, Object input) {
		// 데이터가 아무것도 없을 때
		if (k == 0) {

			addFirst(input);

		} else {

			// 삽입될 노드 위치의 이전 노드
			Node temp1 = node(k - 1);
			// 삽입될 노드의 이후 노드
			Node temp2 = temp1.next;
			// 새로운 노드 추가
			Node newNode = new Node(input);

			// 새로운 노드의 이전 노드의 다음을 새로운 노드로 지정
			temp1.next = newNode;

			// 새로운 노드의 다음 노드를 다음 위치의 노드로 지정
			newNode.next = temp2;

			// temp2가 있을 때
			if (temp2 != null) {

				// 새로 추가한 노드의 다음 노드가 새로운 노드를 가리키도록 지정
				temp2.prev = newNode;

			}

			// 새로운 노드의 이전 노드로 이전 노드를 가리키게 지정
			newNode.prev = temp1;

			size++;

			// 삽입한 노드가 맨 마지막 노드일 때
			if (newNode.next == null) {

				tail = newNode;

			}

		}
	}

	// 리스트가 가지고 있는 데이터 출력
	public String toString() {

		// 리스트에 데이터가 없을 때.
		if (head == null) {
			return "[]";
		}

		Node temp = head;
		String str = "[";

		while (temp.next != null) {
			// 구분자: ,
			str += temp.data + ",";
			temp = temp.next;

		}

		str += temp.data;

		return str + "]";
	}

	// 데이터 삭제 메서드
	// 데이터가 삭제되면 갖고 있던 데이터 값을 반환한다.
	// removeFirst: 첫 번째 노드 삭제하는 메서드
	public Object removeFirst() {
		// head 값을 temp에 넣는다.
		Node temp = head;
		// head를 다음 노드를 가리키게 한다.
		head = head.next;

		// 삭제할 노드의 데이터 값 저장
		Object returnData = temp.data;
		temp = null;

		if (head != null) {
			head.prev = null;
		}

		// 리스트 사이즈 감소시킨다.
		size--;

		return returnData;
	}

	// k: index(인덱스)
	// remove: 리스트의 인덱스에 해당하는 노드를 삭제하는 메서드
	public Object remove(int k) {

		// 리스트의 인덱스 0일 때.
		if (k == 0) {
			return removeFirst();
		}

		// 리스트 삭제할 때, 이전 노드를 알아야 된다. 이전 노드에서 next값을 바꿔줘야 하기 때문이다.
		// 삭제 = 링크가 없어진다는 의미
		// 삭제할 노드의 이전 노드
		Node temp = node(k - 1);
		// 삭제할 노드
		Node todoDeleted = temp.next;

		// temp의 다음 노드 = temp의 다음노드의 다음 노드
		temp.next = temp.next.next;

		// temp의 다음 노드가 있을 때
		if (temp.next != null) {

			temp.next.prev = temp;

		}

		Object returnData = todoDeleted.data;

		// 삭제할 노드가 제읾 마짐가 노드 일때
		if (todoDeleted == tail) {
			tail = temp;
		}

		todoDeleted = null;
		// 사이즈 감소
		size--;
		return returnData;

	}

	// removeLast: 리스트의 맨 마지막 노드를 삭제하는 메서드
	public Object removeLast() {

		return remove(size - 1);
	}

	// size: 리스트의 길이를 반환하는 메서드
	public int size() {
		return size;
	}

	// get: 리스트 인덱스에 해당하는 노드의 데이터 값을 반환하는 메서드
	// k: 리스트 index
	public Object get(int k) {
		Node temp = node(k);

		return temp.data;
	}

	// indexOf: 데이터가 리스트에서의 위치를 반환하는 메서드
	public Object indexOf(Object data) {
		Node temp = head;
		int index = 0;

		// 현재 temp의 값과 인자로 데이터로 들어온 데이터의 값이 같지 않다면 반복
		while (temp.data != data) {
			
			temp = temp.next;
			index++;
			
			// 마지막 노드에 도달했지만 인자로 들어온 데이터가 없을 때.
			if (temp == null) {
				
				return -1;
				
			}
		}
		return index;
	}

	// listIterator: ListIterator 객체를 생성해서 반환하는 메서드
	public ListIterator listIterator() {

		return new ListIterator();

	}// listIterator 종료

	// ListIterator 클래스
	public class ListIterator {

		// next 변수: 첫번째 요소부터 마지막 요소까지 차례대로 가리킨다.
		private Node next;
		// lastReturned 변수: 반환할 값
		private Node lastReturned;
		// nextIndex 변수: next변수가 가리키고 있는 노드의 인덱스
		private int nextIndex;

		// 생성자
		ListIterator() {
			next = head;
		}

		// next 메서드: 첫번째의 노드의 값이 반환되고 그 다음 next를 호출했을 때, 리턴된 값을 가리킨다.
		// next 메서드가 호출될 때마다 리스트의 값이 반환된다.
		public Object next() {

			lastReturned = next;
			next = next.next;
			nextIndex++;

			return lastReturned.data;
		}

		// hasNext: 다음 next 변수가 null인지 안닌지 true 또는 false로 반환하는 메서드
		public boolean hasNext() {
			return nextIndex < size();
		}

		// add: 노드 삽입
		public void add(Object input) {
			Node newNode = new Node(input);

			// 맨 처음에 노드가 삽입 될 때.next는 기존의 노드중에서 맨 처음을 가리킨다.
			// lastReturned는 null 상태이다.
			if (lastReturned == null) {

				head = newNode;
				newNode.next = next;

				// 중간에 삽입
			} else {

				lastReturned.next = newNode;
				newNode.prev = lastReturned;

				if (next != null) {

					newNode.next = next;
					next.prev = newNode;

				} else {

					tail = newNode;

				}

			}

			lastReturned = newNode;
			nextIndex++;
			size++;
		}

		// 삭제
		// lastReturned인 것을 삭제 한다.
		// remove: 노드 삭제 = 연결을 제거하는 것을 의미한다.
		public void remove() {

			// next를 한번도 호출 하지 않았을 때 = 아무런 요소를 선택하지 않은 상태 = next가 첫번째 노드를 가리킬 때
			if (nextIndex == 0) { // lastReturned == null 과 같은 조건

				throw new IllegalStateException();

			}

			// lastReturned의 다음 노드
			Node n = lastReturned.next;

			// lastReturned의 이전 노드
			Node p = lastReturned.prev;

			//가장 첫 번째 노드 삭제시 
			if (p == null) {
				
				head = n;
				head.prev = null;
				lastReturned = null;
				
			} else {
				
				p.next = next;
				lastReturned.prev = null;
				
			}
			
			//중간 노드 삭제시
			if (n == null) {
				
				tail = p;
				tail.next = null;
				
			} else {
				
				n.prev = p;
				
			}

			//마지막 노드 삭제시
			if (next == null) {
				
				lastReturned = tail;
			
			} else {

				lastReturned = next.prev;
			}
			
			size--;
			nextIndex--;

		}

		// previous 메서드: 이전 노드 탐색하는 메서드
		public Object previous() {

			// next의 탐색이 모두 끝난 상태
			if (next == null) {

				lastReturned = next = tail;

			} else {
				lastReturned = next = next.prev;
			}

			nextIndex--;

			return lastReturned.data;
		}

		// previous를 호출 해도 되는가. 이전 노드가 있는가.
		// hasPrevious 메서드: nextIndex에 의해서 결정된다.
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

	}// ListIterator 종료

}// LinkedList 종료