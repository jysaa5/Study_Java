package com.violetCheese.intermediate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//set은 중복이 없고, 순서도 없는 자료구조. Hashset과 TreeSet이 있다.
public class Ex_15_Set_01 {
	public static void main(String[] args) {

		// Set 인터페이스 이므로 new로 구현할 수 없다.
		// Set을 구현한 클래스인 HashSet으로 new 가능
		// 제네릭으로 String만 가능하게 함.
		Set<String> set1 = new HashSet<>();

		// 저장할때마다 boolean값을 반환한다.
		boolean flag1 = set1.add("kim");
		boolean flag2 = set1.add("joo");
		boolean flag3 = set1.add("kim");

		// 자료구조의 크기를 알아볼때의 메서드: size()
		System.out.println(set1.size());

		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3); // 중복되므로 false

		// set에서 들어있는 값들을 하나씩 꺼내려면 Set의 부모 클래스인 Collection이 가지고 있는
		// Iterator 인터페이스를 이용한다.

		// 하나씩 꺼내보기 위해서 Iterator 선언
		// Iterator 인터페이스를 구현한 객체 생성
		Iterator<String> iter = set1.iterator();

		// 데이터가 있는 동안에만 true이다.
		while (iter.hasNext()) {
			// 하나를 꺼내고 자동으로 다음 값으로 간다.
			String str = iter.next();
			System.out.println(str);
		}

	}
}
