package com.violetCheese.basicJava;

import java.util.Calendar;

public class Ex_24_Calendar_02 {
	public String hundredDaysAfter() {
		// 오늘부터 100일 뒤의 날짜를 "2016년1월1일"의 형식으로 return하세요.
		Calendar cl = Calendar.getInstance();
		cl.add(Calendar.DATE, 100);

		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH) + 1;
		int date = cl.get(Calendar.DATE);
		String str = year + "년" + month + "월" + date + "일";

		return str;

	}

	public static void main(String[] args) {

		Ex_24_Calendar_02 cal = new Ex_24_Calendar_02();

		System.out.println(cal.hundredDaysAfter());

	}
}
