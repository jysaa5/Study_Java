package interface_ex;

//TV 인터페이스 구현 -> 모든 기능을 구현해야 된다.
public class LedTV implements TV {

	
	@Override
	public void turnOn() {
		System.out.println("켜다");
	}

	@Override
	public void turnOff() {
		System.out.println("끄다");

	}

	@Override
	public void changeVolume(int volume) {
		System.out.println("볼륨을 조정하다");

	}

	@Override
	public void changeChannel(int channel) {
		System.out.println("channel을 지정하다");

	}

}
