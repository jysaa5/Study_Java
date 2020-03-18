package com.violetCheese.basicJava;

public class Ex_14_BoxExam_02 {
	public static void main(String[] args) {

		Ex_12_Box_02<Object> box = new Ex_12_Box_02<>();
		box.setObj(new Object());
		Object obj2 = box.getObj();
		System.out.println(obj2);

		// String만 받겠다.
		Ex_12_Box_02<String> box2 = new Ex_12_Box_02<>();
		box2.setObj("hello");
		// 형변환 없이 사용 가능하다.
		String str2 = box2.getObj();
		System.out.println(str2);

		// Integer만 받겠다.
		Ex_12_Box_02<Integer> box3 = new Ex_12_Box_02<>();
		box3.setObj(4);
		int value2 = box3.getObj();
		System.out.println(value2);

	}
}
