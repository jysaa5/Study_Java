package sort.number.size;

import java.util.Arrays;

// 배열의 최대값, 최소값 구하기
// 2.solution
public class Max_Min_Sol_02 {

	// 최대값
	public int max(int[] nums) {
		Arrays.sort(nums);

		return nums[0];
	}

	// 최소값
	public int min(int[] nums) {
		Arrays.sort(nums);

		return nums[nums.length - 1];
	}

	// 메인 메서드
	public static void main(String[] args) {

		int array[] = { 4, 3, 2, 1, 10, 8, 7, 6, 9, 5 };

		Max_Min_Sol_02 mm = new Max_Min_Sol_02();

		System.out.println(mm.max(array));
		System.out.println(mm.min(array));

	}

}
