package abstract_ex;

public class DuckExam {

	public static void main(String[] args) {

		Duck duck = new Duck();
		duck.sing();
		duck.fly();
		
		//Bird인 추상클래스는 구현이 불가능하다.
		//Bird b = new Bird();
	}

}
