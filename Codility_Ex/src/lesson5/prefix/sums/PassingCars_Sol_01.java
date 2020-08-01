package lesson5.prefix.sums;
// 문제: PassingCars
//Count the number of passing cars on the road.
/*
A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
Array A contains only 0s and/or 1s:
0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, 
is passing when P is traveling to the east and Q is traveling to the west.
For example, consider array A such that:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
For example, given:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
*/
/*
1. 문제 요약
- A배열: 비어 있지 않은 배열이다. N개의 정수를 가지고 있다. 연속적인 원소는 도로 위에 연속적인 차들을 의미한다. 0또는 1만 갖고 있다.
- 0: 자동차가 동쪽으로 이동한다.
- 1: 자동차가 서쪽으로 이동한다.
- 목적: 지나가는 차를 세는 것이다.
- P, Q: P는 동쪽으로 Q는 서쪽으로 이동.
- (0, 1)이 되는 개수를 찾고 있다.
- 반환 값: (P, Q)의 개수 -> 1,000,000,000가 넘어가면 -1 반환

2. 솔루션
- 이중 for 문
 
3. 시간복잡도: O(N^2)
 */

class PassingCars_Solution_01 {
    public int solution(int[] A) {
      
    	int count = 0;
    	
    	for(int i=0; i<A.length; i++) {
    		if(A[i] == 0) {
    			for(int j=i+1; j<A.length; j++) {
    				if(A[j]==1) {
    					count++;
    				}
    			}
    		}
    	}
    	
    	
    	if(count>1000000000) {
    		return -1;
    	}
    	
    	return count;
    	
    }
}

public class PassingCars_Sol_01 {
	public static void main(String[] args) {
		int[] A = {0,1,0,1,1};
		PassingCars_Solution_01 sol = new PassingCars_Solution_01();
		System.out.println(sol.solution(A));
	}

}
