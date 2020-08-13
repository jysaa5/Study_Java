package lesson6.sorting;

import java.util.Arrays;

//문제: NumberOfDiscIntersections
/*
We draw N discs on a plane. 
The discs are numbered from 0 to N − 1.
An array A of N non-negative integers, specifying the radiuses of the discs, is given.
The J-th disc is drawn with its center at (J, 0) and radius A[J].
We say that the J-th disc and K-th disc intersect if J ≠ K and 
the J-th and K-th discs have at least one common point 
(assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:
  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0
There are eleven (unordered) pairs of discs that intersect, namely:
discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.

Write a function:
class Solution { public int solution(int[] A); }
that, given an array A describing N discs as explained above, 
returns the number of (unordered) pairs of intersecting discs.
The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.
Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
*/
/*
1. 문제 요약
- 평면에 N개의 디스크를 그린다.
- 디스크의 넘버링: 0 ~ N-1
- 배열 A: N개의 음수가 아닌 정수, 디스크의 반지름이 명시되어 있음
- J번째 디스크는 센터가 (J, 0)이고 반지름은 A[J]이다.
- J번째 디스크와 K번째 디스크의 교집합이고 최소 한 개의 점을 포함하고 있다.(J와 K는 같지 않음)
- 반환값: 교차하는 디스크의 쌍의 개수
- 반환값 = -1 : 교차 수가 10,000,000를 초과하면. 
- N: 0~ 100,000
- 배열 A의 정수 범위: 0 ~ 2,147,483,647

Ex)
교차가 있는 것: 
(1, 0), (1, 2), (1, 3), (1, 4), (1, 5),
(4, 0), (4, 2), (4, 3), (4, 5), 
(2, 0), (2, 3)

2. 솔루션
- for문, if문

3. 시간 복잡도
: O(N*log(N)) or O(N)

4. Total Score
1) Task score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class NumberOfDiscIntersections_Solution_01 {
	public int solution(int[] A) {
		// A 배열의 길이
		int N = A.length;
		
		// 해당 위치에 도달하는 디스크 수
		// 현재 위치에서 값이 작은 쪽에 디스크들이 도달하는 수를 저장하는 배열
		long[] lower = new long[N];
		
		// 현재 위치에서 값이 큰 쪽에 디스크들이 도달하는 수를 저장하는 배열
		long[] upper = new long[N];
		
		// 현재 위치 기준으로 반지름을 구해서 lower, upper 배열에 담는다.
		for (int i = 0; i < N; i++) {
			// lower 배열: J - A[J]
			lower[i] = i - (long) A[i];
			
			// upper 배열: J + A[J]
			upper[i] = i + (long) A[i];
		}

		// 정렬
		Arrays.sort(lower);
		Arrays.sort(upper);

		int intersection = 0;
		int j = 0;

		// upper보다 작은 lower들은 반드시 가장 작은 upper보다 큰 반지름을 갖는다. = 접점
		for (int i = 0; i < N; i++) {
		
			while (j < N && upper[i] >= lower[j]) {
				intersection += j;
				
				// 다음 upper에서 겹치지 않게 현재 J만큼 빼준다.
				intersection -= i;
				j++;
			}
		}

		if (intersection > 10000000){
			return -1;
			}
		
		return intersection;
	}
}

public class NumberOfDiscIntersections_Sol_01 {

	public static void main(String[] args) {
		int[] A = { 1, 5, 2, 1, 4, 0 };
		NumberOfDiscIntersections_Solution_01 sol = new NumberOfDiscIntersections_Solution_01();
		System.out.println(sol.solution(A));
	}

}
