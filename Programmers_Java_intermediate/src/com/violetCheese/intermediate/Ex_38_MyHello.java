package com.violetCheese.intermediate;

import java.lang.reflect.Method;

//Ex_37_MyHello 클래스가 실행되는 클래스
public class Ex_38_MyHello {

	public static void main(String[] args) {

		// 인스턴스 생성
		Ex_37_MyHello hello = new Ex_37_MyHello();

		// Method 객체: 메서드 정보를 알기 위한 객체
		// getClass(): Object를 상속 받고 있음. 해당 인스턴스를 만들때 사용한 클래스의 정보를 리턴한다.
		// getDeclaredMethod: "Hello"라는 메서드를 정보를 가져와라
		try {
			Method method = hello.getClass().getDeclaredMethod("hello");

			// 특정 메서드에 어노테이션이 적용되어 있는지 알아보는 것
			// 적용되어 있으면 true
			if (method.isAnnotationPresent(Count100.class)) {
				
				for(int i =0 ; i<100; i++) {
					hello.hello();
				}

			} else {
				
				hello.hello();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
