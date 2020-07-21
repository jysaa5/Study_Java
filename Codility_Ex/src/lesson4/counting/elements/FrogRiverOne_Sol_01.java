package lesson4.counting.elements;

import java.util.HashSet;
import java.util.Set;

// 문제: FrogRiverOne
/*
A small frog wants to get to the other side of a river. 
The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). 
Leaves fall from a tree onto the surface of the river.
You are given an array A consisting of N integers representing the falling leaves. 
A[K] represents the position where one leaf falls at time K, measured in seconds.
The goal is to find the earliest time when the frog can jump to the other side of the river. 
The frog can cross only when leaves appear at every position across the river from 1 to X 
(that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves).
You may assume that the speed of the current in the river is negligibly small, 
i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. 
This is the earliest time when leaves appear in every position across the river.

Write a function:
class Solution { public int solution(int X, int[] A); }
that, given a non-empty array A consisting of N integers and integer X,
returns the earliest time when the frog can jump to the other side of the river.
If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.
Write an efficient algorithm for the following assumptions:
N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
*/
/*
솔루션: X의 위치에 나뭇잎이 떨어질때, 이전에 떨어진 나뭇잎값이 해당 X의 값들 이전의 위치들에 다 나뭇잎이 떨어져 있어야 한다.
HashSet 사용한다.
*/
// 시간복잡도: O(N)
class FrogRiverOne_Solution_01 {
    public int solution(int X, int[] A) { 
    	
    	Set<Integer> leaftSet = new HashSet<Integer>();
    	
    	for(int i=0; i<A.length; i++) {
    		 
    		// 해당 위치의 나뭇잎이 떨어질때까지 set에 추가
    		if(A[i]<=X) {
    			leaftSet.add(A[i]);
    			
    			// set의 크기가 해당 위치가 되면 시간이 i 반환
    			if(leaftSet.size() == X) {
    				return i;
    			}
    		}
    	}
    	
    	
     
    	return -1;
    }
}

public class FrogRiverOne_Sol_01 {
	
	public static void main(String[] args) {
		
		int[] A = {1,3,1,4,2,3,5,4};
		int X = 5;
		FrogRiverOne_Solution_01 sol = new FrogRiverOne_Solution_01();
		System.out.println(sol.solution(X, A));
	}

}