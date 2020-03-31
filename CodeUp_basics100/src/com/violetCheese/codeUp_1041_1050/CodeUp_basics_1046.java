package com.violetCheese.codeUp_1041_1050;

import java.util.Scanner;

public class CodeUp_basics_1046 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str2 = str1.split(" ");
        double a = Integer.parseInt(str2[0]);
        double b = Integer.parseInt(str2[1]);
        double c = Integer.parseInt(str2[2]);
        System.out.println(Math.round(a+b+c));
        System.out.printf("%.1f",(a+b+c)/3);
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1046 클래스 끝
