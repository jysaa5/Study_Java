package lesson7.stacks.and.queues;

import java.util.Stack;

// 문제: Brackets
/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:
class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
For example, given S = "{[()()]}",
the function should return 1 and given S = "([)()]",
the function should return 0, as explained above.
Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/
/*
1. 문제 요약
- 문자열 s: N개의 문자들로 이루어져 있다. 아래와 같은 조건중에 어떤 것이든지 참이라면 적합한 세트라고 여겨진다.
-> S는 비어 있다.
-> S가 (U) 또는 [U] 또는 {U} 형식을 가지고 있다면, U는 적합한 문자열 세트이다. 
-> S는  vM 형식을 가지고 있다면 V와 M은 적합한 세트 문자열이다. 
- 예를 들어 {[()()]}는 적합한 세트이지만 ([)()]는 그렇지 않다.
- N개의 문자들로 이루어져 있는 문자열 S는 만약 S가 적합한 세트이면 1을 반환하고 그렇지 않으면 0을 반환한다.


2. 솔루션
- for문, Stack, if문, while문

3. 시간 복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/

class Brackets_Solution_01 {
    public int solution(String S) {
    	
    	char ch = '0';
    	Stack<Character> charStack = new Stack<Character>();
    	
    	for(int i=0; i<S.length(); i++) {
    		
    		ch = S.charAt(i);
    		
    		if(charStack.isEmpty()) {
    			charStack.push(ch);
    		}else {
    			
    			if(charStack.peek()=='(' && ch == ')') {
    				charStack.pop();
    			}else if(charStack.peek()=='{' && ch =='}') {
    				charStack.pop();
    			}else if(charStack.peek()=='['&& ch==']') {
    				charStack.pop();
    			}else {
    				charStack.push(ch);
    			}
    			
    			
    		}
   
    		
    	}
    	
		while(!charStack.isEmpty()) {
			ch = charStack.peek();
			
			if((ch>='A' && ch<='Z')||(ch>='a'&&ch<='z')) {
				charStack.pop();
			}else {
				return 0;
			}
		}
    	

    		return 1;
        
    }
}


public class Brackets_Sol_01 {
	
	public static void main(String[] args) {
		
		Brackets_Solution_01 sol = new Brackets_Solution_01();
		//String S = "{[()()]}";
		//String S = "([)()]";
		String S = "VM";
		System.out.println(sol.solution(S));
		
	}

}
