package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1316 (그룹 단어 체커)
import java.util.Scanner;

public class Group_Word_Checkers_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine().trim());
		int ans = n;

		for (int i = 0; i < n; i++) {
			String word = sc.nextLine().trim();
			boolean[] checker = new boolean[26];

			for (int j = 1; j < word.length(); j++) {
				if (word.charAt(j - 1) != word.charAt(j)) {
					if (checker[word.charAt(j) - 97] == true) {
						ans--;
						break;
					}
					checker[word.charAt(j - 1) - 97] = true;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
