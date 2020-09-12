package chapter05;

// p.184
// 문제: 마법의 숫자

class NumberMagicEasy_03 {
	public int theNumber(String answer) {

		// 카드에 숫자가 있으면 Y, 숫자가 없으면 N
		String[] c = { "YYYY", "YYYN", "YYNY", "YYNN", "YNYY", "YNYN", "YNNY", "YNNN", "NYYY", "NYYN", "NYNY", "NYNN",
				"NNYY", "NNYN", "NNNY", "NNNN" };

		for (int i = 0; i <= 15; i++) {

			if (answer.equals(c[i])) {
				return i + 1;
			}
		}
		return 0;

	}
}

public class Magic_Numbers_Sol_03 {

	public static void main(String[] args) {
		NumberMagicEasy_03 sol = new NumberMagicEasy_03();
		// String answer = "YNYY";
		// String answer = "YNNN";
		// String answer = "YYYY";
		String answer = "NYNY";
		System.out.println(sol.theNumber(answer));
	}

}
