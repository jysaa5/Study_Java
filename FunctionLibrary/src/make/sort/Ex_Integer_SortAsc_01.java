package make.sort;

import java.util.Arrays;

// 오름차순
// 정수 배열
public class Ex_Integer_SortAsc_01 {

	public static void main(String[] args) {

		int[] arr1 = { 25, 40, 1, 53, 7, 8 };
		Arrays.sort(arr1);
		
		for (int i = 0; i < arr1.length; i++) {
			
			System.out.print(arr1[i] + " ");
			
		}
		
		System.out.println();
		
		int[] arr2 = { 25, 40, 1, 53, 7, 8 };
		
		// index가 1인 배열 부터 배열 길이인 index까지 정렬
		Arrays.sort(arr2, 1, arr2.length-1);
		
		for (int i = 0; i < arr2.length; i++) {
			
			System.out.print(arr2[i] + " ");
			
		}

	}

}
