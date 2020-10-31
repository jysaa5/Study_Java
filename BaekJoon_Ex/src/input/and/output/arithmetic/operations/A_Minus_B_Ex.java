package input.and.output.arithmetic.operations;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 1001 (A-B)
import java.util.Scanner;

public class A_Minus_B_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.print(a - b);
		sc.close();
	}
}
