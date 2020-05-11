package violetCheese.codeUp_1041_1050;

import java.util.Scanner;

public class CodeUp_basics_1041 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch1 = str.charAt(0);
        int num = (int)ch1;
        num ++;
        char ch2 = (char)num;
        System.out.print(ch2);
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1041 클래스 끝
