package lesson9.Maximum.slice.problem;

//문제: MaxProfit
/*An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. 
If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, 
then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. 
Otherwise, the transaction brings loss of A[P] − A[Q].
For example, consider the following array A consisting of six elements such that:
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048.
If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354.
Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.

Write a function,
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days,
returns the maximum possible profit from one transaction during this period. 
The function should return 0 if it was impossible to gain any profit.

For example, given array A consisting of six elements such that:
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
the function should return 356, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..400,000];
each element of array A is an integer within the range [0..200,000].*/
/*
1. 문제 요약
N개의 정수로 구성된 배열 A가 제공된다. 
연속 N일 동안 주식 주식의 일일 가격을 포함한다.
단일 주식이 P 일에 매수되어 Q 일에 매각 된 경우 (0 ≤ P ≤ Q <N)
그러한 거래의 이익은 A[Q] ≥ A[P]인 경우 A[Q] − A[P]와 같다.
그렇지 않으면 거래는 A[P] - A[Q]의 손실을 가져온다.
예를 들어, 다음과 같은 6개의 요소로 구성된 다음 배열 A를 고려하라.
  A[0] = 23171
  A[1] = 21011
  A[2] = 21123
  A[3] = 21366
  A[4] = 21013
  A[5] = 21367
주식이 0일에 매수되고 2일에 매도된 경우 A[2]-A[0] = 21123-23171 = -2048이므로 2048의 손실이 발생한다.
주식이 4일에 매수되고 5일에 매도된 경우 A[5]-A[4] = 21367-21013 = 354이기 때문에 354의 이익이 발생한다.
가능한 최대 이익은 356이다. 주식이 1 일에 매수되고 5 일에 판매 된 경우 발생한다.

함수 작성,
class Solution {public int solution (int [] A); }
연속 N일 동안 주식 주식의 일일 가격을 포함하는 N개의 정수로 구성된 배열 A가 주어지면,
이 기간 동안 한 거래에서 가능한 최대 이익을 반환한다.
수익을 얻을 수 없는 경우 함수는 0을 반환해야한다.
예를 들어, 다음과 같은 6개의 요소로 구성된 배열 A가 있다.
  A [0] = 23171
  A [1] = 21011
  A [2] = 21123
  A [3] = 21366
  A [4] = 21013
  A [5] = 21367
함수는 위에서 설명한대로 356을 반환해야한다.
다음 가정에 대한 효율적인 알고리즘을 작성하라.
N은 [0..400,000] 범위 내의 정수이고;
배열 A의 각 요소는 [0..200,000] 범위 내의 정수이다.

2. 솔루션
- for문, while문 사용, Kadane’s Algorithm(카데인 알고리즘)

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class MaxProfit_Solution_02 {
	public int solution(int[] A) {

		if(A.length==1 || A.length == 0) {
			return 0;
		}
		
		int minPrice = A[0];
		int localMaxProfit = 0;
		int globalMaxProfit = 0;
		
		for(int i=1; i<A.length; i++) {
			
			// 인덱스 순서는 항상 큰 값에서 작은 값을 빼는 쪽으로 한다.
			localMaxProfit = A[i] - minPrice;
			
			// 제일 작은 값을 찾아낼때까지 새로운 값으로 갱신
			if(A[i]<minPrice) {
				minPrice = A[i];
			}
			
			// 값의 차이가 제일 많이 나는 것으로 갱신
			globalMaxProfit = Math.max(localMaxProfit, globalMaxProfit);
			
		}
		
		// 이익이 없는 경우
		if(globalMaxProfit<0) {
			return 0;
		}
		

		return globalMaxProfit;
	}
}

public class MaxProfit_Sol_02 {

	public static void main(String[] args) {
		int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
		// int[] A = { 5, 4, 3, 2, 1 };
		MaxProfit_Solution_02 sol = new MaxProfit_Solution_02();
		System.out.println(sol.solution(A));
	}

}
