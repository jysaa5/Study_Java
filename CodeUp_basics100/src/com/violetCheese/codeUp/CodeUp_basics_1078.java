package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1078 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();

		int num2 = 1;
		int result = 0;

		while (num1 > 0) {

			if (num2 % 2 == 0) {
				result += num2;
			}

			if (num1 <= num2) {
				break;
			}

			num2++;
		}
		System.out.println(result);
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1078 클래스 끝
