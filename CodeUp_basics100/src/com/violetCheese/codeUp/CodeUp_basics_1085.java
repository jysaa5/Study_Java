package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1085 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double h = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double s = sc.nextDouble();

		double memory_bit = 0;
		double memory_byte = 0;
		double memory_KB = 0;
		double memory_MB = 0;

		memory_bit = (h * b * c * s); // bit
		memory_byte = memory_bit / 8; // byte
		memory_KB = memory_byte / 1024; // KB
		memory_MB = memory_KB / 1024; // MB

		System.out.printf("%.1f", memory_MB);
		System.out.print(" MB");

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1085 클래스 끝
