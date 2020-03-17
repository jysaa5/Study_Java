package com.violetCheese.basicJava;

public class Ex_09_Math_01 {

	public static void main(String[] args) {
		
		//최대값
		int value1 = Math.max(5, 3);
		System.out.println(value1);
		
		//최소값
		int value2 = Math.min(5, 3);
		System.out.println(value2);
		
		//절대값
		System.out.println(Math.abs(-10));
		
		//랜덤: 0<실수<1
		System.out.println(Math.random());
		
		//제곱근
		System.out.println(Math.sqrt(25));
	}
}
