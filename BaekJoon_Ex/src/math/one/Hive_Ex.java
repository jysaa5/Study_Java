package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2292 (¹úÁý)
import java.util.Scanner;
public class Hive_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int result = 0;
		if(n==1) {
			result = 1;
		}
		int i = 2;
		int k = 1;
		
		while(i<=n) {
			i += 6*k++;
		}
		result = k;
		System.out.print(result);
	}
}
