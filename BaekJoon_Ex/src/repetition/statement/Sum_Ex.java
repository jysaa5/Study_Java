package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 8393 (ÇÕ)
import java.util.Scanner;
public class Sum_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for(int i=1; i<n+1; i++) {
			result += i;
		}
		System.out.println(result);
	}
}
