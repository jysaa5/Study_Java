package designPattern_ex;

//디자인 패턴
//Singleton Pattern(싱글톤 패턴) 구현하기 
public class SingletonPattern_03 {

	//1.생성자 초기화
	//private 생성자: 초기화 한다.
	private SingletonPattern_03() {
		
	}//End of constructor
	
	
	//2.인스턴스 생성
	//외부에서 제공할 자기 자신의 인스턴스 생성한다. + volatile 원자화
	private static volatile SingletonPattern_03 single = new SingletonPattern_03();
	
	
	//3.메서드 선언
	//getInstance() 메서드: 자기 자신의 인스턴스를 외부에 제공한다. + synchronized 동기화 처리: 여러 쓰레드가 한번에 들어오지 못하도록 한다.
	public static SingletonPattern_03 getInstance() {
		if (single == null) {
			
			synchronized (SingletonPattern_03.class) {
				if(single ==null) {
					single = new SingletonPattern_03();
				}
			}
			return single;

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_03

//synchronized 키워드 사용, volatile 키워드 사용
//DCL(Double Checking Locking)을 사용하여 getInstance()에서 동기화 되는 영역을 줄일 수 있다.
//초기에 객체를 생성하지 않으면서도 동기화하는 부분을 작게 만들었다. 
//그러나 이 코드는 멀티 코어 환경에서 동작할 때, 하나의 CPU를 제외하고는 다른 CPU가 lock이 걸리게 된다.
