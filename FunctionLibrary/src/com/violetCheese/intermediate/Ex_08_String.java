package com.violetCheese.intermediate;

public class Ex_08_String {
	public static void main(String[] args) {
		// (1) String의 +연산을 이용해서 10,000개의 *를 이어붙입니다.
		// 시작시간을 기록합니다.(millisecond단위)
		long startTime1 = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 10000; i++) {
			str = str + "*";
		}
		// 종료시간을 기록합니다.(millisecond단위)
		long endTime1 = System.currentTimeMillis();

		// (2) StringBuffer를 이용해서 10,000개의 *를 이어붙입니다.
		// 시작시간을 기록합니다.(millisecond단위)
		long startTime2 = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10000; i++) {
			sb.append("*");
		}
		// 종료시간을 기록합니다.(millisecond단위)
		long endTime2 = System.currentTimeMillis();

		// 방법(1)과 방법(2)가 걸린 시간을 비교합니다.
		long duration1 = endTime1 - startTime1;
		long duration2 = endTime2 - startTime2;

		System.out.println("String의 +연산을 이용한 경우 : " + duration1);
		System.out.println("StringBuffer의 append()을 이용한 경우 : " + duration2);
	}
}
