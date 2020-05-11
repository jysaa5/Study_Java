package imp.data.type;

public class DatatTypeAndPlusOperator {
	
	public static void main(String[] args) {
		
		String str1 = "ABC";
		
		boolean b = true;
		byte by = 127;
		short sh = 32767;
		int num = 2020;
		long lo = 20212223;
		float f = 12.20f;
		//double d = 53.99d;
		double d = 53.99;
		char c = 'A';
		
		
		////////////////String + 기본형 데이터////////////////////////
		
		//String + boolean = String
		System.out.println(str1+b);
		DataTypeMethod.getInstance().dataTypePrint(str1+b);
		
		
		//String + byte = String
		System.out.println(str1+by);
		DataTypeMethod.getInstance().dataTypePrint(str1+by);
		
		
		//String + short = String
		System.out.println(str1+sh);
		DataTypeMethod.getInstance().dataTypePrint(str1+sh);
		
		//String + int = String
		System.out.println(str1+num);
		DataTypeMethod.getInstance().dataTypePrint(str1+num);
		
		
		//String + long = String
		System.out.println(str1+lo);
		DataTypeMethod.getInstance().dataTypePrint(str1+lo);
		
		//String + float = String
		System.out.println(str1+f);
		DataTypeMethod.getInstance().dataTypePrint(str1+f);
		
		
		//String + double = String
		System.out.println(str1+d);
		DataTypeMethod.getInstance().dataTypePrint(str1+d);
		
		
		//String + char = String
		System.out.println(str1+c);
		DataTypeMethod.getInstance().dataTypePrint(str1+c);
		
		
	    ///////////////char + 기본형 ///////////////////	
		
		//char + boolean = 덧셈 연산 불가능
		//System.out.println(c+b);
		//DataTypeMethod.getInstance().dataTypePrint(c+b);
		
		
		//char + char = int
		System.out.println(c+c);
		DataTypeMethod.getInstance().dataTypePrint(c+c);
		
		
		//char + byte = int
		System.out.println(c+by);
		DataTypeMethod.getInstance().dataTypePrint(c+by);
		
		
		//char + short = int
		System.out.println(c+sh);
		DataTypeMethod.getInstance().dataTypePrint(c+sh);
		
		
		//char + int = int
		System.out.println(c+num);
		DataTypeMethod.getInstance().dataTypePrint(c+num);
		
		
		//char + float = float
		System.out.println(c+f);
		DataTypeMethod.getInstance().dataTypePrint(c+f);
		
		
		//char + double = double
		System.out.println(c+d);
		DataTypeMethod.getInstance().dataTypePrint(c+d);
		
	}
}