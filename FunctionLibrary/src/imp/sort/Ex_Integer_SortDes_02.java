package imp.sort;

import java.util.Arrays;
import java.util.Collections;

// 내림차순
// Integer 객체 배열
public class Ex_Integer_SortDes_02 {

	public static void main(String[] args) {

		Integer[] arr1 = { 25, 40, 1, 53, 7, 8 };
		
		Arrays.sort(arr1, Collections.reverseOrder());
		
		for (int i = 0; i < arr1.length; i++) {
			
			System.out.print(arr1[i] + " ");
			
		}

	}

}
