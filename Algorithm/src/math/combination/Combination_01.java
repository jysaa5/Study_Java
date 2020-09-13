package math.combination;

// 조합
// 솔루션1: 백트래킹
// 솔루션2: 재귀함수
public class Combination_01 {

	// 솔루션1.
	// 백트래킹 사용
	// 사용예시: combination(arr, visited, 0, n, r)
	// arr: 조합을 뽑아낼 배열
	// visited: 뽑혔는지 아닌지 체크
	// start: 인덱스 기준
	// n: 배열의 길이, r: 조합의 길이
	public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		
		if(r==0) {
			printArray(arr, visited, n);
			return;
		}
		
		
		for(int i = start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
		
	}
	
	// 솔루션2.
	// 재귀함수 사용
	// 사용예시: combinationR(arr, visited, 0, n, r)
	// arr: 조합을 뽑아낼 배열
	// visited: 뽑혔는지 아닌지 체크
	// depth: 
	// n: 배열의 길이, r: 조합의 길이
	public void combinationR(int[] arr, boolean[] visited, int depth, int n, int r) {
		
		if(r==0) {
			printArray(arr, visited, n);
			return;
		}
		
		if(depth == n) {
			return;
		}else {
			visited[depth] = true;
			combinationR(arr, visited, depth+1, n, r-1);
			visited[depth] = false;
			combinationR(arr, visited, depth+1, n, r);
		}
		
	}
	
	
	// 배열 출력
	public void printArray(int[] arr, boolean[] visited, int n) {
		
		for(int i=0; i<n; i++) {
			if(visited[i] == true) {
				System.out.print(arr[i]+ " ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int n = 4;
		int[] arr = {1, 2, 3, 4};
		boolean[] visited = new boolean[n];
		
		Combination_01 sol = new Combination_01();
	
		int r = 2;
		int start = 0;
		
		System.out.println("백트래킹을 이용한 구현");
		sol.combination(arr, visited, start, n, r);
		
//		for(int i=1; i<= n; i++) {
//			sol.combination(arr, visited, 0, n, i);
//		}
		
		
		System.out.println();
	
		System.out.println("재귀함수를 위한 구현");
		sol.combinationR(arr, visited, start, n, r);
//		for(int i=1; i<=n; i++) {
//			sol.combinationR(arr, visited, 0, n, i);
//		}
		
		
	}
	
}
