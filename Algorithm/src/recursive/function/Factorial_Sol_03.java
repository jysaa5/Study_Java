package recursive.function;

// 팩토리얼
// 0! = 1, 1! = 1, 2! = 1*2
public class Factorial_Sol_03 {

	// 재귀함수 이용
	static int factorial(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return factorial(number - 1) * number;
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
}
