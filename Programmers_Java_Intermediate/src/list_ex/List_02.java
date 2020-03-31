package list_ex;

import java.util.ArrayList;
import java.util.List;

public class List_02 {
	public List<String> addArray(String[] arr1, String[] arr2) {
		List<String> list = new ArrayList<String>();

		for (String str : arr1) {
			list.add(str);
			// System.out.println(str);
		}

		for (String str : arr2) {
			list.add(str);
			// System.out.println(str);
		}

		return list;
	}

	public static void main(String[] args) {
		List_02 listClass = new List_02();
		String[] arr1 = { "a", "b" };
		String[] arr2 = { "c" };
		for (String str : listClass.addArray(arr1, arr2)) {
			System.out.println(str);
		}
	}
}
