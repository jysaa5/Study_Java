package Imp.string.alg.check.unique;

import java.util.HashMap;

// 문제: 주어진 문자열의 문자들이 모두 고유한지를 확인하는 함수를 구현하시오. 
// 만약, 별도의 저장공간을 사용하지 못하는 경우에는 어떻게 해결할지도 추가로 설명하시오.
// Solution:
/*
 * abcddef
 * -> 문자열이 주어지면, 중복된 문자가 있는지 확인하고 결과를 반환하는다. 
 * -> 해당 문자열이 ASCII(아스키코드)만 이루어져 있는지, Unicode(유니코드)만 이루어져 있는지 확인해야 된다.
 * 
 * 1) Unicode = 2^20 + 2^16 = 1,114,112
 * -> Unicode(유니코드): 해시맵으로 구현한다.
 * 
 * */


// String_Check_Unique_Char_UNICODE 클래스
public class String_Check_Unique_Char_UNICODE {
	
	// isUnique: Unicode(유니코드)로만 이루어져 있을 때, 구현
	private static boolean isUnique(String str){
		HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>();
		
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i);
			
			// 입력이 되었던 키인지 확인
			if(hashmap.containsKey(c)) {
				return false;
			}
			
			// 문자를 해시맵에 입력
			hashmap.put(c, true);
		}
		
		return true;
		
	}// isUnique 메서드 종료
	
	
	// main 메서드
	public static void main(String[] args) {
		
		// 아스키코드
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main 메서드

}// String_Check_Unique_Char_UNICODE 클래스 종료
