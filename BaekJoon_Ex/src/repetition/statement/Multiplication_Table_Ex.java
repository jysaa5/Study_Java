package repetition.statement;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2739 (구구단)
import java.util.Scanner;

public class Multiplication_Table_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}
		sc.close();
	}
}
