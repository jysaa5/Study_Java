package com.violetCheese.intermediate;

import java.util.Calendar;

//Date의 단점을 해결하고 등장한 것이 Calendar클래스
//Calendar클래스는 추상클래스이다.
//Calendar클래스에 대한 인스턴스를 생성하려면 Calendar가 가지고 있는 클래스 메소드 getInstnace()를 사용해야 한다.
//getInstance()메소드를 호출하면 내부적으로 java.util.GregorianCalendar 인스턴스를 만들어서리턴한다.
//GregorianCalendar는 Calendar의 자식 클래스이다
public class Ex_23_Calendar_01 {
	public static void main(String[] args) {

		// Calendar는 추상클래스: 스스로 인스턴스를 만들수 없음. new를 할 수 없음.
		Calendar cal = Calendar.getInstance();

		// 상수 필드를 사용할때는 클래스 명.상수변수명
		System.out.println(cal.get(Calendar.YEAR));
		// 자바는 월을 0~11월을 표현한다.
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));

		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));

		// 시간 값을 바꿔줄 수 있다.
		// Calendar가 가지고 있는 add메소드를 이용하면 쉽게 다음 날짜나 이전 날짜를 구할 수 있다.
		cal.add(Calendar.HOUR, 5);
		// 상수 필드를 사용할때는 클래스 명.상수변수명
		System.out.println(cal.get(Calendar.YEAR));
		// 자바는 월을 0~11월을 표현한다.
		System.out.println(cal.get((Calendar.MONTH) + 1));
		System.out.println(cal.get(Calendar.DATE));

		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));

	}
}
