package chapter06;

// p.199
// 계산량이 큰 함수를 호출하는 경우
// 총 시간복자보: O(n*2^n)
public class Time_Complexity_Sol_01 {
	static void calc(int n) {
		
		for(int i=0; i<n; i++) {
			// n^3 log n 번
			System.out.println("피보나치: "+Fibonacci_Sol_01.fibonacci(n));
			
			for(int j=0; j<n; j++) {
				// n^2((n)^1/2)
				System.out.println("소수: "+IsPrime_Sol_01.isPrime(n));
				
				for(int k=0; k<n; k++) {
					//O(2^n)
					System.out.println("비트계산: "+Bitcount_Sol_01.bitcount(n));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		calc(5);
	}
}
