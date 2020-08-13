package lesson4.counting.elements;

import java.util.HashSet;
import java.util.Set;

// 문제: PermCheck
/*
A non-empty array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.
The goal is to check whether array A is a permutation.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.
Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
*/
/*
1. 문제 요약
- N개의 정수로 구성된 비어 있지 않은 배열 A가 제공된다.
- 순열은 1에서 N까지의 각 요소를 한번만 포함하는 시퀀스이다. 

2. 솔루션
- set 사용

3. 시간복잡도
: O(N) or O(N * log(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class  PermCheck_Solution_01 {
    public int solution(int[] A) {
    	
    	// Set 사용
    	Set<Integer> numSet = new HashSet<Integer>();
    	for(int n: A) {
    		if(n>A.length) {
    			return 0;
    		}
    		if(numSet.contains(n)) {
    			return 0;
    		}else {
    			numSet.add(n);
    		}
    	
    	}
    	
    	return 1;
       
    }
}

public class PermCheck_Sol_01 {

}
