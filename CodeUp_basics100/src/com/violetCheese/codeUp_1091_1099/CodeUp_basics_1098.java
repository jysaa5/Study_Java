package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1098 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//격자 세로
		int h = sc.nextInt();
		//격자 가로
		int w = sc.nextInt();
		sc.nextLine();
		//막대의 개수
		int n = sc.nextInt();
		sc.nextLine();

		//길이
		int l = 0;
		//방향
		int d = 0;
		//좌표
		int x = 0;
		int y = 0;

		//격자판 생성
		int[][] grid = new int[h][w];

		//격자판 초기화
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				grid[i][j] = 0;
			}
		}

		//길이, 방향, 좌표 입력 받기
		for (int k = 0; k < n; k++) {
			l = sc.nextInt();
			d = sc.nextInt();
			
			//격자판은 행과 열이 반대이다. 그리고 (1,1) 부터 시작함. 그러므로 행과 열을 반대로 해줘야 하며, 원래 좌표에서 -1을 해야 2차배열의 index에 맞다.
			y = sc.nextInt() - 1; 
			x = sc.nextInt() - 1;

			//방향이 가로 일때
			if (d == 0) {
				for (int m = 0; m < l; m++) {
					grid[y][x + m] = 1;
				}

			//방향이 세로일때
			} else if (d == 1) {

				for (int o = 0; o < l; o++) {
					grid[y + o][x] = 1;
				}

			}
			//개행 문자 담기
			sc.nextLine();
		}
		
         //격자판 출력
		for (int p = 0; p < h; p++) {
			for (int q = 0; q < w; q++) {
				System.out.print(grid[p][q] + " ");
			}
			System.out.println();
		}

		sc.close();
	}// 메인 메서드

}// CodeUp_basics_1098 클래스 끝
