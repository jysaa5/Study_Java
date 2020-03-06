package com.violetCheese.codeUp;

import java.util.Scanner;

public class CodeUp_basics_1084 {

	// 메인 메서드
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        int c = Integer.parseInt(strNum[2]);
        int cnt = a*b*c;
        int i = 0;
        int j = 0;
        int k = 0;
        
        for(i = 0; i<a; i++){
            
            for(j=0; j<b; j++){
                
                for(k=0; k<c; k++){
                    
                    System.out.println(i+" "+j+" "+k);
                    
                }
            }
        }
        
        System.out.println(cnt);
        sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1084 클래스 끝
