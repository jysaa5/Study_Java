package chapter05;

import java.util.Vector;

// p. 110
// 문제: 재미있는 수학
// 솔루션: Vector, for문, 배열 사용

public class Funny_Mathematics_Sol_02 {
	
	public static int[] digits(int base) {
		
		Vector<Integer> v = new Vector<Integer>();
		// (n-1) 약수
		for(int i = 2; i<base; i++) {
			if(((base-1)%i)==0) {
				v.add(i);
			}
		}
		
		int[] ans = new int[v.size()];
		
		for(int i=0; i<v.size(); i++) {
			ans[i] = v.get(i);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		//int base = 10;
		//int base = 3;
		//int base = 9;
		//int base = 26;
		int base = 30;
		
		for(int n: digits(base)) {
			System.out.println(n);
		}
		
	}
}
