package sort;

public class Bubble_Sort {

	//bubbleSort: 버블정렬 메서드
	private static void bubbleSort(int[] arr) {
		//재귀함수 호출
		//arr: 배열
		//arr.length-1: 배열의 마지막 인덱스
		bubbleSort(arr, arr.length-1);
		
	}//bubbleSort 종료
	
	
	//bubbleSort: 버블 정렬 메서드의 재귀함수
	private static void bubbleSort(int[] arr, int last) {
		
		//마지막 인덱스가 0보다 클 때까지
		if(last > 0) {
			
			//마지막 인덱스까지 배열방을 돈다.
			for(int i=1; i <= last; i++) {
				
				//내 앞쪽에 있는 것이 나보다 클때
				if(arr[i-1] > arr[i]) {
					//자리 바꾸기
					swap(arr, i-1, i);
				}
				
			}
			
			//마지막 인덱스를 제외하고 다시 버블 정렬 재귀 호출
			bubbleSort(arr, last-1);
		}

	}//bubbleSort 종료
	
	
	//swap 메서드: 자리바꾸기(스왓)
	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
		
	}//swap 종료
	
	
	//printArray: 배열 출력 메서드
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
		}
		
		System.out.println();
		
	}//printArray 종료


	
	//main 실행 함수
	public static void main(String[] args) {
		
		int[] arr = {3,5,4,2,1};
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
		
	}//main 종료
	
}//Bubble_Sort 종료
