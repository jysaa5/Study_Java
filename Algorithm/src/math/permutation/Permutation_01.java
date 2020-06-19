package math.permutation;

// 순열: n개 중에서 r개를 순서 있게 뽑기
// 시간복잡도: O(n!)

public class Permutation_01 {
	
	// 순열 구하기 (swap 이용)
	// 순서 없이 n개 중에서 r개를 뽑는 경우
	// arr: n개 배열
	// depth: 0부터 시작. 숫자보다 낮은 인덱스의 값은 고정하고 그 위에 값들의 순서를 섞기 위해 기준이 되는 값 
	// n: 전체 개수, r: 뽑아야할 개수
	// 예시: arr = [1,2,3], depth = 0부터 3까지, n = 3, r = 3
	public void permutation(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			printArray(arr, r);
			return;
			
		}
		
		for(int i= depth; i<n; i++) {
			swap(arr, depth, i);
			permutation(arr,  depth+1, n, r);
			swap(arr, depth, i);
		
		}
	}
	
	// 순열 구하기 (visited 이용)
	// 사전식으로 순열을 구할 수 있다.
	// arr: r개를 뽑기 위한 n개의 값
	// output: 뽑힌 r개의 값을 저장
	// visited: 중복해서 뽑지 않기 위해 체크하는 값
	// depth: output에 들어간 숫자의 길이
	// n: 전체 개수, r: 뽑아야할 개수
	// 예시: arr = [1,2,3], output = 전체 개수와 같은 int 배열, visited = 전체 개수와 같은 int 배열,  depth = 0부터 3까지, n = 3, r = 3
	public void permutationDic(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		 
		if(depth == r) {
		
			printArray(output, r);
			
			return;
		 }
		 
		 
		 for(int i=0; i<n; i++) {
			
			 if(visited[i] != true) {
				 
				 visited[i] = true;
				 output[depth] = arr[i];
				 permutationDic(arr, output, visited, depth+1, n ,r);
				 visited[i] = false;
				 
			 }
			 
		 }
		 
		
	}
	
	
	// swap 메서드 
	public void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		
		arr[depth] = arr[i];
		
		arr[i] = temp;
	}
	
	
	// 배열 출력
	public void printArray(int[] arr, int r) {
		System.out.print("[");
		for(int i=0; i<r; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("]");
		System.out.println();
		
	}
	
	
	
	// 메인 함수
	public static void main(String[] args) {
		int n = 3;
		int[] arr  = {1,2,3};
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		Permutation_01 perm = new Permutation_01();
		System.out.println("순열 구하기");
		perm.permutation(arr, 0, n, 3);
		System.out.println();
		
		System.out.println("사전순으로 순열 구하기");
		perm.permutationDic(arr, output, visited, 0, n, 3);


	}

}