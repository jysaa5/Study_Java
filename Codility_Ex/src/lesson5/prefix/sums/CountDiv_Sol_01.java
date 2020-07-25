package lesson5.prefix.sums;

// 문제: CountDiv
/*
Write a function:
class Solution { public int solution(int A, int B, int K); }
that, given three integers A, B and K,
returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, 
because there are three numbers divisible by 2 within the range [6..11], 
namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:
A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
*/
/*
솔루션: 구간 사이의 공배수 찾기 + 0은 어떤 것으로 나머지 연산 해도 0이 나온다.
시간복잡도: O(1)
*/

class CountDiv_Solution_01 {
	public int solution(int A, int B, int K) {

		int count = 0;
		if (A != 0) {
			count = (B / K) - ((A - 1) / K);
		} else if(A == 0){
			// A가 0이면 어떤 값과 나머지 연산을 해도 0이 나온다. 0%K == 0
			count = (B / K) + 1;
		}
		return count;
	}
}

public class CountDiv_Sol_01 {
	public static void main(String[] args) {
		//int A = 6;
		//int B = 11;
		//int K = 2;
		
		int A = 0;
		int B = 12;
		int K = 2;
		
		System.out.println(0%2);

		CountDiv_Solution_01 sol = new CountDiv_Solution_01();
		System.out.println(sol.solution(A, B, K));

	}

}
