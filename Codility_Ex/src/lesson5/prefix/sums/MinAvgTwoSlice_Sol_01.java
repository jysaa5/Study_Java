package lesson5.prefix.sums;


//문제: MinAvgTwoSlice

/*
A non-empty array A consisting of N integers is given. 
A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). 
The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. 
To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
For example, array A such that:

 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average.
If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:
 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
*/
/*
1. 문제 요약: 
- 배열A: 비어있지 않고 N개의 정수가 주어져 있다. -> 정수 개수는 최소 2개 이상이다.
- 정수 쌍(P, Q): 0 <= P < Q < N -> 배열 A의 slice -> 최소한 2가지의 수가 포함되어 있다.
- slice의 평균: (A[P] + A[P+1] + ... + A[Q])/slice의 길이(= Q-P+1)
- 최종 목표: slice의 평균이 최소가 되는 slice의 위치의 시작값을 반환한다. -> 이때의 P 값

2. 솔루션:
- a<=b일때, a와 b의 평균은 a이상이 된다. (a=b일 때, a와 b의 평균은 a이다. 즉 두 수가 같은 경우는 a혹은 b가 된다.)
- (a+b) <= (c+d) 일때, (a,b)와 (c,d)의 평균은 (a+b)이상이 된다.
- 결국, 원소가 4개 (a,b,c,d)인 그룹은 (a,b)와 (c,d)를 나누었을 대, 각각의 평균의 작은 값 이상이 된다.
- 2개인 그룹이 작은 값이 되므로 4개의 그룹은 고려할 필요가 없다.
- 예외로 원소가 3개인 그룹에서 2개인 그룹과 1개인 그룹의 경우를 확인해야 하지만 문제에서 주어진 조건에 의하면 그룹의 원소는 최소 2개 이상이므로, 2개와 3개인 그룹만 비교한다.
- 첫 2개 요소의 평균을 최소평균으로 정한뒤, 이후에 발생할 수 있는 모든 그룹(원소가 2개 혹은 3개인)에서 최소 평균값을 구하여 P에 해당하는 인덱스를 반환

3. 시간복잡도: O(N)

*/

class MinAvgTwoSlice_Solution_01 {
	public int solution(int[] A) {
		
		float minAvg = (A[0]+A[1]) / 2f;
		int minIndex = 0;
		
		// 3개 합 일때
		for(int i=2; i<A.length; i++) {
			
			float avg = (A[i-2]+A[i-1]+A[i])/3f;
			
			if(minAvg>avg) {
				minAvg = avg;
				minIndex = i-2;
			}
			
			// 2개 합 일때
			avg = (A[i-1]+A[i])/2f;
			
			if(minAvg>avg) {
				minAvg = avg;
				minIndex = i-1;
			}
		}
		return minIndex;
	}
}

public class MinAvgTwoSlice_Sol_01 {
	public static void main(String[] args) {
		
		MinAvgTwoSlice_Solution_01 sol = new MinAvgTwoSlice_Solution_01();
		int[] A = { 4, 2, 2, 5, 1, 5, 8 };
		System.out.println(sol.solution(A));
	}

}

