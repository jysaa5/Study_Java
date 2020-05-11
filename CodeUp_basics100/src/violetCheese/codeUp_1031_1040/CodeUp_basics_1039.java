package violetCheese.codeUp_1031_1040;

import java.util.Scanner;

public class CodeUp_basics_1039 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split("\\s");
        double a = Double.parseDouble(strNum[0]);
        double b = Double.parseDouble(strNum[1]);
        double result = a + b;
        System.out.print(Math.round(result));
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1039 클래스 끝
