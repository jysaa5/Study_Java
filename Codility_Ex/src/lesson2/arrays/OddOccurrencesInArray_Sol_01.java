package lesson2.arrays;

import java.util.HashSet;
import java.util.Set;

// 문제: OddOccurrencesInArray
// Find value that occurs in odd number of elements.
/*
A non-empty array A consisting of N integers is given.
The array contains an odd number of elements,
and each element of the array can be paired with another element that has the same value,
except for one element that is left unpaired.

For example, in array A such that:
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers fulfilling the above conditions, 
returns the value of the unpaired element.

For example, given array A such that:
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9

the function should return 7, as explained in the example above.
Write an efficient algorithm for the following assumptions:
N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times. 
 */
/*
1. 문제요약
- N개의 정수로 구성된 비어 있지 않은 배열 A가 제공된다.
- 배열에는 홀수 개의 요소가 포함되어 있다.
- 배열의 각 요소는 동일한 값을 가진 다른 요소와 쌍을 이룰 수 있다.
- 짝을 이루지 않은 하나의 요소를 제외한다.

2. 솔루션
- set

3. 시간복잡도
: O(N) or O(N*log(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/

class OddOccurrencesInArray_Solution_01 {
	public int solution(int[] A) {

		Set<Integer> set = new HashSet<>();

		for (int n : A) {

			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}

		}

		return set.iterator().next();
	}
}

public class OddOccurrencesInArray_Sol_01 {

	public static void main(String[] args) {

		int[] A = { 9, 3, 9, 3, 9, 7, 9 };

		OddOccurrencesInArray_Solution_01 sol = new OddOccurrencesInArray_Solution_01();
		System.out.println(sol.solution(A));

	}

}
