package make.recursive.function;

//피보나치 수열
// 1,     1,    2,  3, 5, 13, 21, 34
// 0번째, 1번째 , 2번째 ...
// n >= 0
public class Ex_01_Fibonacci {
	
	//1.solution
	//재귀함수를 이용한다.
	//성능상에 문제가 있다.
	public int Fibonacci(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return Fibonacci(n-1) + Fibonacci(n-2);
		}
	}
	
	
	//2.solution
	//동적 프로그래밍 기법을 이용한다.
	public int dynamicFibonacci(int n) {
		//동적 프로그래밍
		int last1, last2, result = 0;
		
		if(n <=1) {
			return 1;
		}
		
		last1 = 1;
		last2 = 1;
		
		for(int i=1; i<n; i++) {
			result = last1 + last2;
			last1 = last2;
			last2 = result;
		}
		
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		
		Ex_01_Fibonacci rf = new Ex_01_Fibonacci();
		
		System.out.println(rf.Fibonacci(1));
		System.out.println(rf.dynamicFibonacci(1));
	}
	

}
