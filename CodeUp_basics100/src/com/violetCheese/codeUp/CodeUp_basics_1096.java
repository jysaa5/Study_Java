package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1096 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		int n = sc.nextInt();

		// 입력 후 저장
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = 0; j < arr.length; j++) {
				for (int k = 0; k < arr.length; k++) {
					arr[x - 1][y - 1] = 1;
				}
			}

		}

		// 출력
		for (int l = 0; l < arr.length; l++) {
			for (int m = 0; m < arr.length; m++) {
				System.out.print(arr[l][m] + " ");
			}
			System.out.println();
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1096 클래스 끝
