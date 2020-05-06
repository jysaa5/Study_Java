package Imp.StringBuilder;

// 문제: 자바의 StringBuilder에 대해 알아보고 구현하기.
// Solution: 

// String: 문자열 합을 할 때, 이전의 문자도 또 합쳐야 한다. -> 시간복잡도 = O(xn^2)


/*
 * String joinWords(String[] words){
 *  
 *   String sentence = "";
 *   for(String w: words){
 *     sentence = sentence + w;
 *   }
 * }
 * 
 * 시간복잡도: O(x+2x+3x+..+nx) = O(x(1+2+3+..+n)) = O(xn^2)
 *
 * 
 * String joinWords(String[] words){
 *  StringBuilder sb = new StringBuilder();
 *   for(String w: words){
 *    sb.append(w);
 *   }
 *   return sb.toString();
 * }
 * 
 * 속도와 공간면에서 String보다 더 좋다.
 * 
 * StringBuilder: 비동기(Asynchronous)
 * StringBuffer: 동기(Synchronized)화 보장
 * -> StringBuilder보다는 StringBuffer 속도는 느리다.
 *    멀티쓰레드환경(thread safe)이라면 동기화를 보장하기 위해 StringBuffer를 사용해야 된다.
 * */

// StringBuilder 클래스
class StringBuilder{
	
	// 문자열을 저장할 char배열 선언
	private char[] value;
	// 배열방의 크기
	private int size;
	// 배열방의 인덱스 = 방 번호
	private int index;
	
	// 생성자
	StringBuilder(){
		// 배열방의 크기
		size = 1;
		// 크기만큼 배열을 생성한다.
		value = new char[size];
		// 생성되었을 때, 인덱스 초기화
		index = 0;
	}
	
	
	// append 메서드: 문자열을 추가하는 함수
	// str: 추가할 문자열
	public void append(String str) {
		
		if(str == null) {
			str = "null";
		}
		
		// 문자의 길이
		int len = str.length();
		// 배열방이 문자열을 담을 수 있는 지 확인 -> 부족하면 늘린다.
		ensureCapacity(len);
		
		for(int i=0; i<str.length(); i++) {
			// 한 문자씩 저장
			value[index] = str.charAt(i);
			index++;
		}
		System.out.println(size+", "+index);
	}// append 메서드 종료
	
	
	// ensureCapacity 메서드: 배열방이 넉넉하지 않으면 배열방의 크기를 늘려주는 메서드
	private void ensureCapacity(int len) {
		
		// 현재 배열방의 인덱스 + 문자열의 길이 > 배열 사이즈
		if(index + len > size) {
			// 크기를 2배로 만듦
			size = (size+len)*2;
			
			// 새로운 배열방 생성
			char[] newValue = new char[size];
		
			// 새로운 배열방의 이전 배열방의 문자열 복사
			for(int i=0; i<value.length; i++) {
				newValue[i] = value[i];
			}
			// value에 newValue을 넣는다.
			value = newValue;
			System.out.println("*** "+size+", "+index);
		
		}
		
	}// ensureCapacity 메서드 종료
	
	
	// toString 메서드: append한 것을 문자열(String)으로 반환하는 메서드
	public String toString() {
		return new String(value, 0, index);
	}
	
	
}// StringBuilder 클래스



// StringBuilder_Imp 클래스
public class StringBuilder_Imp {

	// main 메서드
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("sung");
		sb.append(" is");
		sb.append(" pretty");
		System.out.println(sb.toString());
	}// main 메서드 종료
	
}// StringBuilder_Imp 클래스 종료
