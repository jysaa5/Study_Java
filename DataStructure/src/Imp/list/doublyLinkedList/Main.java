package Imp.list.doublyLinkedList;

import Imp.list.doublyLinkedList.DoublyLinkedList.ListIterator;

//Main: 실행 클래스
public class Main {
	
	public static void main(String[] args) {
	
		DoublyLinkedList numbers = new DoublyLinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		
		ListIterator i = numbers.listIterator();
		i.add(5);
		System.out.println(numbers);
		
		while(i.hasNext()) {
			
			int number = (int)i.next();
			
			if(number == 20) {
				
				i.remove();
			
			}
		}
		
		System.out.println(numbers);
		
	}//main 종료
	

}// Main 종료
