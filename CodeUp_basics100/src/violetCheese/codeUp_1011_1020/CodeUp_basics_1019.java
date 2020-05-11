package violetCheese.codeUp_1011_1020;

import java.util.Scanner;

public class CodeUp_basics_1019 {
	
	//메인 메서드
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        
	     String inputDay = sc.nextLine();
	     String[] dayArray = inputDay.split("\\.");

	     String year = dayArray[0];
	     String month = dayArray[1];
	     String day = dayArray[2];
	        
	     int yearNum = Integer.parseInt(year);
	     int monthNum = Integer.parseInt(month);
	     int dayNum = Integer.parseInt(day);

	     System.out.printf("%04d"+"."+"%02d"+"."+"%02d", yearNum, monthNum, dayNum);
        
        sc.close();
        
	}//main 메서드 끝
	
}//CodeUp_basics_1019 클래스 끝
