package lesson6.sorting;

import java.util.Arrays;

// 문제: MaxProductOfThree
/*
A non-empty array A consisting of N integers is given. 
The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
*/
/*
1. 문제 요약
- A 배열: 비어있지 않고 N개 정수들로 이루어져 있다.
- 세쌍: (P, Q, R)
- 결과값: A[P]*A[Q]*A[R] 값이 최대인 값을 반환.

2. 솔루션
- Arrays.sort 사용
- if 문 

3. 시간복잡도
: O(N * log(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class MaxProductOfThree_Solution_01 {
    public int solution(int[] A) {
        
    	int num1 = 0;
    	
    	Arrays.sort(A);

    	
    	// 음수가 2개 이상으로 섞여있을 때
    	if(A[0]<0 && A[1]<0) {
    		
    		num1 = A[0]*A[1];
    		
    	 	if(num1*A[A.length-1] >= A[A.length-1]*A[A.length-2]*A[A.length-3]) {
        		return num1*A[A.length-1];
        	}else {
        		return  A[A.length-1]*A[A.length-2]*A[A.length-3];
        	}
    		
    	}
    	
    	
    	// 전부 음수 값일 때
    	// 전부 양수 값일 때
    	
    	return A[A.length-1]*A[A.length-2]*A[A.length-3];
    }
}
public class MaxProductOfThree_Sol_01 {
	
	public static void main(String[] args) {
		
		int[] A = {-3, 1, 2, -2, 5, 6};
		MaxProductOfThree_Solution_01 sol = new MaxProductOfThree_Solution_01();
		System.out.println(sol.solution(A));
		
	}

}
