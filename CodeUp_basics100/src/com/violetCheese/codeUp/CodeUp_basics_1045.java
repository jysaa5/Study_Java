package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1045 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str2 = str1.split(" ");
        double a = Integer.parseInt(str2[0]);
        double b = Integer.parseInt(str2[1]);
        System.out.println(Math.round(a+b));
        System.out.println(Math.round(a-b));
        System.out.println(Math.round(a*b));
        System.out.println(Math.round(a/b));
        System.out.println(Math.round(a%b));
        System.out.printf("%.2f",(a/b));
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1045 클래스 끝
