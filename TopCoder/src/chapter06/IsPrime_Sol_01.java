package chapter06;

// p.195
// 문제: 계산량 - 제곱근을 사용하는 경우
// 시간복잡도: O(n^(1/2))
public class IsPrime_Sol_01 {
	static boolean isPrime(int n) {
		
		if(n<2) {
			return false;
		}
		
		for(int i=2; i*i<=n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(5));
	}

}
