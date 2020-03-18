package com.violetCheese.basicJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Ex_21_Map_02 {
	public Map<String, Integer> makeMap() {
		Map<String, Integer> products = new HashMap<>();
		// 상품의 이름과 값을 products에 추가해 보세요.
		products.put("가위", 2500);
		products.put("크레파스", 5000);

		return products;
	}

	public static void main(String[] args) {
		Ex_21_Map_02 mapClass = new Ex_21_Map_02();
		Set<String> keys = mapClass.makeMap().keySet();
		Iterator<String> iter = keys.iterator();

		for (String str : keys) {
			System.out.println(mapClass.makeMap().get(str));
		}

	}

}
