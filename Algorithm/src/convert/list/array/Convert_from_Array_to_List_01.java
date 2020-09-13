package convert.list.array;

//Array → List (배열에서 리스트로 변환)

import java.util.*;
public class Convert_from_Array_to_List_01 {
	public static void main(String[] args) {
		String[] strArr = {"a", "b", "c"};
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArr));
		
		System.out.println(strList);
		// [a, b, c]
		
		Iterator<String> iter = strList.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
		}
	}
}
