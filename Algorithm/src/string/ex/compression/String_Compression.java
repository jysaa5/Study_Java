package string.ex.compression;

// 문제: 문자열을 압축
// ex) aabbbccccd
// -> a2b3c4d1 반환
// 만약, 압축본이 원본보다 크면 그냥 원본을 반환한다.
// Solution: 문자열의 문자 개수를 카운트한다.
public class String_Compression {
	
	public static void main(String[] args) {
		System.out.println(compressString("aabbbbbbccccdd"));
		System.out.println("abcd");
	}
	
	// compressString 메서드: 압축된 문자열 비교
	private static String compressString(String str) {
		String newStr = compress(str);
		
		// 두 개중에 짧은 것을 반환
		return str.length() < newStr.length() ? str : newStr;
		
	}// compressString 메서드 종료
	
	
	// compress 메서드: 문자열 압축
	private static String compress(String str) {
		// 문자의 개수 저장
		int count = 0;
		
		// 결과값을 저장할 StringBuilder 선언
		StringBuilder newString = new StringBuilder(getTotal(str));
		
		for(int i=0; i<str.length(); i++) {
			count ++;
			
			// 맨 마지막 문자이거나 이전 문자와 다른 문자일 경우
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newString.append(str.charAt(i));
				newString.append(count);
				count = 0;
			}
		}
		// String 타입을 반환
		return newString.toString();
		
	}// compress 메서드 종료

	
	// getTotal 메서드: 결과 문자열의 개수를 계산하는 메서드
	private static int getTotal(String str) {
		
		int count = 0;
		int total = 0;
		
		for(int i=0; i<str.length(); i++) {
			count ++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				
				total += 1 + String.valueOf(count).length();
				count = 0;
				
			}
			
		}
		
		return total;
		
	}// getTotal 메서드 종료
	
}// String_Compression 클래스 종료
