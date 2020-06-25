package kakao.blind.recruitment;

import java.util.*;

class Conver_Bracket_Solution_02 {
	public String solution(String p) {
		return makeCorrect(p);
	}

	// 문자열 w를 '올바른 문자열'로
	static String makeCorrect(String w) {
		if (w.length() == 0)
			return "";

		int cut = division(w);
		String u = w.substring(0, cut);
		String v = w.substring(cut, w.length());

		if (isCorrect(u)) {
			return u + makeCorrect(v);
		} else {
			String temp = '(' + makeCorrect(v) + ')';
			u = u.substring(1, u.length() - 1);
			u = reverse(u);
			return temp + u;
		}

	}

	// w를 가장 작은 크기의 균형 문자열로 자를 수 있는 index 리턴
	static int division(String w) {
		int close = 0, open = 0;
		int i;
		for (i = 0; i < w.length(); i++) {
			if (w.charAt(i) == '(') {
				open++;
			} else
				close++;
			if (open == close)
				return i + 1;
		}
		return i;
	}

	// 문자열 w의 옳은 문자열 여부 리턴
	static boolean isCorrect(String w) {
		
		int count = 0;
		
		for (int i = 0; i < w.length(); i++) {
			
			if (w.charAt(i) == '(') {
				count++;
			} else
				count--;
			if (count < 0)
				return false;
		}
		return count == 0;
	}

	// 문자열 w의 괄호방향 뒤집기
	static String reverse(String w) {

		StringBuffer ret = new StringBuffer();
		
		for (int i = 0; i < w.length(); i++) {
			
			if (w.charAt(i) == ')') {
				ret.append('(');
			} else
				ret.append(')');
		}
		return ret.toString();
	}
}

public class Conver_Bracket_Sol_02 {
	
	public static void main(String[] args) {

		Conver_Bracket_Solution_02 sol = new Conver_Bracket_Solution_02();

		 String p = ")(";
		 //	String p = "()))((()";
		 //	String p = "(()())()";
		// System.out.println(sol.balnceBracket(p));
		System.out.println(sol.solution(p));
	}

}
