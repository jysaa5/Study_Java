package set_ex;

import java.util.HashSet;
import java.util.Set;

public class Set_02 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("a");
		set.add("b");

		System.out.println("set의 내용을 출력합니다.");

		// for each문으로도 출력 가능
		for (String str : set) {
			System.out.println(str);
		}
	}
}
