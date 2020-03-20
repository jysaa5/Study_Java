package com.violetCheese.intermediate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map: key와 value를 쌍으로 데이터를 저장된다.
//key를 이용해서 value를 찾을수 있도록 설계되었다.
public class Ex_20_Map_01 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		// Map에 값을 넣기
		map.put("001", "kim");
		map.put("002", "lee");
		map.put("003", "choi");

		// 중복된 키값 넣어보기
		map.put("001", "kang");

		// 중복된 키 값이 중복으로 체크 되지 않는다.
		System.out.println(map.size());

		// 마지막에 저장한 값으로 바뀐다.
		System.out.println(map.get("001"));

		System.out.println(map.get("002"));

		// 모든 key값을 Set에 넣는다.
		Set<String> keys = map.keySet();

		// Iterator 인터페이스 구현. iterator()메서드로 한 개씩 꺼낼수 있는 객체 선언
		Iterator<String> iter = keys.iterator();

		// 그 다음값이 없을때까지 반복
		while (iter.hasNext()) {
			// 한개씩 꺼내기
			String key = iter.next();
			// key값에 따른 value값 꺼내기
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}

	}
}
