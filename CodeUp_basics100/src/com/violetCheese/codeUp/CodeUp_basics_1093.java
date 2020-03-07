package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1093 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String[] strNum = str2.split(" ");

		str1 = str1.trim();
		int n = Integer.parseInt(str1);

		int[] num = new int[n];

		for (int i = 0; i < n; i++) {

			num[i] = Integer.parseInt(strNum[i]);

		}

		int[] student = new int[24];

		for (int j = 0; j < n; j++) {

			for (int k = 0; k < 24; k++) {
				if (num[j] == k) {
					student[k] += 1;
				}
			}
		}

		for (int l = 1; l < 24; l++) {
			System.out.print(student[l] + " ");
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1093 클래스 끝
