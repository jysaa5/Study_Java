package lmp.list.linkedList.alg.deleteNode;

//단방향 Linked List에서 중간에 있는 노드를 삭제하시오. 단, 당신은 첫번째 노드가 어딨는지 모르고,
//오직 삭제할 노드만 갖고 있다.
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

	// removeDups: 중복을 제거하는 메서드
	void removeDups() {

		Node n = header;

		while (n != null && n.next != null) {

			Node r = n;

			// 마지막 노드값까지 가지 않는다.
			while (r.next != null) {

				if (n.data == r.next.data) {

					r.next = r.next.next;

				} else {

					r = r.next;

				}

			}

			n = n.next;

		}

	}// removeDups 종료

	// kthToLast: 뒤에서부터 k번째 데이터 찾는 메서드
	// k: 뒤에서부터 k번째
	Node kthToLast(Node first, int k) {
		Node p1 = first;
		Node p2 = first;

		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null;
			}
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;

	}// kthToLast 종료

	
	// get 메서드
	Node get(int i) {
		Node n = header;
		for (int j = 0; j < i; j++) {
			n = n.next;
		}
		return n;
	}// get 종료

	
	// deleteNode 메서드: 처음과 마지막 노드는 지울 수 없다.
	boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;

		return true;

	}// deleteNode 종료

}// LinkedList 종료


//LinkedList_deleteNode_sol 클래스
public class LinkedList_deleteNode_sol {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		ll.deleteNode(ll.get(2));
		ll.retrieve();


	}// main 종료

}// LinkedList_deleteNode_sol 종료
