package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1033 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String strNum = Integer.toHexString(num);
        System.out.print(strNum.toUpperCase());
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1033 클래스 끝
