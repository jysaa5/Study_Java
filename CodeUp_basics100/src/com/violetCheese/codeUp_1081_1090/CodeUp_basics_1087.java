package com.violetCheese.codeUp_1081_1090;

import java.util.Scanner;

public class CodeUp_basics_1087 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		int i = 1;

		while (n > 0) {

			if (result >= n) {

				System.out.print(result);
				break;
			}

			result += i;
			i++;
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1087 클래스 끝
