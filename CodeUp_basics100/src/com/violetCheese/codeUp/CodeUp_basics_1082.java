package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1082 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int num = Integer.parseInt(str, 16);
		String num_16 = "";
		int result = 0;
		String result_16 = "";

		for (int i = 1; i < 16; i++) {

			num_16 = Integer.toHexString(i);
			result = num * i;
			result_16 = Integer.toHexString(result);
			System.out.println(str + "*" + num_16.toUpperCase() + "=" + result_16.toUpperCase());
		}
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1082 클래스 끝
