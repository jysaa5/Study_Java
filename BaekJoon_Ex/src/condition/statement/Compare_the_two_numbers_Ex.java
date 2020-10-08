package condition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1330 (두 수 비교하기)
import java.util.Scanner;
public class Compare_the_two_numbers_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>b) {
			System.out.println('>');
		}else if(a<b) {
			System.out.println('<');
		}else {
			System.out.println("==");
		}
	}
}
