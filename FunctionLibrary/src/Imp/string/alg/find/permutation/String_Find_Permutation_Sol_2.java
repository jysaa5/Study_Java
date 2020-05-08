package Imp.string.alg.find.permutation;

// 문제: 주어진 두 개의 문자열이 서로 치환되는지를 알아내는 함수를 구현하시오.
// 치환: 어떤 문자열 안에 문자의 순서를 바꾼것을 말한다. 두 개의 문자열이 서로 치환이 되려면, 가지고 있는 문자의 개수와 종류가 같아야된다.
// 대소문자 구별, 공백 인정하고 문제 풀이한다. 

// Solution 2: 문자열 2개를 정렬하고 앞에서 부터 같은지 비교한다. ASCII의 128개로만 구성되어 있다고 가정한다.
// 그리고 128개의 배열방을 선언하고 문자열에 있는 문자가 있으면 숫자를 증가시키고 다른 문자열과 비교할 때는 그 배열에서 숫자를 감소시킨다.
// 치환이 가능한 문자열이라면 모든 배열방의 숫자가 다 0이어야 하낟.

// String_Find_Permutation_Sol_2 클래스
public class String_Find_Permutation_Sol_2 {
	
	// permutation 메서드: 치환이 되는지 확인
	private static boolean permutation(String s, String t) {
		
		// 문자열의 길이가 다를 때
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[128];
		
		// 첫 번째 문자열에 있는 문자를 배열방에 숫자 증가 시키기
		for(int i=0; i<s.length(); i++) {
			
			letters[s.charAt(i)]++;
		
		}
		
		// 두 번째 문자열에 있는 문자가 있다면 배열방에서 숫자 감소 시키기
		for(int i=0; i<t.length(); i++) {
			
			letters[t.charAt(i)]--;
			
			// 만약 배열방에 음수가 있으때 = 두번째 문자열과 첫번째 문자열 종류가 다른 게 있다는 뜻이다.
			if(letters[t.charAt(i)]<0) {
				return false;
			}
		}
		
		return true;
		
	}// permutation 메서드 종료
	
	
	
	
	// main 메서드
	public static void main(String[] args) {
		
		System.out.println(permutation("ABC", "BCA"));
		System.out.println(permutation("ABC", "BDA"));
		
	}// main 메서드 종료
	
}// String_Find_Permutation_Sol_2 클래스 종료
