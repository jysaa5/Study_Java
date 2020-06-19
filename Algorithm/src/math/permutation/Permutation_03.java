package math.permutation;

import java.util.ArrayList;
import java.util.Arrays;

// 순열
// 중복을 허용한 코드
// 솔루션: 재귀함수 + ArrayList
public class Permutation_03 {

	// nPr의 n
	private int n;
	// nPr의 r
	private int r;
	private ArrayList<Integer> itemList;
	// 결과값 배열
	private int[] res;

	// 생성자
	// 초기화
	public Permutation_03(int[] intArr, int r) {

		// nPr의 r
		this.r = r;
		// nPr의 n
		this.n = intArr.length;
		// 결과값 배열
		this.res = new int[r];

		// 아이템이 들어갈 리스트
		itemList = new ArrayList<Integer>();

		for (int item : intArr) {
			itemList.add(item);
		}
	}
	
	// 재귀호출
	public void perm(int depth) {
		perm(itemList, 0);
	}
	
	
	public void perm(ArrayList<Integer> itemList, int depth) {
		
		// depth가 0부터 시작했을 경우 depth == r에서 리턴
		if(depth == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for(int i=0; i<n-depth; i++) {

			res[depth] = itemList.get(i);
			// 재귀호출
			perm(itemList, depth+1);
		}
		
	}
	
	
	public static void main(String[] args) {
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		Permutation_03 main = new Permutation_03(arr, r);
		main.perm(0);
	}
}