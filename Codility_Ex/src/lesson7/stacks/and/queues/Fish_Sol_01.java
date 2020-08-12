package lesson7.stacks.and.queues;

import java.util.ArrayList;
import java.util.Stack;

// 문제: Fish
/*
You are given two non-empty arrays A and B consisting of N integers. 
Arrays A and B represent N voracious fish in a river,
ordered downstream along the flow of the river.
The fish are numbered from 0 to N − 1. 
If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. 
Initially, each fish has a unique position.

Fish number P is represented by A[P] and B[P]. 
Array A contains the sizes of the fish. 
All its elements are unique. 
Array B contains the directions of the fish. It contains only 0s and/or 1s, where:

0 represents a fish flowing upstream,
1 represents a fish flowing downstream.
If two fish move in opposite directions and there are no other (living) fish between them,
they will eventually meet each other. 
Then only one fish can stay alive − the larger fish eats the smaller one. 
More precisely, we say that two fish P and Q meet each other when P < Q,
B[P] = 1 and B[Q] = 0,
and there are no living fish between them. After they meet:

If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
We assume that all the fish are flowing at the same speed. 
That is, fish moving in the same direction never meet. 
The goal is to calculate the number of fish that will stay alive.

For example, consider arrays A and B such that:

  A[0] = 4    B[0] = 0
  A[1] = 3    B[1] = 1
  A[2] = 2    B[2] = 0
  A[3] = 1    B[3] = 0
  A[4] = 5    B[4] = 0
Initially all the fish are alive and all except fish number 1 are moving upstream.
Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too.
Finally, it meets fish number 4 and is eaten by it. 
The remaining two fish, number 0 and 4, never meet and therefore stay alive.

Write a function:
class Solution { public int solution(int[] A, int[] B); }
that, given two non-empty arrays A and B consisting of N integers,
returns the number of fish that will stay alive.

For example, given the arrays shown above, 
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [0..1,000,000,000];
each element of array B is an integer that can have one of the following values: 0, 1;
the elements of A are all distinct.
*/
/*
1. 문제 요약
- 배열 A, 배열 B: N개 정수가 가지고 있고 비어 있지 않다.
- 배열 A, 배열 B: 강의 흐름을 따라 하류로 정렬된 강에 있는 N개 탐욕스러운 물고기를 나타낸다.
- 물고기 넘버링: 0 ~ N-1
- 배열의 index가 각 물고기 번호인데, index가 작을 수록 강의 상류에 있다.
- P와 Q가 두 물고기이고 P<Q이면 물고기 P는 처음에 물고기 Q의 상류에 있다. 
- 처음에는 각 물고기가 고유한 위치를 갖는다.
- 물고기 수 P는 A[P]와 B[P]로 표시된다.
- 배열 A는 물고기의 크기를 포함한다.
- 모든 요소는 고유하다.
- 배열 B는 물고기의 방향을 포함하다.
- 0 및 / 또는 1만 포함한다. (0은 상류, 1은 하류)
- 여기서: 
- 0은 상류로 흐르는 물고기를 나타내고, 1은 하류로 흐르는 물고기를 나타낸다.
- 두 물고기가 반대 방향으로 움직이고 그들 사이에 다른 (살아있는) 물고기가 없다면, 그들은 결국 서로 만날 것이다.
- 그러면 한 마리의 물고기만 살아남을 수 있다. 큰 물고기가 작은 물고기를 먹는다.
- 좀 더 정확하게 말하면 P<Q 일 때 두 몰고기 P와 Q가 서로 만나고 B[P]=1 이고 B[Q]=0, 그들 사이에 살아있는 물고기는 없다.
- 그들이 만난 후:
- A[P] > A[Q] 이면 p는 Q를 먹고 P는 여전히 하류로 흐르고 
- A[Q] > A[P] 이면 Q가 P를 먹고 Q는 여전히 상류로 흐른다. 
- 우리는 모든 물고기가 같은 속도로 흐르고 있다고 가정한다.
- 즉, 같은 방향으로 움직이는 물고기는 만나지 않는다. 
- 목표는 살아남을 물고기의 수를 계산하는 것이다.
- 예를 들어, 다음과 같은 배열 A와 B를 고려하라.
  A[0] = 4    B[0] = 0
  A[1] = 3    B[1] = 1
  A[2] = 2    B[2] = 0
  A[3] = 1    B[3] = 0
  A[4] = 5    B[4] = 0
- 처음에는 모든 물고기가 살아 있고 1번 물고기를 제외한 모든 물고기가 상류로 이동하고 있다.
- 1번 물고기가 2번 물고기를 만나 먹은 다음 3번 물고기를 만나서 먹는다.
- 마지막으로 물고기 번호 4를 만나서 먹는다.
- 나머지 두 물고기인 숫자 0과 4는 결코 만나지 않아 살아남는다.
- N개의 정수로 구성된 두 개의 비어있지 않은 배열A와 B가 주어지면 살아남을 물고기의 수를 반환한다.
- 예를 들어, 위에 표시된 배열이 주어지면 함수는 위에서 설명한대로 2를 반환해야한다.
- 다음 가정에 대한 효율적인 알고리즘을 작성하시오.
- N은 [1, ... 100,000] 범위 내의 정수이다.
- 배열 A의 각 요소는 [0, ... 1,000,000,000] 범위 내의 정수이다.
- 배열 B의 각 요소는 다음 값 중 하나를 가질 수 있는 정수이다. 0, 1;
- A의 요소는 모두 구별된다.


2. 솔루션


3. 시간복잡도


4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/

class Fish_Solution_01 {
	public int solution(int[] A, int[] B) {

		// 살아 있는 물고기 수
		int aliveCount = 0;

		// up fish
		// 하류로 내려가는 물고기들 저장
		Stack<Integer> downFishes = new Stack<>();

		for (int i = 0; i < A.length; i++) {

			// up fish
			if (B[i] == 0) {
				aliveCount++;

				// stack이 비어 있을 때
				if (downFishes.isEmpty()) {
					// for문 끝으로 가서 i++ 증감
					continue;
				}

				// stack에서 맨 위에 있는 값을 downFish에 저장
				int downFish = downFishes.peek();

				// 무한 반복
				while (true) {
					// 살아있는 물고기 수 감소
					aliveCount--;

					// 하류로 내려가는 물고기 크기가 작음 -> 잡아 먹힘
					if (A[downFish] < A[i]) {
						// 하류로 내려가는 물고기 수 감소
						downFishes.pop();

						// stack이 비어있으면 무한 반복문 빠져나가기
						if (downFishes.isEmpty()) {
							break;
						}
						// stack에서 맨 위에 있는 값을 downFish에 저장
						downFish = downFishes.peek();

						// 하류로 내려가는 물고기 크기가 크다 -> 상류로 가는 물고기가 잡아 먹힘
					} else {
						break;
					}
				}

				// down fish
			} else {
				// stack에 하류로 가는 물고기의 인덱스 넣기
				downFishes.add(i);
				// 살아 있는 물고기 수 증가
				aliveCount++;
			}
		}

		return aliveCount;

	}
}

public class Fish_Sol_01 {

	public static void main(String[] args) {

		int[] A = { 4, 3, 2, 1, 5 };
		// int[] B = { 0, 1, 0, 0, 0 };
		int[] B = { 0, 1, 1, 1, 0 };

		Fish_Solution_01 sol = new Fish_Solution_01();
		System.out.println(sol.solution(A, B));

	}

}
