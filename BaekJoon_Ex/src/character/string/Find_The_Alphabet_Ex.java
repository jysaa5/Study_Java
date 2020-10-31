package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10809 (알파벳 찾기)
import java.util.Scanner;

public class Find_The_Alphabet_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] alp = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if (alp[str.charAt(i) - 'a'] == 0) {
				alp[str.charAt(i) - 'a'] = i + 1;
			}
		}
		for (int j = 0; j < alp.length; j++) {
			if (alp[j] == 0) {
				alp[j] = -1;
			} else {
				alp[j] = alp[j] - 1;
			}
		}
		for (int n : alp) {
			System.out.print(n + " ");
			sc.close();
		}
	}
}
