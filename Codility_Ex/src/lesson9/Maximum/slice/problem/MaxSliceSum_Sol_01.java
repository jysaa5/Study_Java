package lesson9.Maximum.slice.problem;

// 문제: MaxSliceSum
/*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. 
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
For example, given array A such that:
A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:
(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
*/
/*
1. 문제 요약
N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공된다. 
0 ≤ P ≤ Q <N 인 정수 쌍 (P, Q)을 배열 A의 슬라이스라고한다.
슬라이스 (P, Q)의 합은 A [P] + A [P + 1] + ... + A [Q]의 합계이다.
함수 작성 :
class Solution {public int solution (int [] A); }
N 개의 정수로 구성된 배열 A가 주어지면 A 조각의 최대 합계를 반환한다.
예를 들어, 다음과 같은 배열 A가 있다.
A [0] = 3 A [1] = 2 A [2] = -6
A [3] = 4 A [4] = 0
함수는 다음과 같은 이유로 5를 반환해야한다.
(3, 4)는 합계가 4 인 A 조각이다.
(2, 2)는 합이 -6 인 A 조각이다.
(0, 1)은 합계가 5 인 A 조각이다.
A의 다른 조각에는 (0, 1)보다 큰 합계가 없다.
다음 가정에 대한 효율적인 알고리즘을 작성하라.
N은 [1..1,000,000] 범위 내의 정수이고;
배열 A의 각 요소는 [-1,000,000..1,000,000] 범위 내의 정수이다.
결과는 [−2,147,483,648..2,147,483,647] 범위 내의 정수가된단.

2. 솔루션
- 카데인 알고리즘

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class MaxSliceSum_Solution_01 {
    public int solution(int[] A) {
        //배열의 길이가 1일 때
    	if(A.length == 1) {
    		return A[0];
    	}else if(A.length==0) {
    		return 0;
    	}
    	
    	// 최대합 구하기
    	int localMaxValue = A[0];
    	int localMaxSum = A[0];
    	
    	for(int i=1; i<A.length; i++) {
    		
    		localMaxValue = Math.max(A[i], A[i]+localMaxValue);
    		
    		localMaxSum = Math.max(localMaxSum, localMaxValue);
    	}
    	
    	return localMaxSum;
    }
}

public class MaxSliceSum_Sol_01 {
	
	public static void main(String[] args) {
		MaxSliceSum_Solution_01 sol = new MaxSliceSum_Solution_01();
		int[] A = {3, 2, -6, 4, 0};
		System.out.println(sol.solution(A));
	}

}
