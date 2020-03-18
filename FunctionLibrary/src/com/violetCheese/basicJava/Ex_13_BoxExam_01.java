package com.violetCheese.basicJava;

public class Ex_13_BoxExam_01 {
	
	public static void main(String[] args) {
		
		Ex_11_Box_01 box = new Ex_11_Box_01();
		// Object를 생성해서 넣어줌
		box.setObj(new Object());
		// Object 객체를 담기 위한 변수 선언
		Object obj1 = box.getObj();
		System.out.println(obj1);

		// object를 상속받는 객체들은 모두 들어갈 수 있음.
		box.setObj("hello");
		// 형변환
		String str1 = (String) box.getObj();
		System.out.println(str1);

		box.setObj(1);
		// 형변환
		int value = (int) box.getObj();
		System.out.println(value);

	}
}
