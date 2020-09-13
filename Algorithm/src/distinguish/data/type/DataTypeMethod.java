package distinguish.data.type;

//자바 타입 판정하는 기능

public class DataTypeMethod {
	
	
	//싱글톤 패턴
	//생성자 
	private DataTypeMethod() {
		
	}
	
	//인스턴스 생성
	private static DataTypeMethod data = new DataTypeMethod();
	
	//인스턴스를 한 개만 생성해주는 메서드
	public static DataTypeMethod getInstance() {
		if (data==null) {
			return new DataTypeMethod();
		}else {
			return data;
		}
		
	}
	
	//데이터 타입에 따른 메서드
	
	public void dataTypePrint(byte data) {
		System.out.println("byte type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(short data) {
		System.out.println("short type");
		System.out.println("---------------------------");
	}

	
	public void dataTypePrint(int data) {
		System.out.println("int type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(long data) {
		System.out.println("long type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(float data) {
		System.out.println("float type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(double data) {
		System.out.println("double type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(char data) {
		System.out.println("char type");
		System.out.println("---------------------------");
	}
	
	
	public void dataTypePrint(boolean data) {
		System.out.println("boolean type");
		System.out.println("---------------------------");
	}
	
	public void dataTypePrint(String data) {
		System.out.println("String type");
		System.out.println("---------------------------");
	}
	
}
