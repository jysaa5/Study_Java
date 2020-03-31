package com.violetCheese.codeUp_1081_1090;

import java.util.Scanner;

public class CodeUp_basics_1086 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double w = sc.nextDouble();
		double h = sc.nextDouble();
		double b = sc.nextDouble();

		double memory_bit = (w * h * b); //bit
		double memory_byte = memory_bit / 8; //byte
		double memory_KB = memory_byte / 1024; //KB
		double memory_MB = memory_KB / 1024; //MB

		System.out.printf("%.2f", memory_MB);
		System.out.print(" MB");

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1086 클래스 끝
