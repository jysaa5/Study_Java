package violetCheese.codeUp_1061_1070;

import java.util.Scanner;

public class CodeUp_basics_1070 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();

		switch (month) {
		case 1:
		case 2:
		case 12:
			System.out.print("winter");
			break;

		case 3:
		case 4:
		case 5:
			System.out.print("spring");
			break;

		case 6:
		case 7:
		case 8:
			System.out.print("summer");
			break;

		case 9:
		case 10:
		case 11:
			System.out.print("fall");
			break;
		}
		sc.close();

	}// main 메서드 끝

}// CodeUp_basics_1070 클래스 끝
