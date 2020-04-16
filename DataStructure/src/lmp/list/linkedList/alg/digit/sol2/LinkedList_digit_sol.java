package lmp.list.linkedList.alg.digit.sol2;

//문제: 어떤 숫자를 자리수별로 Linked List에 담았다.그런데 가장 높은 자리수가 header에 오도록 담았다. 
//이런식의 LinkedList 두 개를 받아서 합산하고 같은 식으로 Linked List에 담아서 반환하라.
// 419 = 4 -> 1 -> 9
// 34  =      3 -> 4
// 숫자들의 길이를 계산해서 자리수가 부족한 부분에 0을 채운다.
// 419 = 4 -> 1 -> 9
// 34  = 0 -> 3 -> 4
// 뒤에서부터 계산한다.
// 결과값을 carry로 사용해야 한다. 합계 결과를 저장한 노드를 받을 수 없다.
// 그러므로 carry와 노드가 있는 객체로 만든다.
//solution: 재귀호출

//L1:        4 -> 1 -> 9 -> null
//L2:        0 -> 3 -> 4 -> null

//객체
//초기화
//합산 결과: 0
//C(carry): 0
//R(Result): null

//합산 결과: 3
//C(carry): 1
//R(Result): 3 -> null

//합산 결과: 5
//C(carry): 0
//R(Result): 5 -> 3 -> null

//합산 결과: 4
//C(carry): 0
//R(Result): 4 -> 5 -> 3 -> null

//모든 계산이 끝난 후에도 carry값이 0 초과일때는 한 번더 합산을 한다.그 후 R 앞에 추가한다.

class LinkedList {

	// header 노드
	Node header;

	// Node 클래스
	static class Node {

		int data;

		Node next = null;

		// 생성자
		public Node() {

		}

		// 생성자
		public Node(int data) {

			this.data = data;

		}

	}// Node 종료

	
	// Storage 클래스: 연산에 필요한 carry와 result을 갖고 있는 클래스 선언
	static class Storage {

		int carry = 0;
		
		//결과값 저장 노드
		Node result = null;

	}// Storage 종료

	// 생성자
	LinkedList() {

		header = new Node();

	}

	
	// append 메서드: 노드 삽입
	void append(int d) {
		// 새로운 노드 생성
		Node end = new Node();

		end.data = d;

		// 포인터 생성
		Node point = header;

		// 현재 노드에서 다음 노드 비교: 맨 마지막 노드 값 찾기
		while (point.next != null) {
			point = point.next;
		}

		// 새로운 노드 추가
		point.next = end;

	}// append 종료

	
	// delete 메서드: 노드 삭제
	// head: 누가 첫 번째 노드인지 알려준다.
	// 첫 번째 head 값 삭제가 가능하다. head는 데이터로 쓰이지 않고 관리용도로만 쓰인다.
	void delete(int d) {

		// 포인터 생성
		Node point = header;

		// 현재 노드에서 다음 노드 비교: 맨 마지막 노드 값까지 반복
		while (point.next != null) {

			// 현재 노드에서 다음 노드 데이터가 삭제할 노드인지 판단
			if (point.next.data == d) {

				// 현재 노드에서 가리키던 다음 노드를 그 다음 다음 노드로 바꾼다.
				point.next = point.next.next;

			} else {

				// 값을 찾기 위해서 다음 노드로 이동
				point = point.next;

			}
		}

	}// delete 종료

	
	// retrieve 메서드: 리스트에 있는 데이터를 처음부터 끝까지 쭉 보여주는 메서드
	void retrieve() {

		// point 생성
		Node point = header.next;

		// 마지막 노드 전 단계까지 반복
		while (point.next != null) {

			System.out.print(point.data + "->");

			// 다음 노드로 이동
			point = point.next;

		}

		// 맨 마지막 노드 출력
		System.out.println(point.data);

	}// retrieve 종료

	
	// get 메서드
	Node get(int i) {
		Node n = header;
		for (int j = 0; j < i; j++) {
			n = n.next;
		}
		return n;
	}// get 종료

	
	// sumLists: Linked List Digit 합산 알고리즘 메서드
	// l1: LinkedList의 피연산자1, l2: LinkedList의 피연산자2
	// carry: 받아올림
	static Node sumLists(Node l1, Node l2, int carry) {

		//첫번째 LinkedList의 길이
		int len1 = getListLength(l1);
		//두번째 LinkedList의 길이
		int len2 = getListLength(l2);

		//리스트 길이가 차이가 나면 0을 앞에 붙인다.
		if (len1 < len2) {
			
			l1 = LPadList(l2, len2 - len1);
			
		} else {
			
			l2 = LPadList(l2, len1 - len2);
			
		}

		//덧셈 수행
		Storage storage = addLists(l1, l2);

		//뎃샘이 모두 수행 후에도 carry가 0이 아닐때, carry를 결과 노드 앞에 붙인다.
		if(storage.carry != 0) {
			
			storage.result =insertBefore(storage.result, storage.carry);

		}
		
		return storage.result;
	}// sumLists 종료
	
	
	//addLists: 덧셈을 하는 메서드
	static Storage addLists(Node l1, Node l2) {
		
		//LinkedList 맨 끝까지 간다.
		if (l1 == null && l2 == null) {
			
			Storage storage = new Storage();
			
			return storage;
		}
		
		Storage storage = addLists(l1.next, l2.next);
		
		//전체 덧셈 값 저장
		int value = storage.carry + l1.data + l2.data;
		
		//결과값 저장
		int data = value % 10;
		
		//결과 노드에 노드 추가하기
		storage.result = insertBefore(storage.result, data);
		
		//캐리값 저장
		storage.carry = value / 10;
		
		
		return storage;

	}//addLists 종료

	
	// getListLength: LinkedList의 크기를 계산하는 메서드
	static int getListLength(Node l) {

		int total = 0;

		// 노드를 돌면서 개수 세는 구간
		while (l != null) {

			total++;

			l = l.next;
		}

		return total;

	}// getListLength 종료

	
	// insertBefore 메서드: 결과 노드 앞에 새로운 노드를 추가하는 메서드
	static Node insertBefore(Node node, int data) {

		//받아온 데이터 값으로 새로운 노드 생성
		Node before = new Node(data);

		if (node != null) {

			//결과값 Linked List 앞에 넣기
			before.next = node;

		}
		return before;
	}//insertBefore 종료

	
	// LPadList 메서드: 0으로 채우는 메서드
	static Node LPadList(Node l, int length) {
		
		Node head = l;
		
		//head 앞에 0을 붙이는 부분
		for (int i = 0; i < length; i++) {
		
			head = insertBefore(head, 0);
		
		}
		
		return head;
		
	}//LPadList 종료

}// LinkedList 종료


//LinkedList_digit_sol 클래스
public class LinkedList_digit_sol {

	//main 메서드: 메인 실행 함수
	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.retrieve();

		LinkedList l2 = new LinkedList();
		l2.append(1);
		l2.append(1);
		l2.retrieve();

		LinkedList.Node n = LinkedList.sumLists(l1.get(1), l2.get(1), 0);
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);

	}// main 종료

}// LinkedList_digit_sol 종료
