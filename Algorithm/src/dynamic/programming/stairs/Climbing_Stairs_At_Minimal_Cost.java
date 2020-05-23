package dynamic.programming.stairs;

// Dynamic Programming
// 문제: 최소비용으로 계단 오르기 (Min Cost Climbing Stairs)
// 계단에선 i번째 계단을 올라가려면, 양수값을 가지는 cost i가 할당되어 있다. 배열 안에 값이 있다. 
// 인덱스(i)를 계단이라고 생각하고 계단마다 올라갈 때, 지불해야 하는 돈값이 매겨져 있다. 
// 당신이 돈을 지불하면 당신을 1칸이나 2칸을 갈 수 있다. 계단 끝까지 가는데 가장 싸게 가는 방법을 찾아야 한다. 
// 그리고 당신은 처음 시작할 때, 계단의 0번이나 1번 중 선택해서 시작할 수 있는 옵션이 있다. 

// example 1: 
/* Input: cost = [10, 15, 20] -> 10, 15, 20인 3개의 계단이 있다.
 * Output: 15 -> 계단 0번 또는 계단 1번중에서 선택할 수 있으므로, 15달러 지불하고 2칸 올라가면 끝까지 올라갈 수 있다.
 */

// example 2:
/* Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 */

// Climbing_Stairs_At_Minimal_Cost 클래스
public class Climbing_Stairs_At_Minimal_Cost {

	
	// minCostClimbingStairs 메서드
	public static int minCostClimbingStairs(int[] cost) {
		int case1 = 0, case2 = 0, current;
		
		for(int i = cost.length-1; i>=0; --i) {
			current = cost[i]+Math.min(case1, case2);
			case2 = case1;
			case1 = current;
		}
		
		return Math.min(case1, case2);
	}// minCostClimbingStairs 메서드 종료
	
	
	//main 메서드
	public static void main(String[] args) {
		//int[] cost = new int[]{1,2,3,4,5,6,7};
		//int[] cost = new int[]{10, 15, 20};
		int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int result = minCostClimbingStairs(cost);
		System.out.println(result);
	}// main 메서드 종료
}// Climbing_Stairs_At_Minimal_Cost 클래스 종료
