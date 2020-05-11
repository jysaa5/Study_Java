package violetCheese.codeUp_1081_1090;

import java.util.Scanner;

public class CodeUp_basics_1088 {

	// 메인 메서드
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i <= n; i++) {

			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1088 클래스 끝
