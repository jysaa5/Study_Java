package make.sort;

import java.util.Arrays;

// 1.문자열 내림차순으로 배치하기. 영문 대소문자로만 구성되며, 대문자는 소문자보다 작다. Zbcdefg -> gfedcbZ
// 3)solution
public class Ex_String_SortDes_03 {
	public String sortDesStr(String str) {
		//문자열을 문자로 쪼개서 배열에 저장
		char[] sol = str.toCharArray();
		//문자 오름차순으로 정렬
		Arrays.sort(sol);
		//문자 배열을 String으로 생성 -> StringBuilder로 생성 -> 역순 정렬 -> toString으로 출력
		return new StringBuilder(new String(sol)).reverse().toString();
	}

	
	// test
	public static void main(String[] args) {
		Ex_String_SortDes_03 strSd = new Ex_String_SortDes_03();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
