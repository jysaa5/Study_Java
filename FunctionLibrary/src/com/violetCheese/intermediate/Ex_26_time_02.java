package com.violetCheese.intermediate;

import java.time.LocalDateTime;

public class Ex_26_time_02 {
	public static void main(String[] args) {
		// 지금이 몇월인지를 영어로(예. 1월이면 JANUARY, 2월이면 FEBRUARY) 출력하세요

		LocalDateTime ld = LocalDateTime.now();
		// Month month = ld.getMonth();
		System.out.println(ld.getMonth());

	}
}
