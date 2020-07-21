package lesson4.counting.elements;

import java.util.Set;
import java.util.HashSet;
// 문제: MissingInteger
/*
This is a demo task.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/
// 솔루션:

class MissingInteger_Solution_01 {
    public int solution(int[] A) {
    	
    	// 제일 작은 양의 정수(int) 반환.
    	// 가장 작은 양의 정수(int)는 1부터 시작한다.
    	// 중복하는 수를 제외하기 위해 set 사용
    	// set 선언
    	Set<Integer> numSet = new HashSet<Integer>();
    	
    	for(int n: A) {
    		
    		numSet.add(n);
    		
    	}
    	
    	for (int i=1; i<Integer.MAX_VALUE; i++) {
    		
    		if(!numSet.contains(i)) {
    			return i;
    		}
    		
    	}
        
    	return -1;
    }
}


public class MissingInteger_Sol_01 {
	
	public static void main(String[] args) {
		
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1, 2, 3};
		int[] A = {-1, -3};
		
		MissingInteger_Solution_01 sol = new MissingInteger_Solution_01();
		System.out.println(sol.solution(A));
		
	}

}
