package sort.number.size;

// 배열의 최대값, 최소값 구하기
// 1)solution
public class Max_Min_Sol_01 {

	// 최대값 구하는 메서드
	public int max(int[] nums) {

		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		return max;
	}

	// 최소값 구하는 메서드
	public int min(int[] nums) {

		int min = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		return min;
	}

	// 메인 메서드
	public static void main(String[] args) {

		// 최대값, 최소값을 구할 int 배열
		int array[] = { 4, 3, 2, 1, 10, 8, 7, 6, 9, 5 };

		Max_Min_Sol_01 mm = new Max_Min_Sol_01();

		System.out.println("최대값: " + mm.max(array));
		System.out.println("최소값: " + mm.min(array));
	}

}
