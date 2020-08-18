package lesson8.leader;

import java.util.HashMap;

// 문제: EquiLeader
/*
A non-empty array A consisting of N integers is given.
The leader of this array is the value that occurs in more than half of the elements of A.
An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
For example, given array A such that:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:
0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000]
*/
/*
1. 문제 요약
- N개의 정수로 구성된 비어 있지 않은 배열 A가 제공된다.
- 이 배열의 leader는 A요소의 절반 이상에서 발생하는 값이다.
- equi leader는 인덱스가 S(0 ≤ S < N − 1)이고 두 배열 A[0], A[1], ..., A[S]와 A[S + 1], A[S + 2], ..., A[N − 1]이 가지고 있는 같은 값의 leaders이다.

2. 솔루션
- HashMap, for문, if문 사용

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/
class EquiLeader_Solution_01 {
	public int solution(int[] A) {

		// HashMap
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int max = 0;
		int leader = 0;

		for (int i=0; i<A.length; i++) {
			if(numMap.containsKey(A[i])) {
				numMap.put(A[i], numMap.get(A[i])+1);
			}else {
				numMap.put(A[i], 1);

			}
			
		}

		// 배열에서 많이 나오는 값 찾기
		for (int k : numMap.keySet()) {
			if (max < numMap.get(k)) {
				max = numMap.get(k);
				leader = k;
			}
		}
		
		System.out.println("leader: "+leader);
		
		// 큰 값이 0일때
		if(max==0){
			return 0;
		}
		
		int[] counter = new int[A.length];
		
		// leader인 값만 1로 만들고 나머지 0으로 한다.
		for(int i=0; i<A.length; i++) {
			if(A[i]==leader) {
				counter[i] = 1;
			}else {
				counter[i] = 0;
			}
		}
		
	
		int result = 0;
		// 왼쪽 배열의 개수 
		int leftLen = 0;
		// 오른쪽 배열의 개수
		int rightLen = A.length;
		// 왼쪽 배열에 있는 leader의 개수
		int leftCount = 0;
		// 오른쪽 배열에 있는 leader 개수
		int rightCount = numMap.get(leader);
		
		for(int i=0; i<A.length; i++) {
			
			leftCount += counter[i];
			rightCount -= counter[i];

			leftLen++;
			rightLen--;
			
			// 각 배열의 개수의 절반 이상의 개수만큼 leader 개수가 있을 때
			if((leftCount>leftLen/2)&&(rightCount>rightLen/2)) {
				result++;
			}
		}
		


		return result;
	}
}

public class EquiLeader_Sol_01 {
	
	public static void main(String[] args) {
		//int[] A = {4,3,4,4,4,2};
		int[] A = {4,4,4,4,4,4};
		EquiLeader_Solution_01 sol = new EquiLeader_Solution_01();
		System.out.println(sol.solution(A));
	}

}
