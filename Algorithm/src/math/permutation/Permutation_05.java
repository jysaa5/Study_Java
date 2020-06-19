package math.permutation;

import java.util.Arrays;
//순열
//솔루션: 재귀함수 + 위치변경(swap)을 이용함.
//중복을 허용함.
public class Permutation_05 {

	// nPr의 n
	private int n;
	
	// nPr의 r
	private int r;
	private int[] res;
	
	// 초기화 
	public Permutation_05(int n, int r) {
		this.n = n;
		this.r = r;
		res = new int[r];
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void perm(int[] arr, int depth) {
		
		if(depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			// 스왑
			swap(arr, depth, i);
			// 선택된 원소 저장
			res[depth] = arr[depth];
			// 재귀 호출
			perm(arr, depth+1);
			// 복원
			swap(arr, depth, i);
		}
		
		
	}
	
	public static void main(String[] args) {
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		Permutation_05 main = new Permutation_05(arr.length, r);
		main.perm(arr, 0);
	}
	
}
