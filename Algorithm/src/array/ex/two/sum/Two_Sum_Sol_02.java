package array.ex.two.sum;

import java.util.HashMap;

/*
출처: LeetCode, Two Sum
문제: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= 정수값이 담긴 어레이가 하나 있다. 그 배열 안에 있는 숫자 중에 숫자 2개를 더해서 특정한 값이 나오면 그 두 숫자의 어레이 인덱스를 반환해라. 
배열 안에는 정답이 딱 2개만 있다. 같은 값을 쓸 수 없고 값은 2개의 인덱스를 반환해라.

ex) 2개의 값을 더해서 5가 나오는 배열 인덱스 2개를 반환해라.
|6|4|3|8|7|5|2| 

-> 솔루션 2: Hash Table
-> 배열을 한 번 돌면서 hash table의 값을 key 담고, value는 인덱스를 담는다. 
key|6|4|3|8|7|5|2| 
val|0|1|2|3|4|5|6| 
    p1
     5 - 6 = -1 
-> 포인터 1개를 선언해서 배열방을 돌면서 값을 1개씩 5에서 빼어서 (5 - 값 = 나머지 값 ) 의 나머지 값을 배열 방에 서 찾는다.
-> 시간복잡도: O(2n) -> O(n)

*/
public class Two_Sum_Sol_02 {

	// nums: 데이터 배열
	// target: 배열 값의 합
	// twoSum 메서드
	static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// 해시 테이블에 배열의 값을 넣는 부분
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		// 해시 테이블에서 포인터를 옮기면서 합이 5인 값을 찾는 부분
		for (int i1 = 0; i1 < nums.length; i1++) {

			Integer i2 = map.get(target - nums[i1]);

			if (i2 != null && i1 != i2) {

				return new int[] { i1, i2 };

			}
		}

		throw new IllegalArgumentException("No two sum solution");

	}
	
	public static void main(String[] args) {

		int[] nums = { 6, 4, 3, 8, 7, 5, 2 };
		int[] result = twoSum(nums, 5);

		System.out.println(result[0] + ", " + result[1]);

	}
}