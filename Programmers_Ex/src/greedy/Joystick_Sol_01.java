package greedy;

// 문제: 조이스틱
// 솔루션: 그리디(Greedy) -> 탐욕법 사용

class Solution {
	public int solution(String name) {
	      
        // 1. 위, 아래 최소 이동
        int answer = 0;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i)!= 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                answer += (up < down)? up : down;
                System.out.println("ans: "+ answer);
            }
        }
        
        // 2. A 아닌 모든 문자를 들릴 수 있는 최소 좌우 이동 
        // 모든 위치에서 역으로 돌아가는 경우 최소를 찾는다. 
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                System.out.println("1: "+next);
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                System.out.println("2: "+next);
                
                // 현재 위치에서 역으로 다음 위치로 가는 것 계산
                int move = 2 * i + name.length() - next;
                
                System.out.println("move: "+move);
                minMove = Math.min(move, minMove);
                System.out.println("minMove: "+minMove);
            }
        }
        
        return answer + minMove;
    }
}

public class Joystick_Sol_01 {

	public static void main(String[] args) {
		// String name = "JAZ";
		 //String name = "JAN";
		//String name = "JEROEN";
		// String name = "AAA";
		// String name = "BBBAAAA";
		//String name = "CANAAAAANAN";
		String name = "BBBBAAAAABBB";
		Solution sol = new Solution();
		System.out.print(sol.solution(name));
	}
}
