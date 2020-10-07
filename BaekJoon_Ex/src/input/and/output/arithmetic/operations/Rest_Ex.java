package input.and.output.arithmetic.operations;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10430 (나머지)
import java.util.Scanner;
public class Rest_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println((a+b)%c);
		System.out.println(((a%c)+(b%c))%c);
		System.out.println((a*b)%c);
		System.out.println(((a%c)*(b%c))%c);
	}
}
