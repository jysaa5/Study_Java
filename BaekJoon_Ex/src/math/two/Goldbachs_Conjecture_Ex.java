package math.two;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 9020 (골드바흐의 추측)
import java.util.Scanner;

public class Goldbachs_Conjecture_Ex {
	static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if ((n & 1) == 0) {
			return (n == 2);
		}
		for (int i = 3; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int p1 = 0;
			int p2 = 0;
			p1 = n / 2;
			p2 = n - p1;
			while (true) {
				if (isPrime(p1) && isPrime(p2)) {
					break;
				}else {
					p1--;
					p2++;
				}
			}
			System.out.println(p1+" "+p2);
		}
		sc.close();
	}
}
