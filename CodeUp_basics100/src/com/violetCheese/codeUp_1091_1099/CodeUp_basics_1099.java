package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1099 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//한 행씩 입력 받을 객체 선언
		int[] road = new int[10];
		//개미집 2차 배열 선언
		int[][] antHome = new int[10][10];
		
		//열 인덱스 저장 변수
		int flag = 1;
		
		// 2를 만나면 종료 되는 것을 종료 시키는 변수
		int end = 0;

		//입력 행렬 저장
		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				road[j] = sc.nextInt();
				antHome[i][j] = road[j];
			}
			sc.nextLine();
		}

		//개미의 경로 표현
		for (int k = 1; k < 10; k++) {
			
			//경로 표현 종료 분기점
			if (end != 1) {
				
				//열 반복문: 첫번째 열은 1부터 시작함.
				for (int l = flag; l < 10; l++) 
				{
					//0이면 9로 저장
					if (antHome[k][l] == 0) {
						
						antHome[k][l] = 9;
					
				    //2이면 9로 저장
					} else if (antHome[k][l] == 2) {
						antHome[k][l] = 9;
						end = 1; //먹이를 만났으니 종료 변수 바꾸기
						break; //이 for반복문을 나가기.
						
					} else {
						flag = l - 1; //1을 만나면 그때의 열의 index에서 그 전 index를 저장함. 왜냐하면 개미 경로가 바로 전까지 있었으므로.
						break; //for 반복문 나가기. (모든 열을 반복하지 않고 그 다음 행으로 넘어가기 위해서)
					}
				}
			} else {
				break; //end == 1이면 for문 반복문 나가기
			}
		}
		
		//개미 경로 출력
		for (int m = 0; m < 10; m++) {

			for (int n = 0; n < 10; n++) {
				System.out.print(antHome[m][n] + " ");
			}
			System.out.println("");
		}

		sc.close();
	}// 메인 메서드

}// CodeUp_basics_1099 클래스 끝
