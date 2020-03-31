package sort.insertionSort;

//재귀를 이용한 삽입 정렬
public class Insertion_Sort {

	
	//insertionSort 메서드: 삽입 정렬 메서드
	private static void insertionSort(int[] arr) {
		
		insertionSort(arr, 1);
		
	}//insertionSort 종료
	
	
	//insertionSort 메서드: insertion sort의 재귀 메서드
	private static void insertionSort(int[] arr, int start) {
		
		if(start < arr.length) {
			
			//기준 인덱스의 배열의 값 = key 값
			int standard = arr[start];
			
			//정렬되어 있다고 가정한 인덱스의 값
			int compareIndex = start-1;
			
			
			while(compareIndex >= 0 && arr[compareIndex] > standard) {
				arr[compareIndex+1] = arr[compareIndex];
				compareIndex --;
			}
			
			arr[compareIndex+1] = standard;
			insertionSort(arr,start+1);

		}
		
	}//insertionSort 종료
	
	
	//printArray: 배열 출력 메서드
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
		insertionSort(arr);
		printArray(arr);
		
	}//main 종료

	
}//Insertion_Sort 종료
