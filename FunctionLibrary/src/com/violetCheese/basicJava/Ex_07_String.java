package com.violetCheese.basicJava;

public class Ex_07_String {

	public static void main(String[] args) {
		
		String str1 = "hello world";
		
		String str2 = str1.substring(5);
		//str1과 str2은 서로 다른 객체이다.
		System.out.println(str1);
		System.out.println(str2);

		String str3 = str1 + str2;
		System.out.println(str3);
		
		//str3이 덧셈이 된 원리
		String str4 = new StringBuffer().append(str1).append(str2).toString();
		System.out.println(str4);
		
		//100번이나 String 객체를 새로 만든 것이다. -> 자바에서 new 연산을 많이 할수록 성능상 문제가 발생한다.
		String str5="";
		for(int i=0; i<100; i++) {
			str5 = str5+"*";
		}
		
		System.out.println(str5);
	
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<100; i++) {
			sb.append("*");
			
		}
		
		String str6 = sb.toString();
		System.out.println(str6);
	
	}

}
