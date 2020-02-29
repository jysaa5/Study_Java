package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1024 {
	
	//메인 메서드
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     int i = 0;
	     for (i=0 ; i<str.length(); i++){
	    	 System.out.println("\'"+str.charAt(i)+"\'");
	    	 }
      
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1024 클래스 끝
