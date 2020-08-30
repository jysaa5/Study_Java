package lesson10.prime.and.composite.numbers;
// 문제: CountFactors
/*
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the number of its factors.
For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. 
There are no other factors of 24.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..2,147,483,647].
*/
/*
1. 문제요약
양의 정수 D는 N = D * M과 같은 정수 M이있는 경우 양의 정수 N의 인수이다.
예를 들어, M = 4는 위의 조건 (24 = 6 * 4)을 충족하므로 6은 24의 인수이다.
함수 작성 :
class Solution {public int solution (int N); }
양의 정수 N이 주어지면 인수의 수를 반환한다.
예를 들어 N = 24이면 함수는 8을 반환해야한다. 24에는 8 개의 요인, 즉 1, 2, 3, 4, 6, 8, 12, 24가 있기 때문이다.
24의 다른 인수는 없다.
다음 가정에 대한 효율적인 알고리즘을 작성하라.
N은 [1..2,147,483,647] 범위 내의 정수이다.

2. 솔루션
- for문 사용
- Math.sqrt 사용
- Math.pow 사용

3. 시간복잡도
: O(sqrt(N))

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/
class CountFactors_Solution_02 {
    public int solution(int N) {
    	
    	if(N==0 || N<0) {
    		return 0;
    	}
    	
    	int result = 0;
    	int squareRootN = (int)Math.sqrt(N);
    	
    	if(Math.pow(squareRootN, 2) != N) {
    		squareRootN++;
    	}else {
    		result++;
    	}
    	
    	for(int i=1; i<squareRootN; i++) {
    		if(N%i==0) {
    			result += 2;
    		}
    	}
        return result;
    }
}
public class CountFactors_Sol_02 {
	
	public static void main(String[] args) {
		int N = 24;
		CountFactors_Solution_01 sol = new CountFactors_Solution_01();
		System.out.println(sol.solution(N));
	}

}
