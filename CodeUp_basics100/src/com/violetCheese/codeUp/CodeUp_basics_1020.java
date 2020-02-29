package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1020 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] idNum = str.split("-");
        System.out.print(idNum[0]+idNum[1]);
        
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1020 클래스 끝
