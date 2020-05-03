package com.violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1091 {

	// 메인 메서드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long m = sc.nextLong();
		long d = sc.nextLong();
		long n = sc.nextLong();
		
		//사용안해도 됨. 근데 보기 좋게 사용하자면 이렇게.
		//long result = a; 

		for (int i = 1; i < n; i++) {
			
			//result = result*m+d;
			a = a * m + d;
		}

		System.out.print(a);
		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1091 클래스 끝
