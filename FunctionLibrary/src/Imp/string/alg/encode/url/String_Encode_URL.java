package Imp.string.alg.encode.url;

// 문제: 주어진 문자열의 공백을 %20으로 변환하는 함수를 구현하시오. 문자열의 맨 끝에는 변환에 필요한 충분한 공백이 있고 실제 문자열의 사이즈를 
// 알고 있음.

// Example: Input "Mr John Smith  ", 문자열의 길이: 13
// Output "Mr%20John%20Smith"
/*
 * |M|r| |J|o|h|n| |S|m|i|t|h| | | |
 * 
 * 사이즈가 13이므로 세다가 13이 되면 그만 세면 된다.
 * 현재 공백이 2개이다. 
 * 공백: | | -> %20 -> %, 20이므로 배열방이 공백당 2개 필요함.
 * 13 + 2*2 = 17 -> 결과적으로 반환할 문자열 개수
 * 문자열 뒤쪽에 충분한 공백이 있으므로 뒤에서부터 복사한다. 
 *
 * 1. 결과 문자열 반환 인덱스(17)만큼 뒤로 간다.  
 * 2. 실제 문자열 끝에 가서 p(pointer)를 둔다.
 *                          p       i 
 * |M|r| |J|o|h|n| |S|m|i|t|h| | | | |
 * 
 * 3. 포인터에 있는 문자를 인덱스가 있는 문자를 복사한다.
 *                          p       i 
 * |M|r| |J|o|h|n| |S|m|i|t| | | | |h|
 * 
 * 4. 포인터와 인덱스를 앞으로 한 개씩 이동한다.
 *                        p       i 
 * |M|r| |J|o|h|n| |S|m|i|t| | | | |h|
 * 
 * 5. 3, 4번을 반복한다.
 *                      p       i 
 * |M|r| |J|o|h|n| |S|m|i| | | | |t|h|
 *
 *                    p       i 
 * |M|r| |J|o|h|n| |S|m| | | | |i|t|h|
 *
 *                  p       i 
 * |M|r| |J|o|h|n| |S| | | | |m|i|t|h|
 *
 * 6. p가 공백을 만나면 i에 %20을 뒤에서부터 넣어주고 i를 움직인다.
 *                p       i 
 * |M|r| |J|o|h|n| | | | | |S|m|i|t|h|
 * 
 *                p       i 
 * |M|r| |J|o|h|n| | | | |0|S|m|i|t|h|
 * 
 *                p     i 
 * |M|r| |J|o|h|n| | | |2|0|S|m|i|t|h|
 * 
 *                p   i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 *
 *                p i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 * 
 * 7. 공백을 다 넣었으면 p를 옮긴다. 그리고 5번을 반복
 *              p   i 
 * |M|r| |J|o|h|n| | |%|2|0|S|m|i|t|h|
 * 
 *              p   i 
 * |M|r| |J|o|h| | |n|%|2|0|S|m|i|t|h|
 * 
 *            p   i 
 * |M|r| |J|o|h| | |n|%|2|0|S|m|i|t|h|
 * 
 *          p   i 
 * |M|r| |J|o| | |h|n|%|2|0|S|m|i|t|h|
 * 
 *        p   i 
 * |M|r| |J| | |o|h|n|%|2|0|S|m|i|t|h|
 * 
 *      p   i 
 * |M|r| | | |J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 8. p가 공백을 만나면 i에 %20을 뒤에서부터 넣어주고 i를 움직인다.
 * 
 *      p   i 
 * |M|r| | |0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 *      p i 
 * |M|r| |2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 9. i를 앞으로 옮긴다.
 *     pi 
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 *    i p 
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 10. p를 앞으로 옮긴다.
 * 
 *   ip  
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 11. i와 p를 앞으로 옮긴다.
 * 
 * ip  
 * |M|r|%|2|0|J|o|h|n|%|2|0|S|m|i|t|h|
 * 
 * 12. "Mr%20John%20Smith" 으로 문자열로 반환
 * */ 

// String_Encode_URL 클래스
public class String_Encode_URL {

	// URLify 메서드: String(문자열)을 받아서 문자 배열로 변환해주는 메서드
	private static String URLify(String str, int len) {
		
		return URLify(str.toCharArray(), len);
		
	}// URLify 메서드 종료
	
	
	// URLify 메서드
	private static String URLify(char[] str, int len) {
		
		// 공백이 몇 개 인지 저장하는 변수
		int spaces = 0;
		
		for(int i = 0; i < len; i++) {
			if(str[i] == ' ') {
				spaces ++;
			}
		}
		
		// 문자열을 옮길 인덱스 계산
		int index = len + spaces * 2 - 1;
		
		// pointer
		for(int p = len-1; p >= 0; p--) {
			
			if(str[p] == ' ') {
				
				str[index--] = '0';
				str[index--] = '2';
				str[index--] = '%';
				
			}else {
				str[index--] = str[p];
			}	
		}
		
		return new String(str);
		
	}// URLify 메서드 종료
	
	public static void main(String[] args) {
		
		System.out.println(URLify("Mr John Smith         ", 13));
		
	}
}// String_Encode_URL 클래스 종료
