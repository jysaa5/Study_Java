package chapter11.collections.framework.comparable.comparator;

import java.util.Arrays;

// p. 628
public class Comparator_01 {
	
	public static void main(String[] args) {
		
		Integer[] arr = {30, 50, 10, 40, 20};
		
		Arrays.sort(arr); //기본 정렬기준(Comparable)으로 정렬
		System.out.println(Arrays.toString(arr));
		
		// sort(Object[] objArr, Comparator c)
		Arrays.sort(arr, new DescComp()); // DescComp에 구현된 정렬기준으로 정렬
		System.out.println(Arrays.toString(arr));
		
	}

}


