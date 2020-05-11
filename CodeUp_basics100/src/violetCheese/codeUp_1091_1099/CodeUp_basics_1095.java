package violetCheese.codeUp_1091_1099;

import java.util.Scanner;

public class CodeUp_basics_1095 {

	// 메인 메서드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		String[] strNum = str2.split(" ");
		str1 = str1.trim();

		int n = Integer.parseInt(str1);
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(strNum[i]);
		}

		for (int j = 1; j < n; j++) {
			if (num[0] > num[j]) {
				num[0] = num[j];
			}
		}

		System.out.print(num[0]);

		sc.close();

	}// 메인 메서드

}// CodeUp_basics_1095 클래스 끝
