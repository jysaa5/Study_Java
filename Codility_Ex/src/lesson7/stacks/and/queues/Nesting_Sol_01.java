package lesson7.stacks.and.queues;

import java.util.Stack;
//문제: Nesting 
/*
A string S consisting of N characters is called properly nested if:
S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, 
returns 1 if string S is properly nested and 0 otherwise.
For example, given S = "(()(())())", the function should return 1 and given S = "())",
the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
*/
/*
1. 문제 요약
- 문자열 S는 N개의 문자들을 가지고 있고 아래 조건들을 만족하면 적절한 nested로 부른다.
- S는 비어 있다.
- S는 "(U)" 형태를 가지고 있을 때, U는 적절한 nested 문자열이다. 
- S는 "VM" 형태를 가지고 있을 때, V와 M은 적절한 nested 문자열이다.
- 예를 들어, 문자열이 "(()(())())"은 적절한 nested이지만 "())"는 그렇지 않다.
- 문자열 S가 N개 문자들을 가자ㅣ고 있고 적절한 nested이면 1을 반환하고 아니면 0을 반환한다.
- N 범위: [0,...1,000,000]
- 문자열 S: "(" , ")" 문자들만 가지고 있다.

2. 솔루션 
- stack 사용
- for문
- if문ㄴ

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class Nesting_Solution_01 {
	public int solution(String S) {
		Stack<Character> ch = new Stack<Character>();

		if (S.length() == 0) {
			return 1;
		}

		for (int i = 0; i < S.length(); i++) {
			if (ch.isEmpty()) {
				if (S.charAt(i) == '(' || S.charAt(i) == ')') {
					ch.push(S.charAt(i));
				}
			} else {
				char n = ch.peek();

				if (n == '(' && S.charAt(i) == ')') {
					ch.pop();
				} else {
					ch.push(S.charAt(i));
				}

			}
		}

		if (ch.isEmpty()) {
			return 1;
		}

		return 0;

	}

}

public class Nesting_Sol_01 {

	public static void main(String[] args) {
		
		//String S = "(()(())())";
		String S = "())";
		Nesting_Solution_01 sol = new Nesting_Solution_01();
		System.out.println(sol.solution(S));

	}

}
