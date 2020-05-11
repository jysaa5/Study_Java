package violetCheese.codeUp_1041_1050;

import java.util.Scanner;

public class CodeUp_basics_1048 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        double c = Math.pow(2,b);
        System.out.print(Math.round(a*c));
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1048 클래스 끝
