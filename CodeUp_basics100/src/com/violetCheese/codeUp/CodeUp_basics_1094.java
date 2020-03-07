package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1094 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		str1 = str1.trim();
		String[] strNum = str2.split(" ");
		int n = Integer.parseInt(str1);
		String[] student = new String[n];
		for (int i = n - 1; i >= 0; i--) {
			student[n - 1 - i] = strNum[i];
		}

		for (String students : student) {
			System.out.print(students + " ");
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1094 클래스 끝
