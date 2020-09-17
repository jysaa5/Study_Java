package chapter06;

// p. 198
// 문제: 계산량 - 재귀함수
// 솔루션: O(((1+(5)1/2)/2)^n+1)

public class Fibonacci_Sol_01 {
	static int fibonacci(int n) {
		if(n==0) {
			return 1;
		}
		
		if(n==1) {
			return 1;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}
}
