package recursive.function;

// 피보나치 수열 
// 솔루션: for문
public class Fibonacci_Sol_02 {
	
	static int fib(int number) {
		
		if(number ==1 || number ==2) {
			return 1;
		}
		
		int start = 1;
		int end = 1;
		int result = -1;
		
		for(int i=2; i<number; i++) {
			result = start + end;
			start = end;
			end = result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(fib(10));
	}

}
