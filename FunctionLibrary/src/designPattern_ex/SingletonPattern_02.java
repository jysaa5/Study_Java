package designPattern_ex;

//디자인 패턴
//Singleton Pattern(싱글톤 패턴) 구현하기 
public class SingletonPattern_02 {

	//1.생성자 초기화
	//private 생성자: 초기화 한다.
	private SingletonPattern_02() {
		
	}//End of constructor
	
	
	//2.인스턴스 생성
	//외부에서 제공할 자기 자신의 인스턴스 생성한다.
	private static SingletonPattern_02 single = new SingletonPattern_02();
	
	
	//3.메서드 선언
	//getInstance() 메서드: 자기 자신의 인스턴스를 외부에 제공한다. + synchronized 동기화 처리: 여러 쓰레드가 한번에 들어오지 못하도록 한다.
	public static synchronized SingletonPattern_02 getInstance() {
		if (single == null) {
			
			return new SingletonPattern_02();

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_02

//synchronized 키워드 사용
//이 키워드를 사용하면 성능상에 문제점이 존재한다.