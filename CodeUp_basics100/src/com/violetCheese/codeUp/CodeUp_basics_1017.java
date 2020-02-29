package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1017 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        StringBuffer buff = new StringBuffer();
        int i = 0;
        for (i=0; i<3; i++){
            buff.append(inputStr);
            buff.append("\t");
        }
        System.out.print(buff);
        
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1017 클래스 끝
