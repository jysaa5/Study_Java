package input.and.output.arithmetic.operations;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10869 (사칙연산)
import java.util.Scanner;
public class Four_Fundamental_Arithmetic_Operations_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
	}
}
