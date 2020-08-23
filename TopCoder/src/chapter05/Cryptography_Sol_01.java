package chapter05;

// p. 93
// 문제: 암호
// 솔루션: 이중 for문, Math.max

public class Cryptography_Sol_01 {
	
	public static long encrypt(int[] numbers) {
		
		long ans = 0;
		
		for(int i=0; i<numbers.length; i++) {
			
			long temp = 1;
			
			for(int j=0; j<numbers.length; j++) {
				
				if(i==j) {
					temp *=(numbers[j]+1);
				}else {
					temp *= numbers[j];
				}
				ans = Math.max(ans, temp);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		//int[] numbers = {1, 2, 3};
		//int[] numbers = {1, 3, 2, 1, 1, 3};
		//int[] numbers = {1000, 999, 998, 997, 996, 995};
		int[] numbers = {1, 1, 1, 1};
		
		System.out.println(encrypt(numbers));
	}

}
