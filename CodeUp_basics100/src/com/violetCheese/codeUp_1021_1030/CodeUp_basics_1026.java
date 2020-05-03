package com.violetCheese.codeUp_1021_1030;

import java.util.Scanner;

public class CodeUp_basics_1026 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split(":");
        if(str1[1].equals("00")){
             System.out.println("0");
        }else{
            System.out.println(str1[1]);
        }
      
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1026 클래스 끝
