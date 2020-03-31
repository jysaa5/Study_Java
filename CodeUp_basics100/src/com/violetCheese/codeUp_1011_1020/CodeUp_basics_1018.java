package com.violetCheese.codeUp_1011_1020;

import java.util.Scanner;

public class CodeUp_basics_1018 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String inputTime = sc.nextLine();
        String[] timeArray = inputTime.split(":");
        String hour = timeArray[0];
        String minute = timeArray[1];
        System.out.print(hour+":"+minute);
        
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1018 클래스 끝
