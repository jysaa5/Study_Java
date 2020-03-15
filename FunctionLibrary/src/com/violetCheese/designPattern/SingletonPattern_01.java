package com.violetCheese.designPattern;

//디자인 패턴
//Singleton Pattern(싱글톤 패턴) 구현하기 
public class SingletonPattern_01 {

	//1.생성자 초기화
	//private 생성자: 초기화 한다.
	private SingletonPattern_01() {
		
	}//End of constructor
	
	
	//2.인스턴스 생성
	//외부에서 제공할 자기 자신의 인스턴스 생성한다.
	private static SingletonPattern_01 single = new SingletonPattern_01();
	
	
	//3.메서드 선언
	//getInstance() 메서드: 자기 자신의 인스턴스를 외부에 제공한다.
	public static SingletonPattern_01 getInstance() {
		if (single == null) {
			
			return new SingletonPattern_01();

		}else {
			
			return single;
		}
	}//End of getInstance
	

}// End of SingletonPattern_01

//멀티 스레딩 환경에서 싱글톤 패턴을 적용하면 문제가 발생할 수 있다. 
//이 코드를 좀 더 개선해야 한다. 