package chapter05.array;

public class StringMethod {
	
	public static void main(String[] args) {
		
		// charAt 메서드
		String str1 = "ABCDE";
		// 문자열 str1의 4번째 문자 'D'를 ch에 저장
		char ch = str1.charAt(3);
		System.out.println(ch);
		
		// substring 메서드
		String str2 = "012345";
		// str2에서 index 범위 1~4의 문자들을 반환
		String tmp1 = str2.substring(1,4);
		String tmp2 = str2.substring(2);
		// "123"이 출력된다.
		System.out.println(tmp1);
		System.out.println(tmp2);
		
		//equals 메서드
		String str3 = "abc";
		
		if(str3.equals("abc")) {
			System.out.println("문자열일 같습니다.");
		}
		
	}

}
