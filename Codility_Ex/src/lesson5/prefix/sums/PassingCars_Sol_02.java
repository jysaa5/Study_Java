package lesson5.prefix.sums;

import java.util.Arrays;

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
- 
 
3. 시간복잡도: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
 */

class PassingCars_Solution_02 {
    public int solution(int[] A) {
      
    	int count = 0;
    	int one = 0;
    	int[] arr = new int[A.length];
    	int j = 0;
    	
    	// 주어진 배열의 길이가 100,000을 초과할 때
    	if( A.length > 100000) {
    		return -1;
    	}
    	
    	// arr배열에 주어진 배열 A값 넣기
    	for (int i : A){
    	    arr[j] = i;
    	    j++;
    	}

    	// 주어진 배열을 정렬
    	Arrays.sort(arr);
    	
    	// 정렬된 배열에서 1의 개수 찾기
    	for(int k=0; k<arr.length; k++) {
    		if(arr[k]==1) {
    			one = arr.length - k;
    			break;
    		}
    	}
    	
    	// 주어진 배열 A에서 (0,1)쌍의 개수 카운트
    	for(int l=0; l<A.length; l++) {
    		if(A[l]==0) {
    		
    			count += one;
  
    		}else if(A[l]==1) {
    			
    			one--;
    		}
    	}
    	
    	// 결과값의 제한 
    	if( count > 1000000000 || count <0){
    	    return -1;
    	}
    	
    	return count;
    	
    }
}

public class PassingCars_Sol_02 {
	public static void main(String[] args) {
		int[] A = {0,1,0,1,1};
		PassingCars_Solution_02 sol = new PassingCars_Solution_02();
		System.out.println(sol.solution(A));
	}

}
