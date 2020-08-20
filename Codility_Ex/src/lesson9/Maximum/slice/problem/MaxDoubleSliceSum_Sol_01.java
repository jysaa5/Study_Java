package lesson9.Maximum.slice.problem;

// 문제: MaxDoubleSliceSum
/*
A non-empty array A consisting of N integers is given.
A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:
double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
For example, given:
    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
*/
/*
1. 문제 요약
- N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공된다.
- 0 ≤ X <Y <Z <N과 같은 삼중 선 (X, Y, Z)을 이중 슬라이스라고 한다.
- 이중 슬라이스 (X, Y, Z)의 합은 A [X + 1] + A [X + 2] + ... + A [Y − 1] + A [Y + 1] + A [Y + 2] + ... + A [Z − 1].
- 예를 들어 배열 A는 다음과 같다.
    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2

- 다음 예제 이중 슬라이스를 포함한다.
- 이중 슬라이스 (0, 3, 6), 합계는 2 + 6 + 4 + 5 = 17,
- 이중 슬라이스 (0, 3, 7), 합계는 2 + 6 + 4 + 5 − 1 = 16,
- 이중 슬라이스 (3, 4, 5), 합계는 0입니다.
- 목표는 이중 슬라이스의 최대 합을 찾는 것이다.

함수 작성 :
class Solution {public int solution (int [] A); }
N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 이중 슬라이스의 최대 합을 반환한다.
예를 들면 다음과 같다.
    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
배열 A의 이중 슬라이스의 합이 17보다 크지 않으므로 함수는 17을 반환해야한다.
다음 가정에 대한 효율적인 알고리즘을 작성해라.
N은 [3..100,000] 범위 내의 정수이다.
배열 A의 각 요소는 [-10,000..10,000] 범위 내의 정수이다.

2. 솔루션
- Kadane’s algorithm

3. 시간 복잡도
:O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class MaxDoubleSliceSum_Solution_02 {
    public int solution(int[] A) {
    	
    	  int N = A.length;
    	  int[] K1 = new int[N];
    	  int[] K2 = new int[N];

    	  for(int i = 1; i < N-1; i++){
    	    K1[i] = Math.max(K1[i-1] + A[i], 0);
    	  }
    	  for(int i = N-2; i > 0; i--){
    	    K2[i] = Math.max(K2[i+1]+A[i], 0);
    	  }

    	  int max = 0;

    	  for(int i = 1; i < N-1; i++){
    	    max = Math.max(max, K1[i-1]+K2[i+1]);
    	  }

    	  return max;


    }
}
public class MaxDoubleSliceSum_Sol_01 {

	public static void main(String[] args) {
		int[] A = {3,2,6,-1,4,5,-1,2};
		//int[] A = {3,2,6,1,4,5,1,2};
		//int[] A = {-3,-2,-6,-1,-4,-5,-1,-2};
		
		MaxDoubleSliceSum_Solution_02 sol = new MaxDoubleSliceSum_Solution_02();
		System.out.print(sol.solution(A));
	}

}
