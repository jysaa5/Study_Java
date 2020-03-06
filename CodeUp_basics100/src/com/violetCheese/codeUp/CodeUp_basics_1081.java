package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1081 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strNum = str.split(" ");
		int a = Integer.parseInt(strNum[0]);
		int b = Integer.parseInt(strNum[1]);

		for (int i = 1; i <= a; i++) {

			for (int j = 1; j <= b; j++) {

				System.out.println(i + " " + j);

			}
		}
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1081 클래스 끝
