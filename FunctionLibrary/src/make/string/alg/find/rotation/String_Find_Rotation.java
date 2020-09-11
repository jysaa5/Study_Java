package make.string.alg.find.rotation;

// 문제: isSubstring() 이라는 함수가 있다. 이 함수는 어떤 문자열 안에 다른 문자열이 포함되어 있는 확인해주는 함수이다.
// 두 개의 문자열이 주어지면, isSubstring() 함수를 단 1번 사용해서 두 개의 문자열이 회전된 문자열인지 확인하는 코드를 작성하라.
// "String" -> "String"
//          -> "tringS"
//          -> "ingStr"
// Solution:
// "String" -> "ingStr" + "ingStr" -> 합
//          -> "ingStringStr" 
// isSubstring("ingStringStr", "String") 으로 해서, 원본 문자열이 포함되어 있는지 확인한다.

// String_Find_Rotation 클래스
public class String_Find_Rotation {
	
	// isRotation 메서드
	private static boolean isRotation(String s1, String s2) {
		
		// 두 문자열의 길이가 다르면 회전된 문자열이 아니다.
		if(s1.length() != s2.length())
		{
			return false;
		}
		
		return isSubstring(s1+s1, s2);
	
	}
	
	
	private static boolean isSubstring(String s1, String s2) {
		// 문자열이 포함되어 있는 지 확인
		return s1.contains(s2);
	}
	
	
	
	// main 메서드
	public static void main(String[] args) {
		System.out.println(isRotation("string", "ringst"));
		System.out.println(isRotation("string", "ingstr"));
		System.out.println(isRotation("string", "ingstn"));
		System.out.println(isRotation("string", "ringstr"));
	}// main 메서드 종료

}// String_Find_Rotation 클래스 종료
