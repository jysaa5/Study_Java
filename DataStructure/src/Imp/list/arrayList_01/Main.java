package Imp.list.arrayList_01;

//Main 클래스
public class Main {

	//main 메서드
	public static void main(String[] args) {
		
		ArrayList numbers = new ArrayList();
		
		//마지막에 추가 하기
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		//numbers.add(1, 15);
		//numbers.addFirst(5);
		
		//System.out.println(numbers);
		//numbers.remove(1);
		//System.out.println(numbers.remove(1));
		//System.out.println(numbers);
		
		//numbers.removeFirst();
		//numbers.removeLast();
		//System.out.println(numbers);

		//ArrayList: get
		//System.out.println(numbers.get(0));
		//System.out.println(numbers.get(1));
		//System.out.println(numbers.get(2));
		//System.out.println(numbers.get(3));
		
		//ArrayList: size indexOf
		//System.out.println(numbers.size());
		//System.out.println(numbers.indexOf(70));
	
		
		//ArrayList: iterator next hasNext
		//for(int i=0; i<numbers.size(); i++) {
			
		//	System.out.println(numbers.get(i));
		
		//}
		
		//ArrayList 안에 있는 ListIterator의 클래스
		//listIterator: ListIterator의 클래스 안에 있는 메서드이다.
		//ArrayList.ListIterator li = numbers.listIterator();
		
		//while(li.hasNext()) {
		//	System.out.println(li.next());
		//}
		
		//ArrayList: Iterator previous hasPrevious
		//ArrayList.ListIterator li = numbers.listIterator();
		//System.out.println(li.next());
		//System.out.println(li.next());
		//System.out.println(li.next());
		//System.out.println(li.next());
		//System.out.println(li.previous());
		//System.out.println(li.previous());
		//System.out.println(li.previous());
		//System.out.println(li.previous());

		//while(li.hasNext()) {
		//	System.out.println(li.next());
		//}
		
		//while(li.hasPrevious()) {
		//	System.out.println(li.previous());
		//}
		
		
		//ArrayList: Iterator add remove
		ArrayList.ListIterator li = numbers.listIterator();
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.remove();
				li.add(35);
				
			}
			System.out.println(numbers);
		}
		
	}//main 종료

}//Main 종료
