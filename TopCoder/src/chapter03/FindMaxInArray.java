package chapter03;

public class FindMaxInArray {

	// 배열에서 최대 정수값 구하기
	int getMaxNum(int[] array) {
	
		int ret = array[0];

		for (int i = 1; i < array.length; i++) {

			if (ret < array[i]) {
				ret = array[i];
			}
		}

		return ret;
	}
	
	
	// Test
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};
		
		FindMaxInArray ar = new FindMaxInArray();
		
		System.out.println(ar.getMaxNum(array));
		
	}

}
