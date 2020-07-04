package greedy;

import java.util.Stack;

/*
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number     | k | return
1924       | 2 | 94
1231234    | 3 | 3234
4177252841 | 4 |775841

*/
/*
솔루션: 
- k개를 지우지만, n = length - k 라고 하고 n개를 선택하는 문제로 바꾼다.
- 선택할 수 있는 범위는 선택한 숫자 오른편에 아직 선택해야 할 갯수와 같거나 많은 숫자가 남아 있어야 한다.
- 시간 절약을 위해 stringBuilder를 사용한다.


*/

class Make_Max_Number_Solution_03 {
	
	public String solution(String number, int k) {
	
		char[] result = new char[number.length() - k];
		
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
		
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}
}

public class Make_Bigger_Number_Sol_03 {
	public static void main(String[] args) {

		String number = "1924";

		int k = 2;

		Make_Max_Number_Solution_01 sol = new Make_Max_Number_Solution_01();

		System.out.println(sol.solution(number, k));

	}
}
