package chapter05;

// p. 118
// 문제: 회문
// 솔루션: 이중 for문

public class Palindrome_Sol_01 {

	public static int find(String s) {

		// 답의 문자 길이를 결정한다.
		for (int i = s.length();; i++) {

			boolean flag = true;

			for (int j = 0; j < s.length(); j++) {

				// 반대쪽에 문자가 존재하는 데, 다를 경우 플래그를 변경한다.
				if ((i - j - 1) < s.length() && s.charAt(j) != s.charAt(i - j - 1)) {

					flag = false;
					break;

				}
			}

			// 조건을 모두 만족하면 답을 리턴한다.
			if (flag) {
				return i;
			}

		}
	}

	public static void main(String[] args) {
		
		String s = "abab";
		System.out.println(find(s));

	}

}
