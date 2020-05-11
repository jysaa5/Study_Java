package violetCheese.codeUp_1041_1050;

import java.util.Scanner;

public class CodeUp_basics_1049 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int a = Integer.parseInt(strNum[0]);
        int b = Integer.parseInt(strNum[1]);
        int c = a - b;
        if(c<=0){
            System.out.println(0);
        }else if(c>0){
            System.out.println(1);
        }
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1049 클래스 끝
