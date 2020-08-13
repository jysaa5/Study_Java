package lesson2.arrays;

import java.util.Queue;
import java.util.LinkedList;

// 문제: CyclicRotation
// Rotate an array to the right by a given number of steps.
/*
An array A consisting of N integers is given. 
Rotation of the array means that each element is shifted right by one index,
and the last element of the array is moved to the first place.
For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
(elements are shifted right by one index and 6 is moved to the first place).
The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:
class Solution { public int[] solution(int[] A, int K); }
that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given
    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given
    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]
Given
    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]
Assume that:
N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/
/*
1. 문제요약
- N개의 정수로 구성된 배열 A가 제공된다.
- 배열의 회전은 각 요소가 하나의 인덱스만큼 오른쪽으로 이동함을 의미한다.
- 배열의 마지막 요소가 처음으로 이동한다.
- 예를 들어 배열 A=[3, 8, 9, 7, 6]의 회전은 [6. 3. 8. 9. 7]입니다.
- (요소는 하나의 인덱스만큼 오른쪽으로 이동하고 6은 처음으로 이동한다.) 
- 목표는 배열 A를 K번 회전하는 것이다.
- 즉, A의 각 요소가 오른쪽으로 k번 이동한다.

2. 솔루션
- if문 
- queue 사용
- for문 사용

3. 시간복잡도

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class CyclicRotation_Solution_01 {
    public int[] solution(int[] A, int K) {
        
    	if(K==0||A.length==0) {
    		
    		return A;
    	}
    	
    	int num = 0;
    	int[] result = new int[A.length];
    	// 배열을 큐에 넣기
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	for(int i=A.length-1; i>=0; i--) {
    		
    		q.offer(A[i]);
    		
    	}
    	
    	while(K>0) {
    		if(!q.isEmpty()) {
    			
    			num = q.poll();
    			
    			q.offer(num);
    			
    			K--;
    			
    		}
    	}
    	
    	for(int j=A.length-1; j>=0; j--) {
    		
    		result[j] = q.poll();
    	}
    	return result;
    }
}



public class CyclicRotation_Sol_01 {
	
	public static void main(String[] args) {
		
		CyclicRotation_Solution_01 sol = new CyclicRotation_Solution_01();
		
		int[] A= {3, 8, 9, 7, 6};
		int K = 3;
		
		for(int n: sol.solution(A, K)) {
			System.out.println(n);
		}
	}

}
