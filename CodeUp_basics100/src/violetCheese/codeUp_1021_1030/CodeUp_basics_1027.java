package violetCheese.codeUp_1021_1030;

import java.util.Scanner;

public class CodeUp_basics_1027 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] str1 = str.split("\\.");
        System.out.print(str1[2]+"-"+str1[1]+"-"+str1[0]);
      
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1027 클래스 끝
