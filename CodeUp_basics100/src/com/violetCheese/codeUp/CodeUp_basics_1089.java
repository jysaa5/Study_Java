package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1089 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();

		int s = 0;
		s = a + ((n - 1) * d);

		System.out.print(s);

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1089 클래스 끝
