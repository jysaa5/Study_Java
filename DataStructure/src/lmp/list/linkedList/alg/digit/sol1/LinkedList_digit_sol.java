package lmp.list.linkedList.alg.digit.sol1;

//문제: 어떤 숫자를 자리수별로 Linked List에 담았다.그런데 1의 자리수가 header에 오도록 거꾸로 담았다. 
//이런식의 LinkedList 두 개를 받아서 합산하고 같은 식으로 Linked List에 담아서 반환하라.
// 419 = 9 -> 1 -> 4
// 346 = 6 -> 4 -> 3
// 합: 765 = 5 -> 6 -> 7
//solution: 재귀호출

//L1:        9 -> 1 -> 4 -> null
//L2:        6 -> 4 -> 3 -> null
//C(carry):  0    1    0    0
//R(Result): 5 -> 6 -> 7
//header : 5

class LinkedList {

	// header 노드
	Node header;

	// Node 클래스
	static class Node {

		int data;

		Node next = null;

	}// Node 종료

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

		if (l1 == null && l2 == null && carry == 0) {
			
			return null;
		
		}

		// 결과값 노드
		Node result = new Node();

		// 합산한 결과값
		int value = carry;

		if (l1 != null) {
			
			value += l1.data;
		
		}

		if (l2 != null) {
			
			value += l2.data;
		
		}

		//carry되는 것을 제외하고 저장
		result.data = value % 10;

		if (l1 != null || l2 != null) {
			
			Node next = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
		
			//각 자리수 결과값 연결
			result.next = next;
		
		}

		return result;

	}

}// LinkedList 종료

//LinkedList_digit_sol 클래스
public class LinkedList_digit_sol {

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();
		
		LinkedList l2 = new LinkedList();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.retrieve();
		
		
		LinkedList.Node n = LinkedList.sumLists(l1.get(1), l2.get(1), 0);
		while(n.next !=null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
		

	}// main 종료


}// LinkedList_digit_sol 종료
