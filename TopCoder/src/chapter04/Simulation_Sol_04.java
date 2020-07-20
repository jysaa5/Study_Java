package chapter04;
//p.65
//문제: 키위 주스
//솔루션: for문, Math.min 사용
public class Simulation_Sol_04 {
	
public static int[] solution(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		
		for(int i=0; i<fromId.length; i++) {
			
			int sum = bottles[fromId[i]] + bottles[toId[i]];
			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
			
		}
		
		return bottles;
	}
	
	// Test
	public static void main(String[] args) {
		
		//예시 0
//		int[] capacities = {20, 20};
//		int[] bottles = {5, 8};
//		int[] fromId = {0};
//		int[] toId = {1};
		
		// 예시1
//		int[] capacities = {10, 10};
//		int[] bottles = {5, 8};
//		int[] fromId = {0};
//		int[] toId = {1};
		
		// 예시2
//		int[] capacities = {30, 20, 10};
//		int[] bottles = {10, 5, 5};
//		int[] fromId = {0,1,2};
//		int[] toId = {1,2,0};
		
		// 예시3
//		int[] capacities = {14, 35, 86, 58, 25, 62};
//		int[] bottles = {6, 34, 27, 38, 9, 60};
//		int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
//		int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};
		
		// 예시4
		int[] capacities = {700000, 800000, 900000, 1000000};
		int[] bottles = {478478, 478478, 478478, 478478};
		int[] fromId = {2, 3, 2, 0, 1};
		int[] toId = {0, 1, 1, 3, 2};
		
		int[] result = solution(capacities, bottles, fromId, toId);
		
		for(int n: result) {
		System.out.println(n);
		}
	}

}
