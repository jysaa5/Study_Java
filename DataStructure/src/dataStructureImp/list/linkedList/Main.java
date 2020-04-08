package dataStructureImp.list.linkedList;

//Main: 실행 클래스
public class Main {
	
	public static void main(String[] args) {
	
		LinkedList numbers = new LinkedList();
		
		//맨 처음에 노드에 노드 추가
		//numbers.addFirst(30);
		//numbers.addFirst(20);
		//numbers.addFirst(10);
		
		//맨 마지막에 노드 추가
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//numbers.addFirst(5);
		//numbers.add(1, 15);
		
		//node 인덱스 0번이 반환된다.
		//System.out.println(numbers.node(0));
		//System.out.println(numbers.node(1));
		//System.out.println(numbers.node(2));
		
		//index: 1 , data: 15 -> 20이 뒤로 밀려서 10과 20사이에 15가 들어간다.
		//numbers.add(1, 15);
		//numbers.add(2, 25);
		
		//toString
		//System.out.println(numbers);
		
		//기존의 데이터 삭제 
		//numbers.removeFirst();
		//System.out.println(numbers.removeFirst());
		//System.out.println(numbers);
	
		//LinkedList: remove, removeLast
		//numbers.addLast(5);
		//numbers.addLast(10);
		//numbers.addLast(15);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//System.out.println(numbers);
		//특정 데이터 삭제
		//데이터 5를 삭제한다.
		//System.out.println(numbers.remove(2));
		//System.out.println(numbers);
		//System.out.println(numbers.removeLast());
		
		//LinkedList: size, get
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//System.out.println(numbers);
		//System.out.println(numbers.size());
		//노드의 인덱스의 값을 반환한다.
		//System.out.println(numbers.get(0));
		
		//LinkedList: indexOf
		//indexOf: 조회기능 메서드
		//System.out.println(numbers.indexOf(5));
		
		//LinkedList: Iterator next
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//System.out.println(i.next());
		//System.out.println(i.next());
		//System.out.println(i.next());
		
		
		//LinkedList: Iterator hasNext
		//numbers.addLast(10);
		//numbers.addLast(20);
		///numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//System.out.println(i.next());
		//System.out.println(i.next());
		//true 반환
		//System.out.println(i.hasNext());
		//System.out.println(i.next());
		//false 반환
		//System.out.println(i.hasNext());
		
		//while(i.hasNext()) {
		//	System.out.println(i.next());
		//}
		
		//LinkedList: Iterator add
		//numbers.addLast(10);
		//numbers.addLast(20);
		//numbers.addLast(30);
		//LinkedList.ListIterator i = numbers.listIterator();
		//next가 맨 처음 노드를 가리키고 있기 때문에 맨 처음에 노드가 추가 된다.
		//i.add(5);
		//i.next();
		//lastReturned가 가리키는 노드와 next가 가리키는 노드 사이에 삽입된다.
		//i.add(15);
		//System.out.println(numbers);
		
		//LinkedList: Iterator remove
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		LinkedList.ListIterator i = numbers.listIterator();
		//next가 맨 처음 노드를 가리키고 있고 lastReturned는 아무것도 가리키지 않기 때문에
		//삭제할 것이 없으므로 삭제하면 오류가 발생한다.
		//add일 때도 lastReturned 자리에 노드를 삽입하는 것이다.
		//remove일 때도 lastReturned 자리에 노드를 제거한다.
		i.remove();
		
	}
	

}
