package math.two;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1978 (소수찾기)
import java.util.Scanner;

public class FindPrimeNumber_Ex {
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
		int number = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < number; i++) {
			int n = sc.nextInt();
			cnt += (isPrime(n)) ? 1 : 0; 
		}
		System.out.println(cnt);
		sc.close();
	}
}
