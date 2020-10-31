package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1157 (단어 공부)
import java.util.Scanner;
import java.util.HashMap;

public class Word_Study_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toUpperCase();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}

		int max = 0;
		for (char c1 : map.keySet()) {
			if (max < map.get(c1)) {
				max = map.get(c1);
			}
		}

		char c = 'A';
		int cnt = 0;
		for (char c2 : map.keySet()) {
			if (max == map.get(c2)) {
				cnt++;
				c = c2;
			}
		}

		if (cnt != 1) {
			System.out.println("?");
		} else {
			System.out.println(c);
		}
		sc.close();

	}
}
