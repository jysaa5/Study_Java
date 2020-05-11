package imp.queue.alg.linked.list;

import java.util.LinkedList;

//문제: 개와 고양이만 분양하는 분양소가 있다. 분양받는 사람은 동물의 종류만 고를 수 있고, 분양소에서 가장 오래
//있는 순서로 자동으로 분양될 동물에 정해지는 클래스를 구현하시오.
//단, 자바에서 제공하는 LinkedList로 구현하시오.

//LinkedList로 Queue로 구현
//동물 타입 선언
enum AnimalType {
	
	DOG, CAT

}

//공통 항목은 추상 클래스에서 다룬다.
//Animal: 추상 클래스
abstract class Animal {

	AnimalType type;
	String name;
	int order;

	// 생성자
	Animal(AnimalType type, String name) {
		this.type = type;
		this.name = name;
	}

	// setOrder 메서드: 순서 설정
	void setOrder(int order) {
		
		this.order = order;
	
	}//setOrder 메서드 종료

	
	// getOrder 메서드: 순서 보기
	int getOrder() {
	
		return order;
	
	}// getOrder 메서드 종료

	
	// info 메서드
	String info() {
		
		return order + ") type: " + type + ", name: " + name;
	
	}// info 메서드 종료
	
}// Animal 추상 클래스 종료


//Dog 클래스 
class Dog extends Animal {

	// 생성자
	Dog(String name) {
		
		super(AnimalType.DOG, name);
	
	}

}// Dog 클래스 종료


//Cat 클래스 
class Cat extends Animal {
	
	// 생성자
	Cat(String name) {
	
		super(AnimalType.CAT, name);
	
	}
	
}// Cat 클래스 종료


//동물 분양소
class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();

	// 동물의 번호 = 순서
	int order;

	// 생성자
	AnimalShelter() {
	
		order = 1;
	
	}

	// enqueue 메서드: 큐에 데이터 추가하는 기능
	void enqueue(Animal animal) {
		//순서 설정
		animal.setOrder(order);
		
		//순서 증가
		order++;

		//개 일 때
		if (animal.type == AnimalType.DOG) {
	
			//개 연결리스트에 데이터 추가
			dogs.addLast((Dog) animal);
		
		//고양이 일 때
		} else if (animal.type == AnimalType.CAT) {
		
			//고양이 연결리스트에 데이터 추가
			cats.addLast((Cat) animal);
	
		}
		
	}// enqueue 메서드 종료

	
	// dequeueDog 메서드: 개 큐에서 데이터 꺼내고 삭제하는 기능
	Animal dequeueDog() {
	
		return dogs.poll();
	
	}// dequeueDog 메서드 종료

	
	// dequeueCat 메서드: 고양이 큐에서 데이터 꺼내고 삭제하는 기능 
	Animal dequeueCat() {
		
		return cats.poll();
	
	}// dequeueCat 메서드 종료

	
	// dequeue 메서드: 고양이나 개 중에서 순서대로 아무거나 꺼내는 기능
	Animal dequeue() {
		
		// 개, 고양이가 모두 다 없을 때.
		if (dogs.size() == 0 && cats.size() == 0) {
		
			return null;
		
		// 개만 없을 때
		} else if (dogs.size() == 0) {

			return cats.poll();

		// 고양이만 없을 때
		} else if (cats.size() == 0) {
			
			return dogs.poll();
		}
		
		//둘 다 있을 때 스택 위에 있는 것을 꺼내 본다.
		Animal dog = dogs.peek();
		Animal cat = cats.peek();

		//순서 비교
		if(cat.order < dog.order) {
			return cats.poll();
		}else {
			return dogs.poll();
		}
		
	}// dequeue 메서드 종료

}//AnimalShelter 클래스 종료


//Queue_alg_Imp 클래스
public class Queue_Imp_LinkedList {

	// main 메서드: 실행 함수
	public static void main(String[] args) {
		
		Dog d1 = new Dog("puppy");
		Dog d2 = new Dog("chichi");
		Dog d3 = new Dog("choco");
		
		Cat c1 = new Cat("shasha");
		Cat c2 = new Cat("miumiu");
		Cat c3 = new Cat("gaga");

		
		AnimalShelter as = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(d3);
		as.enqueue(c3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		
		
	}// main 메서드 종료

}// Queue_alg_Imp 종료
