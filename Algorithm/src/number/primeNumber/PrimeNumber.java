package number.primeNumber;

public class PrimeNumber {

	static boolean isPrime(int n) {

		// 1은 소수가 아니다.
		if (n <= 1) {
			return false;
			}
		
		// 짝수
		if ((n & 1) == 0) {
			
			// 2이면 true. 아니면 소수가 아니다.
			return (n == 2);
		}
		
		// i = 3 ~ sqrt(n) 까지의 홀수
		for (int i = 3; i * i <= n; i++) {
		
			// i가 n의 약수라면 약수가 존재하는 것이므로 소수가 아니다.
			if (n % i == 0) {// i가 n의 약수라면
				return false; 
			}
		}
		return true; // 소수이다
	}

	public static void main(String[] args) {

		// int number = 7;
		// int number = 2;
		int number = 1;
		//int number = 9;
		System.out.println(isPrime(number));
	}

}
