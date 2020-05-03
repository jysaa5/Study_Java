package abstract_ex;

//추상클래스: 추상 클래스란 구체적이지 않은 클래스를 의미한다. -> 모호한 클래스
public abstract class Bird {

	//선언만 가능
	public abstract void sing();
	
	//메서드 구현 가능
	public void fly() {
		System.out.println("날다");
	}
	
	
	
}
