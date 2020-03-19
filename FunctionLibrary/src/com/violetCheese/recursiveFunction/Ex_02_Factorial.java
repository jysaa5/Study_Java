package com.violetCheese.recursiveFunction;

// 팩토리얼
// 0! = 1, 1! = 1, 2! = 1*2
public class Ex_02_Factorial {

	//1.solution
	//재귀함수 이용
	public int factorial_01 (int n) {
		if(n<=1) {
			return 1;
		}else {
			return factorial_01(n-1)*n;
		}
	}

	//2.solution
	//for문 이용
	public int factorial_02 (int n) {
		
		int fac = 1;
		
		for(int i=n; i>=1; i--) {
			fac = fac*i;
		}
		
		return fac;
		
	}
	


	public static void main(String[] args) {
		
		Ex_02_Factorial f = new Ex_02_Factorial();
		
		System.out.println(f.factorial_01(5));
		System.out.println(f.factorial_02(5));
	}

	
}
