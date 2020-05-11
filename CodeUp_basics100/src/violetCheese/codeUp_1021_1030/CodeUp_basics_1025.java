package violetCheese.codeUp_1021_1030;

import java.util.Scanner;

public class CodeUp_basics_1025 {
	
	//메인 메서드
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int strlength = str.length();
        char[] ch = new char[strlength];
        int[] num = new int[strlength];
        int i = 0;

        if(strlength != 1){
          for (i=0; i<strlength; i++){
            ch[i] = str.charAt(i);
            num[i] = (int)(ch[i]-'0');
            System.out.println("["+Math.round(num[i]*Math.pow(10,strlength-1-i))+"]");
        }
        }else{
          System.out.println("["+str+"]");
        }
      
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1025 클래스 끝
