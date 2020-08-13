package chapter11.collections.framework;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_02 {
	
	public static void main(String[] args) {
		
		int[] arr = {3,1,5,2,7,9};
		int[] arr2 = {3,1,5,2,7,2};
		
		// toString
		System.out.println(Arrays.toString(arr));
		
		int[][] arr2D = {{11, 12}, {21, 22}};
		int[][] arr2D2 = {{11, 12}, {21, 22}};
		
		// toString, deepToString
		System.out.println(Arrays.toString(arr2D));
		System.out.println(Arrays.deepToString(arr2D));
		
		//equals, deep
		System.out.println(Arrays.equals(arr, arr2));
		System.out.println(Arrays.deepEquals(arr2D, arr2D2));
		System.out.println(Arrays.equals(arr2D, arr2D2));
		
		//aslist
		List list = Arrays.asList(1,2,3,4,5);
		
		
		//list.add(6); //예외 발생		
		
		List list2 = new ArrayList(list);
		list2.add(6);
		
		int[] arr1 = {3,1,5,2,7,9};
		System.out.println(Arrays.binarySearch(arr1, 2));
		
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.binarySearch(arr1, 2));
		
	}

}
