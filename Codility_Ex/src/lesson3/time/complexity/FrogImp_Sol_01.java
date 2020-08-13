package lesson3.time.complexity;

// 문제: FrogImp
/*
A small frog wants to get to the other side of the road. 
The frog is currently located at position X and 
wants to get to a position greater than or equal to Y. 
The small frog always jumps a fixed distance, D.
Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:
class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of 
jumps from position X to a position equal to or greater than Y.

For example, given:
  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:
X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
*/
/*
1. 문제 요약
- 작은 개구리가 길 건너편으로 가고 싶어한다.
- 개구리는 현재 위치 X에 있으며 Y보다 크거나 같은 위치에 도달하려고 한다.
- 작은 개구리는 항상 고정된 거리 D를 점프한다.
- 작은 개구리가 목표에 도달하기 위해 수행해야 하는 최소 점프 수를 세어라.

2. 솔루션
- 삼항 연산자

3. 시간복잡도
: O(1)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class FrogImp_Solution_01 {
    public int solution(int X, int Y, int D) {
        int result = Y-X;
        int jump = 0;
        
        jump = (result%D) > 0 ? (result/D)+1 : result/D; 
        
        return jump;
    }
}

public class FrogImp_Sol_01 {
	
	public static void main(String[] args) {
		FrogImp_Solution_01 sol = new FrogImp_Solution_01();
		int X = 10;
		int Y = 85;
		int D = 30;
		System.out.println(sol.solution(X, Y, D));
	}

}
