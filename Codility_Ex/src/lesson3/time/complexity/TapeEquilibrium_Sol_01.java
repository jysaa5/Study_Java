package lesson3.time.complexity;

//문제: TapeEquilibrium
/*
A non-empty array A consisting of N integers is given. 
Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, 
splits this tape into two non-empty parts: 
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: 
|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
For example, consider array A such that:

A[0] = 3
A[1] = 1
A[2] = 2
A[3] = 4
A[4] = 3
We can split this tape in four places:
P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7

Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
For example, given:

A[0] = 3
A[1] = 1
A[2] = 2
A[3] = 4
A[4] = 3
the function should return 1, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
*/
/*
1. 문제요약
- 배열A는 N의 정수로 이루어진 비어있지 않은 배열이다.
- 배열A는 테이프의 숫자를 나타낸다.
- 정수 P는 0과 N 사이에 있다.
- 이 테이프를 비어 있지 않은 두 부분으로 나눈다.
-> A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
- 두 부분의 차이점은 다음과 같은 값이다. 
-> |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
- 나눈 배열들의 차가 최소가 되는 값을 반환 해라.

2. 솔루션
- for문
- Math.abs 사용

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class TapeEquilibrium_Solution_01 {
 public int solution(int[] A) {
 	
 	// 0 < P < A.length
 	int p = 1;
 	int total = 0; 
 	int firstSum = 0;
 	int secondSum = 0;
 	int difference = 0;
 	int min = Integer.MAX_VALUE;
 	
 	// 배열 전체 합
 	for(int i=0; i<A.length; i++) {
 		total += A[i];
 	}
 	
 	secondSum = total;
 	
 	// 두번째 합은 전체 합에서 뺀다.
 	for(p=1; p<A.length; p++) {
 		
 		firstSum += A[p-1];
 		secondSum -= A[p-1];
 	
 		difference = Math.abs(firstSum - secondSum);
 		
 		if(difference<min) {
 			min = difference;
 		}
 	}
 	
 	return min;

 }
}

public class TapeEquilibrium_Sol_01 {
	
	public static void main(String[] args) {
		int[] A = {3,1,2,4,3};
		TapeEquilibrium_Solution_01 sol = new TapeEquilibrium_Solution_01();
		System.out.println(sol.solution(A));
	}

}
