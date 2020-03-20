package com.violetCheese.sort;

import java.util.Scanner;

// 문자열 거꾸로 출력: 정렬 안됨
// 1)solution
public class Ex_String_Reverse_01 {
	
	public void inputStrReverse(String str) {
		
		String inputStr = str;
		//for문 이용
		for(int i=inputStr.length()-1; i>=0; i--) {
		
			System.out.print(inputStr.charAt(i));
		}
		
	}
	
	// test
	public static void main(String[] args) {
		Ex_String_Reverse_01 strObject = new Ex_String_Reverse_01();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		strObject.inputStrReverse(str);
		
		sc.close();
	}

}
