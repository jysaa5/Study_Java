package stringBuffer_ex;

public class StringBuffer_01 {
	
	public static void main(String[] args) {
		
		//StringBuffer 생성
		StringBuffer sb1 = new StringBuffer(); 
		
		//추가
		sb1.append("hello");
		
		//추가
		sb1.append(" ");
		
		//추가
		sb1.append("world");
		
		//toString(): String 변수로 반환 받을 수 있다.
		String str = sb1.toString();
		//출력
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		//sb2의 자기 자신인 this가 반환되어서 sb3에 넣은 것이다.
		StringBuffer sb3 = sb2.append("hello");
		
		//서로 같은 객체이다.
		if(sb2==sb3) {
			System.out.println("sb2 == sb3");
		}
		
		//Method Chaining을 이용한 방법
		String str2 = new StringBuffer().append("hello").append(" ").append("world").toString();
		
		System.out.println(str2);
		
	}

}
