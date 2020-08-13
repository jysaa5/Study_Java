package chapter06.instance;

// p. 235

class Tv{
	// Tv의 속성(멤버변수)
	
	// 색상
	String color;
	// 전원 상태(on/off)
	boolean power;
	// 채널
	int channel;
	
	// Tv의 기능(메서드)
	// Tv를 켜거나 끄는 기능을 하는 메서드
	void power() {
		power =! power;
	}
	
	// Tv의 채널을 높이는 기능을 하는 메서드
	 void channelUp() {
		 ++channel;
	 }
	 
	 // Tv의 채널을 낮추는 기능을 하는 메서드
	 void channelDown() {
		 --channel;
	 }
}



public class TvTest {
	
	public static void main(String[] args) {
		// Tv인스턴스를 참조하기 위한 변수 t를 선언
		Tv t;
		// Tv인스턴스를 생성한다.
		t = new Tv();
		// Tv인스턴스의 멤버변수 channel의 값을 7로 한다.
		t.channel = 7;
		// Tv인스턴스의 메서드 channelDown()을 호출한다.
		t.channelDown();
		
		System.out.println("현재 채널은"+t.channel+" 입니다.");
	}

}
