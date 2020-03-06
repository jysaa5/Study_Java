package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1069 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		switch (str) {
		case "A":
			System.out.print("best!!!");
			break;

		case "B":
			System.out.print("good!!");
			break;

		case "C":
			System.out.print("run!");
			break;

		case "D":
			System.out.print("slowly~");
			break;

		default:
			System.out.print("what?");
		}
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1069 클래스 끝
