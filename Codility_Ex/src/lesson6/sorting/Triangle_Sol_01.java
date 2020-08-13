package lesson6.sorting;

import java.util.Arrays;

// 문제: Triangle
/*
An array A consisting of N integers is given. 
A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers,
returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:
  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:
  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/
/*
1. 문제 요약
- 배열 A: N 정수를 가지 있음.
- (P, Q, R) -> 0 ≤ P < Q < R < N
A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
-> 위와 같이 성립하면 1, 안 되면 0

2. 솔루션
- 정렬
- 맨 뒤에서부터 조건에 맞는 지 확인

3. 시간 복잡도
: O(N*log(N))

4. Total Score
1) Task score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class Triangle_Solution_01 {
    public int solution(int[] A) {
      
    	double[] arr = new double[A.length];
    	int j = 0;
    	
    	for(int i : A) {
    		arr[j] = i;
    		j++;
    	}
    	
    	if(A.length<3) {
    		return 0;
    	}
    	
    	Arrays.sort(arr);
		int idx = arr.length-1;
    	for (int i=0; i<arr.length; i++) {
    		
    		if(arr[idx-1]+arr[idx-2] > arr[idx]) {
    			return 1;
    		}
    		
    		idx --;
    		
    		if(idx<2) {
    			break;
    		}
    	}
    	
    	return 0;
    	
    }
}
public class Triangle_Sol_01 {
	public static void main(String[] args){
		//int[] A = {10, 2, 5, 1, 8, 20};
		int[] A = {10, 50, 5, 1};
		Triangle_Solution_01 sol = new Triangle_Solution_01();
		System.out.println(sol.solution(A));
		
	}
}
