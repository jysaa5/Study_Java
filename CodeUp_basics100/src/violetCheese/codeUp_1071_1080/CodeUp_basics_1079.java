package violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1079 {

	// 메인 메서드
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str2 = str1.split(" ");
        
        for(int i=0; i<str2.length; i++){
        if(str2[i].equals("q")){
            System.out.println(str2[i]);
            break;
        }else{
            System.out.println(str2[i]);
        }
      }
      
      sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1079 클래스 끝
