package lesson7.stacks.and.queues;

import java.util.Stack;

// 문제: StoneWall
/*
You are going to build a stone wall. The wall should be straight and N meters long,
and its thickness should be constant; 
however, it should have different heights in different places.
The height of the wall is specified by an array H of N positive integers.
H[I] is the height of the wall from I to I+1 meters to the right of its left end.
In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). 
Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:
class Solution { public int solution(int[] H); }
that, given an array H of N positive integers specifying the height of the wall,
returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:
  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
*/
/*
1. 문제 요약
- 돌담을 쌓을 것입니다. 
- 벽은 똑 바르고 길이가 N meters 이어야하며 두께는 일정해야합니다.
- 그러나 다른 장소에서 다른 높이를 가져야합니다.
- 벽의 높이는 N 개의 양의 정수로 구성된 배열 H로 지정됩니다.
- H [I]는 I에서 I + 1 미터의 왼쪽 끝 오른쪽까지 벽의 높이입니다.
- 특히 H [0]은 벽의 왼쪽 끝 높이이고 H [N-1]은 벽의 오른쪽 끝 높이입니다.
- 벽은 직육면체 돌 블록 (즉, 이러한 블록의 모든면이 직사각형 임)으로 만들어야합니다.
- 당신의 임무는 벽을 만드는 데 필요한 최소 블록 수를 계산하는 것입니다.
- 벽의 높이를 지정하는 N 개의 양의 정수 배열 H가 주어지면, 빌드하는 데 필요한 최소 블록 수를 반환합니다.

2. 솔루션
- Stack 사용
- for, while, if문 사용

3. 시간복잡도
: O(N)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%
*/

class StonWall_Solution_01 {
	public int solution(int[] H) {

		// 전체 블록 수
		int blocks = 0;
		
		// 벽돌 높이 저장 stack
		Stack<Integer> stoneWall = new Stack<Integer>();

		// 전체 벽돌 높이 배열
		for (int i = 0; i < H.length; i++) {

			// stack이 비어있지 않으면서 현재 높이보다 이전 높이가 클때
			while (!stoneWall.isEmpty() && stoneWall.peek() > H[i] ) {
				stoneWall.pop();
			}

			// stack이 비어있지 않으면서 현재 높이와 이전 높이가 같을 때
			if(!stoneWall.isEmpty() && stoneWall.peek()==H[i]) {
				continue;
			}
			
			// stack이 비어있거나 이전 높이가 현재 높이보다 작을 때
			if(stoneWall.isEmpty() || stoneWall.peek() < H[i]) {
				stoneWall.push(H[i]);
				blocks++;
			}
			
		}
		
		return blocks;

	}
}

public class StonWall_Sol_01 {

	public static void main(String[] args) {
		//int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
		int[] H = {1,1,1};
		StonWall_Solution_01 sol = new StonWall_Solution_01();
		System.out.println(sol.solution(H));
	}
}
