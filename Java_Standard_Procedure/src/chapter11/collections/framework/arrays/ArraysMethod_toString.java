package chapter11.collections.framework.arrays;

import java.util.Arrays;

// Arrays.toString() 메서드
public class ArraysMethod_toString {
	public static void main(String[] args) {
		
		String[] str = {"a", "b", "c"};
		
		// 배열의 주소값 출력
		System.out.println(str.toString());
		
		// 배열의 내용 출력
		System.out.println(Arrays.toString(str));
		
		String s = Arrays.toString(str);
		
		// 배열의 대괄호, 콤마, 띄어쓰기까지 모두 다 문자열로 변환되었다.
		for(int i=0; i<s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
	}

}
