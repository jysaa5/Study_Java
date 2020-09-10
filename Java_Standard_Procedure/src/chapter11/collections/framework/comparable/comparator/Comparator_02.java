package chapter11.collections.framework.comparable.comparator;

import java.util.Arrays;
import java.util.Comparator;

// p.629
public class Comparator_02 {
	
	public static void main(String[] args) {
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		// String의 Comparable 구현에 의한 정렬
		Arrays.sort(strArr); 
		System.out.println("strArr = "+Arrays.toString(strArr));
		
		// 대소문자 구분 안함.
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr = "+Arrays.toString(strArr));
		
		// 역순 정렬
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr= "+Arrays.toString(strArr));
		
	}

}

class Descending implements Comparator{
	
	public int compare(Object o1, Object o2) {
		
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			// -1을 곱해서 기본 정렬 방식의 역으로 변경한다.
			// 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
			return c1.compareTo(c2)*-1;
		}
		
		return -1;
		
	}
}