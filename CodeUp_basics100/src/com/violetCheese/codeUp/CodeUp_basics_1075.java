package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1075 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = num1 - 1;

		while (num2 >= 0) {

			System.out.println(num2);
			num2--;
		}

		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1075 클래스 끝
