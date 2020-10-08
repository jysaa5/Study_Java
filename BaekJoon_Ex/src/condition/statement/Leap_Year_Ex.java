package condition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2753 (À±³â)
import java.util.Scanner;
public class Leap_Year_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		if((year%4 == 0 && year%100 != 0)||(year%400 == 0)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
