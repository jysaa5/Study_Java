package lesson8.leader;

import java.util.HashMap;

import java.util.Stack;

// 문제: Dominator
/*
An array A consisting of N integers is given. 
The dominator of array A is the value that occurs in more than half of the elements of A.
For example, consider array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A 
(namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, 
returns index of any element of array A in which the dominator of A occurs. 
The function should return −1 if array A does not have a dominator.
For example, given array A such that
 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/
/*
1. 문제 요약
- N개의 정수로 구성된 배열 A가 제공된다.
- 배열 A의 지배자는 A요소의 절반 이상에서 발생하는 값이다.
- 예를 들어 배열 A를 다음과 같이 고려하라.
 A [0] = 3 A [1] = 4 A [2] = 3
 A [3] = 2 A [4] = 3 A [5] = -1
 A [6] = 3 A [7] = 3
- A의 지배자는 A의 8 개 요소 중 5 개 
- (즉, 인덱스가 0, 2, 4, 6 및 7 인 요소)에서 발생하고 5는 8의 절반 이상이기 때문에 3이다.
- N 개의 정수로 구성된 배열 A가 주어지면 A의 지배자가 발생하는 배열 A의 모든 요소의 인덱스를 반환한다.
- 배열 A에 지배자가 없으면 함수는 −1을 반환해야한다.
- 함수는 위에서 설명한대로 0, 2, 4, 6 또는 7을 반환 할 수 있다.
- 다음 가정에 대한 효율적인 알고리즘을 작성하라.
- N은 [0..100,000] 범위 내의 정수이고;
- 배열 A의 각 요소는 [-2,147,483,648..2,147,483,647] 범위 내의 정수이다.

2. 솔루션

3. 시간복잡도

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class Dominator_Solution_01 {
    public int solution(int[] A) {
    	
    	if(A.length==0) {
    		return -1;
    	}
    	
    	HashMap<Integer, Integer> hm = new HashMap<>();
    	int max = 1;
    	
    	for(int a:A) {
    		if(!hm.containsKey(a)) {
    			hm.put(a, 1);
    		}else {
    			hm.put(a, hm.get(a)+1);
    			
    			
    			if(max<hm.get(a)) {
    				max = hm.get(a);
    			}
    		}
    		
    	}
    	
    	if(max <= A.length/2) {
    		return -1;
    	}
    	
    	System.out.println(max);
    	
        
    }
}

public class Dominator_Sol_01 {
	public static void main(String[] args) {
		int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
		Dominator_Solution_01 sol = new Dominator_Solution_01();
		System.out.println(sol.solution(A));
	}

}
