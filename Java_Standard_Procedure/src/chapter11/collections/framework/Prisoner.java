package chapter11.collections.framework;

import java.util.Collections;
import java.util.PriorityQueue;

// 내가 만든 예제

// 죄수 클래스
//class Prisoner1 {
//
//	// 이름
//	String name;
//	// 형량
//	int weight;
//
//	public Prisoner1(String name, int weight) {
//		super();
//		this.name = name;
//		this.weight = weight;
//	}
//
//}

// 죄수 클래스
public class Prisoner implements Comparable<Prisoner> {

	// 이름
	String name;
	// 형량
	int weight;

	// 생성자
	public Prisoner(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;

	}

	@Override
	public int compareTo(Prisoner target) {
		
		if (this.weight > target.weight) {
		
			return 1;
		
		} else if (this.weight < target.weight) {
		
			return -1;
		
		}
		
		return 0;
	}

	
	private static PriorityQueue<Prisoner> getPriorityQueue() {

		Prisoner prisoner1 = new Prisoner("james", 5);
		Prisoner prisoner2 = new Prisoner("schofield", 99);
		Prisoner prisoner3 = new Prisoner("alex", 14);
		Prisoner prisoner4 = new Prisoner("silvia", 10);
		Prisoner prisoner5 = new Prisoner("thomson", 1);
		
		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();
		
		priorityQueue.offer(prisoner1);
		priorityQueue.offer(prisoner2);
		priorityQueue.offer(prisoner3);
		priorityQueue.offer(prisoner4);
		priorityQueue.offer(prisoner5);
		
		return priorityQueue;

	}
	
	
	// 메인
	public static void main(String[] args) {
		
		PriorityQueue<Prisoner> priorityQueue = getPriorityQueue();
		
//		System.out.println("================== Normal Order");
//		
//		while(!priorityQueue.isEmpty()) {
//			Prisoner prisoner = priorityQueue.poll();
//			System.out.println(prisoner.name);
//		}
		
		System.out.println("================== Reversed Order");
		
		PriorityQueue<Prisoner> reversedPriorityQueue = new PriorityQueue<Prisoner>(priorityQueue.size(), Collections.reverseOrder());
		reversedPriorityQueue.addAll(priorityQueue);
		
		while(!reversedPriorityQueue.isEmpty()) {
			Prisoner prisoner = reversedPriorityQueue.poll();
			System.out.println(prisoner.name);
		}
		
	}
}