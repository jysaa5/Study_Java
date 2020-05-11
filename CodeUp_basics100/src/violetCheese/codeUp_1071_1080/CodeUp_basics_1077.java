package violetCheese.codeUp_1071_1080;

import java.util.Scanner;

public class CodeUp_basics_1077 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = 0;

		while (num1 >= 0) {
			if (num2 <= num1) {
				System.out.println(num2);
				num2++;
			} else {
				break;
			}
		}

		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1077 클래스 끝
