package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2675 (문자열 반복)
import java.util.Scanner;

public class String_Repetition_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine().trim());
		String[] str = new String[t];
		int[] nums = new int[t];
		for (int i = 0; i < str.length; i++) {
			String s = sc.nextLine();
			int r = 0;
			r = Integer.parseInt(s.split(" ")[0]);
			nums[i] = r;
			str[i] = s.split(" ")[1];
		}

		for (int j = 0; j < str.length; j++) {
			for (int k = 0; k < str[j].length(); k++) {
				char c = str[j].charAt(k);
				for (int l = 0; l < nums[j]; l++) {
					System.out.print(c + "");
				}
			}
			System.out.println("");
		}
	}
}
