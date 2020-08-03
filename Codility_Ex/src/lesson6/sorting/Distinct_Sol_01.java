package lesson6.sorting;

import java.util.HashSet;

// 문제: Distinct
/*
Write a function
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers,
 returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:
 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, 
because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/
/*
1. 문제 요약
- A 배열: N개의 정수가 있다.
- A 배열의 구별되는 값의 수를 반환하라.

2. 솔루션
- for문과 HashSet을 사용한다.


3. 시간 복잡도: O(N*log(N)) or O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class Distinct_Solution_01 {
    public int solution(int[] A) {
        
    	// HashSet 선언 및 생성
    	HashSet<Integer> numSet = new HashSet<Integer>();
    	
    	for(int i=0; i<A.length; i++) {
    		
    		numSet.add(A[i]);
    		
    	}
    	
    	return numSet.size();
    	
    }
}

public class Distinct_Sol_01 {
	
	public static void main(String[] args) {
		int[] A = {2, 1, 1, 2, 3, 1};
		Distinct_Solution_01 sol = new Distinct_Solution_01();
		System.out.println(sol.solution(A));
	}

}
