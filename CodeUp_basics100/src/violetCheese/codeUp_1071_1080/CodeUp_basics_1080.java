package violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1080 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = 1;
		int result = 0;

		while (num1 > 0) {

			if (result >= num1) {
				System.out.print(num2 - 1);
				break;
			}
			result += num2;
			num2++;
		}
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1080 클래스 끝
