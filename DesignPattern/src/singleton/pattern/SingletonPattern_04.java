package singleton.pattern;

//디자인 패턴
//Singleton Pattern(싱글톤 패턴) 구현하기 
public class SingletonPattern_04 {

	// 1.생성자 초기화
	// private 생성자: 초기화 한다.
	private SingletonPattern_04() {

	}// End of constructor

	// 2.인스턴스 생성
	// 외부에서 제공할 자기 자신의 인스턴스 생성한다. + volatile 원자화
	private static volatile SingletonPattern_04 single = new SingletonPattern_04();

	// 3.메서드 선언
	// getInstance() 메서드: 자기 자신의 인스턴스를 외부에 제공한다.
	public static SingletonPattern_04 getInstance() {
		if (single == null) {

			single = new SingletonPattern_04();

			return single;
		} else {

			return single;
		}
	}// End of getInstance

}// End of SingletonPattern_04

// volatile 키워드 사용
// 클래스가 로딩되는 시점에 미리 객체를 생성해두고 그 객체를 반환한다.

