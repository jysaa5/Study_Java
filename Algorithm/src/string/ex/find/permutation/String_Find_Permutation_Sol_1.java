package string.ex.find.permutation;

// 문제: 주어진 두 개의 문자열이 서로 치환되는지를 알아내는 함수를 구현하시오.
// 치환: 어떤 문자열 안에 문자의 순서를 바꾼것을 말한다. 두 개의 문자열이 서로 치환이 되려면, 가지고 있는 문자의 개수와 종류가 같아야된다.
// 대소문자 구별, 공백 인정하고 문제 풀이한다. 

// Solution 1: 문자열 2개를 정렬하고 앞에서 부터 같은지 비교한다.

// String_Find_Permutation_Sol_1 클래스
public class String_Find_Permutation_Sol_1 {
	
	// sort 메서드: 문자열 정렬
	private static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.parallelSort(content);
		return new String(content);
	}// sort 메서드 종료
	
	// permutation 메서드: 치환이 되는지 확인
	private static boolean permutation(String s, String t) {
		
		// 문자열의 길이가 다를 때
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
		
	}// permutation 메서드 종료
	
	
	
	
	// main 메서드
	public static void main(String[] args) {
		
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));
		
	}// main 메서드 종료
	
}// String_Find_Permutation_Sol_1 클래스 종료
