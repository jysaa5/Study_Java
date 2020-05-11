package imp.list.linked.list;

//단방향 연결 리스트
//Node 클래스: 노드로 구현
class Node{
	
	//데이터: 보통은 Object를 넣는다.
	int data;
	//다음 노드를 갖고 있어야 되므로 생성한다. 초기값 = null
	Node next = null;
	
	//생성자
	Node(int d){
		
		this.data = d;
	}

	//append 메서드: 노드 삽입
	void append(int d) {
		//새로운 노드 생성
		Node end = new Node(d);
		
		//포인터 생성
		Node point = this;
		
		//현재 노드에서 다음 노드 비교: 맨 마지막 노드 값 찾기
		while (point.next != null) {
			point = point.next;
		}
		
		//새로운 노드 추가
		point.next = end;
		
	}//append 종료
	
	//delete 메서드: 노드 삭제
	//head: 누가 첫 번째 노드인지 알려준다.
	//첫 번째 head는 삭제하지 못하도록 한다.
	//head는 연결 리스트를 대표하는 첫번째 노드이기 때문에 삭제가 되면, 다른 객체가 삭제된 head를 갖게 되면 문제가 된다.
	void delete(int d) {
		
		//포인터 생성
		Node point = this;
		
		//현재 노드에서 다음 노드 비교: 맨 마지막 노드 값까지 반복
		while(point.next != null){
			
			//현재 노드에서 다음 노드 데이터가 삭제할 노드인지 판단
			if (point.next.data == d) {
				
				//현재 노드에서 가리키던 다음 노드를 그 다음 다음 노드로 바꾼다.
				point.next = point.next.next;
	
			}else {
				// 값을 찾기 위해서 다음 노드로 이동
				point = point.next;
			}
		}
		
	}//delete 종료
	
	//retrieve 메서드: 리스트에 있는 데이터를 처음부터 끝까지 쭉 보여주는 메서드
	void retrieve() {
		//point 생성
		Node point = this;
		
		//마지막 노드 전 단계까지 반복
		while (point.next !=null ) {
			System.out.print(point.data + "->");
			// 다음 노드로 이동
			point = point.next;
		}
		//맨 마지막 노드 출력
		System.out.println(point.data);
		
	}//retrieve 종료

}//Node 종료

//LinkedList_Node: 단방향 리스트
public class LinkedList_Node {
	
	//main 메서드
	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.delete(3);
		head.retrieve();
		
	}//main 종료

}// LinkedList_Node 종료

