package array.ex.two.sum;

/*
출처: LeetCode, Two Sum
문제: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= 정수값이 담긴 어레이가 하나 있다. 그 배열 안에 있는 숫자 중에 숫자 2개를 더해서 특정한 값이 나오면 그 두 숫자의 어레이 인덱스를 반환해라. 
배열 안에는 정답이 딱 2개만 있다. 같은 값을 쓸 수 없고 값은 2개의 인덱스를 반환해라.

ex) 2개의 값을 더해서 5가 나오는 배열 인덱스 2개를 반환해라.
|6|4|3|8|7|5|2| 

-> 솔루션 1: Brute Force (무식하게 푸는 방법)
포인터 2개를 선언해서 다 돌면서 2개의 합이 5인지 확인하는 방법

-> 시간복잡도: O(n^2)
*/

// Solution 클래스
public class Two_Sum_Sol_01 {

	// nums: 데이터 배열
	// target: 배열 값의 합
	// twoSum 메서드
	static int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				if (target == nums[i] + nums[j]) {

					return new int[] { i, j };

				}
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}// twoSum 메서드 종료

	// main 메서드 종료
	public static void main(String[] args) {

		int[] nums = { 6, 4, 3, 8, 7, 5, 2 };

		int[] result = twoSum(nums, 5);

		System.out.println(result[0] + ", " + result[1]);

	}
}