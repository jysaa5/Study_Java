package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1929 (소수 구하기)
import java.util.Scanner;
public class GetPrimeNumber_Ex {
	static boolean isPrime(int n) {
		if(n<=1) {
			return false;
		}
		if((n & 1) == 0) {
			return (n==2);
		}
		for(int i=3; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int m = Integer.parseInt(str.split(" ")[0]);
		int n = Integer.parseInt(str.split(" ")[1]);
		for(int i = m; i<=n; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}
