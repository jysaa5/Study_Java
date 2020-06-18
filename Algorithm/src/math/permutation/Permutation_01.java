package math.permutation;

// 순열: n개 중에서 r개를 순서 있게 뽑기
// 시간복잡도: O(n!)

public class Permutation_01 {
	
	// 순열 구하기
	// 순서 없이 n개 중에서 r개를 뽑는 경우
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
	
	
	// swap
	public void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}
	
	
	// 배열 출력
	public void printArray(int[] arr, int r) {
		
		for(int i=0; i<r; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		int n = 3;
		int[] arr  = {1,2,3};
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		
		Permutation_01 perm = new Permutation_01();
		System.out.println("사전순으로 순열 구하기");
		perm.permutationDic(arr, output, visited, 0, n, 3);
		System.out.println();
		System.out.println("순열 구하기");
		perm.permutation(arr, 0, n, 3);
	}

}