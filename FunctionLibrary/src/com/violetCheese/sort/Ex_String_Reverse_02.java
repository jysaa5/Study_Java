package com.violetCheese.sort;

import java.util.Scanner;

// 문자열 거꾸로 출력: 정렬 안됨
// 2)solution
public class Ex_String_Reverse_02 {
	
	public void inputStrReverse(String str) {
		
		String inputStr = str;
		//StringBuffer 이용
		StringBuffer sb = new StringBuffer();
		
		sb.append(inputStr);
		
		System.out.print(sb.reverse());
		
	}
	
	// test
	public static void main(String[] args) {
		Ex_String_Reverse_02 inputStr = new Ex_String_Reverse_02();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		inputStr.inputStrReverse(str);
		sc.close();
		
	}

}
