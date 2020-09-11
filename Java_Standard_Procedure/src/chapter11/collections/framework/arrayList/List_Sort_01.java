package chapter11.collections.framework.arrayList;

// List 정렬하기

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class List_Sort_01 {
	
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("가나다라");
		strList.add("abc");
		strList.add("ABCD");
		strList.add("123456");
		strList.add("!@#$");
		
		// 오름 차순
		Collections.sort(strList);
		System.out.println("Collections.sort: ");
		for(String str: strList) {
			System.out.println(str);
		}
		
		System.out.println("====================");
		
		// 내림 차순
		Collections.sort(strList, Collections.reverseOrder());
		System.out.println("Collections.reverseOrder()");
		for(String str: strList) {
			System.out.println(str);
		}
		
	}

}
