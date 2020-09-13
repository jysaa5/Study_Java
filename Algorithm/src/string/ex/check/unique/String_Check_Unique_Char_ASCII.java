package string.ex.check.unique;

// 문제: 주어진 문자열의 문자들이 모두 고유한지를 확인하는 함수를 구현하시오. 
// 만약, 별도의 저장공간을 사용하지 못하는 경우에는 어떻게 해결할지도 추가로 설명하시오.
// Solution:
/*
 * abcddef
 * -> 문자열이 주어지면, 중복된 문자가 있는지 확인하고 결과를 반환하는다. 
 * -> 해당 문자열이 ASCII(아스키코드)만 이루어져 있는지, Unicode(유니코드)만 이루어져 있는지 확인해야 된다.
 * 
 * 1) 아스키코드로만 이루어져 있을 때.
 * 만약 아스키코드로만 이루어져 있다면, boolean으로 이루어져 있는 배열방을 128개를 만들고 문자가 있으면 1로 바꾸고 없으면 0으로한다.
 * 중복되는 건 이미 1인 곳을 또 찾았을 때이다.
 *                               0   1   2   3  ... 126  127
 * -> ASCII(아스키코드)-> 128개 -> | 0 | 0 | 0 | 0 |   | 0 | 0 | 
 * -> Unicode(유니코드)
 * 
 * */


// String_Check_Unique_Char 클래스
public class String_Check_Unique_Char_ASCII {
	
	// isUnique: 아스키코드(128)로만 이루어져 있을 때, 구현
	private static boolean isUnique(String str){
		// 문자열의 개수가 128개 넘을 때
		if(str.length() > 128) {
			return false;
		}
		
		boolean[] char_set = new boolean [128];
		
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}// isUnique 메서드 종료
	
	
	// main 메서드
	public static void main(String[] args) {
		
		// 아스키코드
		System.out.println(isUnique("abcdefgghijk"));
		System.out.println(isUnique("abcdefghijk"));
		
	}// main 메서드

}// String_Check_Unique_Char 클래스 종료
