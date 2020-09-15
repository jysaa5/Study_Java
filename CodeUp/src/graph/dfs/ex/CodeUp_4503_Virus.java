package graph.dfs.ex;

//4503 : 바이러스

import java.util.Scanner;
public class CodeUp_4503_Virus {
	
	static int[][] arr = new int[200][200];
	static int cnt;
	static int[] visit = new int[200];
	
	static int n;
	
	static void dfs(int depth) {
		// visit: 되돌아 가지 않도록 방문한 것을 저장한다.
		visit[depth] = 1;
		cnt++;
		
		// n = 7 (노드 개수)
		for(int i=1; i<=n; i++) {
			if(arr[depth][i]==1 && visit[i]==0) {
				dfs(i);
			}
		}	
	} 
	
	
	public static void main(String[] args) {
		int i = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("노드의 개수를 입력 하세요:");
		String str1 = sc.nextLine();
		System.out.println("엣지의 개수를 입력 하세요: ");
		String str2 = sc.nextLine();
		
		// n: 1~7 (노드)
		n = Integer.parseInt(str1);
		
		// m: 연결된 엣지 수
		int m = Integer.parseInt(str2);
		
		for(i=1; i<=m; i++) {
			System.out.println("연결된 노드의 숫자를 입력하세요(a): ");
			String str3 = sc.nextLine();
			System.out.println("연결된 노드의 숫자를 입력하세요(b): ");
			String str4 = sc.nextLine();
			int a = Integer.parseInt(str3);
			int b = Integer.parseInt(str4);
			
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		dfs(1);
		// 1에 연결된 것을 구하는 것이므로 자기 자신인 1은 제외한다.
		System.out.println("연결된 노드의 수:");
		System.out.println(cnt-1);
		
	}

}
