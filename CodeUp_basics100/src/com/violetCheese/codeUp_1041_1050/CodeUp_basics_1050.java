package com.violetCheese.codeUp_1041_1050;

import java.util.Scanner;

public class CodeUp_basics_1050 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        if (a==b){
            System.out.print(1);
        }else if(a != b){
            System.out.print(0);
        }
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1050 클래스 끝
