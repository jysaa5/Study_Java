package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 4948 (베르트랑 공준)
import java.util.Scanner;
public class Bertrands_postulate_Ex {
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
		while(true) {
			int x = sc.nextInt();
			if(x==0) {
				break;
			}
			int y = 2*x;
			int cnt = 0;
			for(int i=x+1; i<=y; i++) {
				if(isPrime(i)) {
					cnt ++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
