package repetition.statement;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 10950 (A+B - 3)
import java.util.Scanner;

public class A_Plus_B_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] num = new int[t * 2];
		for (int i = 0; i < 2 * t; i++) {
			num[i] = sc.nextInt();
		}

		for (int j = 0; j < 2 * t; j = j + 2) {
			System.out.println(num[j] + num[j + 1]);
		}
		sc.close();
	}
}
