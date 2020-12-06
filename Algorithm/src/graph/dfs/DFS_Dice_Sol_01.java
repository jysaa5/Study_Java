package graph.dfs;
/*
1. 문제: 10이하의 자연수n을 입력받아 주사위를 n번 던져서 나올수 있는 모든 경우을 출력하는 프로그램을 작성하시오.
2. 솔루션: DFS
*/
import java.util.Scanner;
public class DFS_Dice_Sol_01 {

	static int n = 0;
	
	// 10 이하의 숫자를 저장하는 배열 
	static int[] arr = new int[11];
	
	// depth: 트리의 깊이 -> 함수를 호출하는 것
	static void dfs(int depth) {
		int i=0;
		
		if(depth > n) {
			for(i=1; i<=n; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println("");
			return;
		}
		
		// 1개의 층에서 나누어지는 경우의 수를 for문으로 작성
		for(i=1; i<=6; i++) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(1);
	}
	
}
