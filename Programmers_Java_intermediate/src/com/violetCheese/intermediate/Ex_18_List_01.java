package com.violetCheese.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Ex_18_List_01 {
	public static void main(String[] args) {
		// List는 인터페이스이기 때문에 new로 구현 불가능
		// 그러므로 ArrayList 클래스로 구현한다.
		// String만 받는 자료 구조로 선언함.
		List<String> list = new ArrayList<>();

		// 값 넣기
		list.add("kim");
		list.add("joo");
		list.add("kim");

		// 컬렉션이 가지고 있는 메서드: size()
		System.out.println(list.size());

		// 리스트는 중복된 값이 들어가는 거을 허용한다.
		// 리스트는 순서를 기억해서 index 사용 가능
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}

	}
}
