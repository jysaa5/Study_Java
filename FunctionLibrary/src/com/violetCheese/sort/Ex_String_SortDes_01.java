package com.violetCheese.sort;

import java.util.Arrays;
import java.util.Collections;

//1.문자열 내림차순으로 배치하기. 영문 대소문자로만 구성되며, 대문자는 소문자보다 작다. Zbcdefg -> gfedcbZ
//1)solution
public class Ex_String_SortDes_01 {

	public String sortDesStr(String str) {
		//문자열을 문자 1개씩 쪼개서 배열에 한개씩 넣기
		String[] array = str.split("");
		//배열에 넣은 문자들을 오름차순으로 정렬
		Arrays.sort(array);
		//배열을 ArrayList로 변환하고 Collections 클래스에서 기본적으로 제공하는 static 메서드인 reverse로 문자 배열 역순으로 정렬
		Collections.reverse(Arrays.asList(array));
		//문자배열을 ""를 추가해서 붙이기
		return String.join("", array);
		
	}
	
	
	
	//test
	public static void main(String[] args) {
		Ex_String_SortDes_01 strSd = new Ex_String_SortDes_01();
		System.out.println(strSd.sortDesStr("Zbcdefg"));
	}
	
}
