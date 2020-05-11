package singleton.pattern;

//디자인 패턴
//Singleton Pattern(싱글톤 패턴) 구현하기 
public class SingletonPattern_05 {

	// 1.생성자 초기화
	// private 생성자: 초기화 한다.
	private SingletonPattern_05() {

	}// End of constructor

	// 2.인스턴스 생성
	// 외부에서 제공할 자기 자신의 인스턴스 생성한다. + 중첩 클래스 Holder
	private static class SingletonHolder {
		
		private static final SingletonPattern_05 single = new SingletonPattern_05();
		
	}

	// 3.메서드 선언
	// getInstance() 메서드: 자기 자신의 인스턴스를 외부에 제공한다.
	public static SingletonPattern_05 getInstance() {

		return SingletonHolder.single;
		
	}// End of getInstance

}// End of SingletonPattern_05

// 중첩 클래스를 이용한 Holder를 사용한 방법 
// final 키워드 사용
// getInstance 메서드가 호출되기 전까지는 singleton인스턴스는 생성되지 않는다.
// 최신 VM은 클래스를 초기화하기 위한 필드 접근은 동기화한다.
// 초기화되고 나면 코드를 바꿔서 앞으로의 필드 접근에는 어떤 동기화나 검사도 필요하지 않게 된다.
// 그러므로 초기화 이후 다시 getInstance()메서드가 호출 되더라도 new SingletonPattern_05()은 호출 되지 않는다.
