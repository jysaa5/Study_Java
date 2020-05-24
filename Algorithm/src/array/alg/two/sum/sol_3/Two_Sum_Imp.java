package array.alg.two.sum.sol_3;

import java.util.HashMap;

/*
출처: LeetCode, Two Sum
문제: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
= 정수값이 담긴 어레이가 하나 있다. 그 배열 안에 있는 숫자 중에 숫자 2개를 더해서 특정한 값이 나오면 그 두 숫자의 어레이 인덱스를 반환해라. 
배열 안에는 정답이 딱 2개만 있다. 같은 값을 쓸 수 없고 값은 2개의 인덱스를 반환해라.

ex) 2개의 값을 더해서 5가 나오는 배열 인덱스 2개를 반환해라.
|6|4|3|8|7|5|2| 

-> 솔루션 3: Hash Table
-> 배열을 한 번 돌면서 hash table의 값을 key 담고, value는 인덱스를 담는다. 
key|6|4|3|8|7|5|2| 
val|0|1|2|3|4|5|6| 

-> 포인터 1개를 선언해서 배열방을 돌면서 값을 1개씩 5에서 빼어서 (5 - 값 = 나머지 값 ) 의 나머지 값을 배열 방에 서 찾는다.
-> 담으면서 포인터도 돌리기
-> 시간복잡도: O(2n) -> O(n)

*/

//Solution 클래스
class Solution{
	
	// nums: 데이터 배열
	// target: 배열 값의 합
	// twoSum 메서드 
	public int[] twoSum(int[] nums, int target) {
	
		HashMap<Integer, Integer>map = new HashMap<Integer,Integer>();
		
		// 검색하면서 해시테이블에 값을 저장한다.
		for(int i= 0; i<nums.length; i++) {
			
			if(map.containsKey(target-nums[i])) {

				return new int[] {map.get(target-nums[i]), i};
			
			}
			
			// 해시맵에 값을 저장
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}// twoSum 메서드 종료
	
}// Solution 클래스 종료


// Two_Sum_Imp 클래스
public class Two_Sum_Imp {

	// main 메서드 
	public static void main(String[] args) {
		
		int[] nums = {6,4,3,8,7,5,2};
		
		Solution sol = new Solution();
		
		int[] result = sol.twoSum(nums, 5);
		
		System.out.println(result[0]+", "+result[1]);
		
	}// main 메서드 종료
	
}// Two_Sum_Imp 클래스 종료