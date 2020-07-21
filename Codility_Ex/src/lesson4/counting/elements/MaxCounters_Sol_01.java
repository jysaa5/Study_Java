package lesson4.counting.elements;

import java.util.Arrays;

// 문제: MaxCounters
/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:
class Solution { public int[] solution(int N, int[] A); }
that, given an integer N and a non-empty array A consisting of M integers,
returns a sequence of integers representing the values of the counters.
Result array should be returned as an array of integers.
For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.
Write an efficient algorithm for the following assumptions:
N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/
/* 
솔루션:
N 카운터들 -> 초기화 = 0
카운터들의 작동 함수: 
increase(X) = 카운터 X는 1씩 증가한다. 
max counter = 모든 카운터들을 현재 같고 있는 최대값으로 설정된다.
배열 A = M 정수들, 비어있지 않음. 연속작업을 한다.
i) A[k] = X 이고 1<=X<=N이면, K는 increase(X)로 작동
ii) A[k] = N+1이면 K는 maxcounter로 작동
*/
class MaxCounters_Solution_01 {
	//배열의 maximum 값을 찾아주는 함수
	public int findMax(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length-1];
	}
	
    public int[] solution(int N, int[] A) {
    	
    	int[] nums = new int[N];
    	
    	for(int j=0; j<A.length; j++) {
    		
    		if(1<=A[j] && A[j]<=N) {
    			nums[A[j]-1] ++;
    		}else if(A[j]==N+1) {
    			int max = findMax(nums);
    			Arrays.fill(nums, max);
    			
    		}
    				
    	}
    	return nums;
        
    }
}

public class MaxCounters_Sol_01 {
	public static void main(String[] args) {
		
		MaxCounters_Solution_01 sol = new MaxCounters_Solution_01();
		int N = 5;
		int[] A = {3, 4, 4, 6, 1, 4, 4};
		for(int n: sol.solution(N, A)) {
			System.out.print(n);
		}
		
	}

}
