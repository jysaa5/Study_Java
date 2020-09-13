package string.ex.check.unique;

// 문제: 주어진 문자열의 문자들이 모두 고유한지를 확인하는 함수를 구현하시오. 
// 만약, 별도의 저장공간을 사용하지 못하는 경우에는 어떻게 해결할지도 추가로 설명하시오.
// Solution:
/*
 * abcddef
 * -> 문자열이 주어지면, 중복된 문자가 있는지 확인하고 결과를 반환하는다. 
 * -> Bit Operator
 * -> a ~ z : 26개
 * -> 2^n 
 * -> 정수의 최대값: 2^31
 * -> 문자: 2^26
 * -> ASCII
 * -> a ~ z ( 97 ~ 122 ) = ( 0 ~ 25 )
 * 
 * */


// String_Check_Unique_Char_BitOperator 클래스
public class String_Check_Unique_Char_BitOperator {
	
	// isUnique: ASCII코드를 Bit Operator를 이용하여 스위치 처럼 이진수로 표현
	private static boolean isUnique(String str){
		
		int checker = 0;
		
		for(int i=0; i< str.length(); i++) {
			
			int val = str.charAt(i) - 'a';
		
			// checker가 이미 1이면 false를 반환
			if((checker & (1<<val))>0) {
				return false;
			}
			// Bit 연산자: OR = |
			// checker에 1을 시프트한 것을 OR 연산한다.
			checker |= (1<<val);			
		
		}
		// 고유한 문자이므로 true를 반환
		return true;
	}// isUnique 메서드 종료
	
	
	// main 메서드
	public static void main(String[] args) {
		
		// 아스키코드
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main 메서드

}// String_Check_Unique_Char_BitOperator 클래스 종료



// 추가 공간을 사용하지 않을 때, 문자열 안의 중복되는 문자가 있는지 확인하는 방법.
// Solution 1: 문자 한개씩 처음부터 돌면서, 뒤에 있는 문자들과 중복되는 지 확인한다. 시간 복잡도 = O(n^2)
// Solution 2: 문자열들을 퀵정렬 시킨후, 바로 옆에 있는 문자들과 비교한다. 시간복잡도 = O(2n log n) = O(n log n)


