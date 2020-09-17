package chapter06;

// p. 196
// 문제: 계산량 - log를 사용하는 경우
// 시간복잡도: O(log n)

public class Bitcount_Sol_01 {
	
	 static int bitcount(int n) {
		 int ret = 0;
		 while(n>0) {
			 if(n%2==1) {
				 ret ++;
			 }
			 n/=2;
		 }
		 return ret;
	 }
	 
	 
	 public static void main(String[] args) {
		 System.out.println(bitcount(1000));
	 }

}
