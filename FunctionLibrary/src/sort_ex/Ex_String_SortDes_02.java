package sort_ex;

import java.util.Arrays;
import java.util.Collections;

// 1.문자열 내림차순으로 배치하기. 영문 대소문자로만 구성되며, 대문자는 소문자보다 작다. Zbcdefg -> gfedcbZ
// 2)solution
public class Ex_String_SortDes_02 {
	public String sortDesStr(String str) {
		//문자열을 문자로 쪼개서 문자 배열 생성
		String[] array = str.split("");
		//배열 정렬을 역순의 Comparator을 가지고 한다.
		Arrays.sort(array, Collections.reverseOrder());
		//문자열로 배열 붙이기
		return String.join("", array);
	}

	// test
	public static void main(String[] args) {
		Ex_String_SortDes_02 strSd = new Ex_String_SortDes_02();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
