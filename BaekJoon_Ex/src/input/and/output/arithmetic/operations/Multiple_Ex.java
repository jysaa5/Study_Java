package input.and.output.arithmetic.operations;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2588 (°ö¼À)
import java.util.Scanner;

public class Multiple_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine().trim();
		String str2 = sc.nextLine().trim();
		int[] input1 = new int[3];
		int[] input2 = new int[3];

		for (int i = 0; i < 3; i++) {
			input1[i] = Integer.parseInt("" + str1.charAt(i));
		}

		for (int j = 0; j < 3; j++) {
			input2[j] = Integer.parseInt("" + str2.charAt(j));
		}

		int[] result = new int[4];

		int carry = 0;
		int num = 0;

		for (int l = 2; l > -1; l--) {
			StringBuilder sb = new StringBuilder();
			for (int n = 2; n > -1; n--) {
				if (n == 2) {
					carry = (input1[n] * input2[l]) / 10;
					num = (input1[n] * input2[l]) % 10;
				} else if (n == 1) {
					num = carry + (input1[n] * input2[l]);
					carry = num / 10;
					num = num % 10;
				} else {
					num = carry + (input1[n] * input2[l]);
				}

				sb.insert(0, num);
			}
			result[2 - l] = Integer.parseInt(sb.toString());
			if (2 - l == 0) {
				result[3] += result[2 - l];
			}
			if (2 - l == 1) {
				result[3] += result[2 - l] * 10;
			}
			if (2 - l == 2) {
				result[3] += result[2 - l] * 100;
			}
		}

		for (int n : result) {
			System.out.println(n);
		}

	}

}
