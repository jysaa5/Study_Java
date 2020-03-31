package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1097 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1;
		int[][] num2 = new int[19][19];

		for (int i = 0; i < num2.length; i++) {
			for (int j = 0; j < num2.length; j++) {
				num1 = sc.nextInt();
				num2[i][j] = num1;
			}
			sc.nextLine();
		}

		int num3 = sc.nextInt();

		for (int k = 0; k < num3; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int n = 0; n < num2.length; n++) {
				for (int m = 0; m < num2.length; m++) {

					if (num2[x - 1][m] == 1) {
						num2[x - 1][m] = 0;
					} else {
						num2[x - 1][m] = 1;
					}

					if (num2[n][y - 1] == 1) {
						num2[n][y - 1] = 0;
					} else {
						num2[n][y - 1] = 1;
					}

				}
			}

		}

		for (int l = 0; l < num2.length; l++) {
			for (int m = 0; m < num2.length; m++) {
				System.out.print(num2[l][m] + " ");
			}
			System.out.println();
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1097 클래스 끝
