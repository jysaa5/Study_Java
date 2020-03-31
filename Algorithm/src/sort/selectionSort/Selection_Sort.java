package sort.selectionSort;

//재귀를 이용한 선택정렬
public class Selection_Sort {

	//selectionSort: 정렬할 배열을 인자로 받는 메서드
	private static void selectionSort(int[] arr) {
		//재귀함수 호출: 정렬이 안된 인덱스도 인자로 넘긴다.
		//처음에는 다 정렬이 안된 상태이므로 인덱스 0으로.
		selectionSort(arr, 0);
	
	}//selectionSort 종료

	
	//selectionSort: 정렬할 배열과 시작점을 인자로 받는 메서드
	private static void selectionSort(int[] arr, int start) {

		//시작점이 배열의 마지막 인덱스보다 작을 때
		if (start < arr.length - 1) {
			
			//가장 작은 방의 인덱스를 저장할 변수
			int min_index = start;

			for (int i = start; i < arr.length; i++) {

				if (arr[i] < arr[min_index]) {
					min_index = i;
				}
			}
			
			//시작점과 제일 작은 값이 있는 인덱스를 인자로 넘긴다.
			//시작점 배열방의 값과 가장 작은 값이 있는 배열 방의 값을 맞바꾼다.
			swap(arr, start, min_index);
			
			//또 다시 선택정렬 재귀 호출
			selectionSort(arr, start + 1);

		}
		
	}//selectionSort 종료
	
	

	//배열방의 값을 맞바꾸는 메서드
	private static void swap(int[] arr, int index1, int index2) {
	
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	
	}//swap 종료

	//printArray: 배열을 출력하는 메서드
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
		
		}
		
		System.out.println();
	
	
	}//printArray 종료

	
	//main: 메인 실행 메서드
	public static void main(String[] args) {
		
		int[] arr = { 3, 6, 1, 8, 2, 4 };
		System.out.println("===========정렬 전============");
		printArray(arr);
		
		System.out.println("===========정렬 후============");
		selectionSort(arr);
		printArray(arr);
		
	}//main 종료

}//Selection_Sort 종료