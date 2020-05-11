package wrapper_ex;

public class Wrapper_01 {

	public static void main(String[] args) {
		
		//기본형
		int i1 = 5;
		
		//객체형 = 참조형 
		Integer i2 = new Integer(5);
		
		//자동으로 형변환 = AutoBoxing(오토 박싱)
		Integer i3 = 5;
		
		//참조형을 기본형으로 변환
		int i4 = i3.intValue();
		
		//Auto Unboxing(오토 언박싱)
		int i5 = i3;
		
		
	}
}
