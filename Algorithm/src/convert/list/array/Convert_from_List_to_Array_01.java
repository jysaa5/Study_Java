package convert.list.array;

// List → Array (리스트에서 배열로 변환)

import java.util.*;
public class Convert_from_List_to_Array_01 {
	public static void main(String[] args) {
		
		// List
		List<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("1");
		strList.add("2");
		
		// Array
		String[] strArray = strList.toArray(new String[strList.size()]);
		System.out.println(Arrays.toString(strArray));
		// [a, b, c, 1, 2]
		
		// 배열 출력
		for(String s : strArray) {
			System.out.println(s);
		}
		
		
	}
}
