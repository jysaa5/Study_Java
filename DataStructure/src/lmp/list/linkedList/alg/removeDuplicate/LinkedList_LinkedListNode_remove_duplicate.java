package lmp.list.linkedList.alg.removeDuplicate;

//LinkedList 클래스: Node 구현한 연결 리스트를 보완한 것이다. 
class LinkedList{
	
	//header 노드
	Node header;

	//Node 클래스
	static class Node {

		int data;
		
		Node next = null;

	}//Node 종료

	//생성자
	LinkedList() {
		
		header = new Node();

	}

	
	//append 메서드: 노드 삽입
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

	}//append 종료

	
	//delete 메서드: 노드 삭제
	//head: 누가 첫 번째 노드인지 알려준다.
	//첫 번째 head 값 삭제가 가능하다. head는 데이터로 쓰이지 않고 관리용도로만 쓰인다.
	void delete(int d) {

		//포인터 생성
		Node point = header;

		//현재 노드에서 다음 노드 비교: 맨 마지막 노드 값까지 반복
		while (point.next != null) {

			//현재 노드에서 다음 노드 데이터가 삭제할 노드인지 판단
			if (point.next.data == d) {

				//현재 노드에서 가리키던 다음 노드를 그 다음 다음 노드로 바꾼다.
				point.next = point.next.next;

			} else {
			
				//값을 찾기 위해서 다음 노드로 이동
				point = point.next;
		
			}
		
		}
		
	}//delete 종료

	
	//retrieve 메서드: 리스트에 있는 데이터를 처음부터 끝까지 쭉 보여주는 메서드
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
		
	}//retrieve 종료
	
	
	//removeDups: 중복을 제거하는 메서드
	void removeDups() {
		
		Node n = header;
		
		while (n != null && n.next !=null) {
		
			Node r = n;
			
			//마지막 노드값까지 가지 않는다.
			while(r.next != null) {
				
				if (n.data == r.next.data) {
					
					r.next = r.next.next;
				
				}else {
			
					r = r.next;
			
				}
				
			}
			
			n = n.next;
		
		}
		
	}//removeDups 종료

}//LinkedList 종료


//LinkedList_LinkedListNode 클래스
public class LinkedList_LinkedListNode_remove_duplicate {
	
	//main 메서드: 실행 메서드
	public static void main(String[] args) {
	
		LinkedList ll = new LinkedList();
//		ll.append(2);
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.append(4);
//		ll.append(2);
//		ll.retrieve();
//		ll.removeDups();
//		ll.retrieve();
		
		ll.append(2);
		ll.append(2);
		ll.retrieve();
		ll.removeDups();
		ll.retrieve();
	
	}//main 종료

}//LinkedList_LinkedListNode 종료
