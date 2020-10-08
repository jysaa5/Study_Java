package condition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 14681 (사분면 고르기)
import java.util.Scanner;
public class Choose_a_quadrant_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int x = Integer.parseInt(str1);
		int y = Integer.parseInt(str2);
		
		if(x>0 && y>0) {
			System.out.println(1);
		}else if(x<0 && y>0) {
			System.out.println(2);
		}else if(x<0 && y<0) {
			System.out.println(3);
		}else {
			System.out.println(4);
		}
	}
}
