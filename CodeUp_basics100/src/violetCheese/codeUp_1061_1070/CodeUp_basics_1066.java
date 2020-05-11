package violetCheese.codeUp_1061_1070;

import java.util.Scanner;

public class CodeUp_basics_1066 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strNum = str.split(" ");
        int[] num = new int[3];
        
        for(int i=0; i<3; i++){
            num[i] = Integer.parseInt(strNum[i]);
        }
        
        for(int i=0; i<3; i++){
        if(num[i]%2==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
        }
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1066 클래스 끝
