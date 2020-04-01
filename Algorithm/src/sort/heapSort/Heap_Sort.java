package sort.heapSort;

//힙 정렬: 최대힙, 오름차순 정렬
public class Heap_Sort {

	//heapSort: 힙 정렬
	private static void heapSort(int[] arr) {
		
		//배열의 크기
		int arrSize = arr.length;
	
		//1. Build heap :힙 구조 빌드
		//힙 구조 만들기 = 배열 재배치
		//i: 부모 노드
		//arrSize-1: 배열의 마지막 인덱스
		//(arrSize-1)/2: 부모 노드중에서 가장 작은 노드의 인덱스 값 
		for(int i = (arrSize-1)/2; i>=0; i--) {
			
			heapify(arr, arrSize, i);
			
		}
	
		//2. Extract-Max: 최대값 추출 -> 힙 정렬
		for(int i=arrSize-1; i>=0; i--) {
			
			//가장 큰 값을 가진 루트를 오름차순으로 정렬
			//최대 큰 수는 배열의 맨 뒤에서부터 채워진다.
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			
			//다시 최대힙 구조로 만들기
			heapify(arr, i, 0);
			
		}
	}//heapSort 종료
	
	
	//3. Max heapify: 최대힙을 만들어 주는 과정
	private static void heapify(int[] arr, int arrSize, int i) {
		
		//가장 큰 값(루트)을 갖고 있는 배열의 인덱스
		int largest = i;
		
		//left child의 인덱스
		int l = 2*i + 1;
		
		//right child의 인덱스
		int r = 2*i + 2;
		
		//왼쪽 자식이 루트보다 클 때.
		if(l < arrSize && arr[l]>arr[largest]) {
			largest = l;
		}
		
		//오른쪽 자식이 루트보다 클 때
		if(r< arrSize && arr[r] > arr[largest]) {
			largest = r;
		}
		
		//가장 큰 값이 루트가 아닐 경우
		if(largest != i) {
			
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			// 서브 트리에 대해서 heapify 
			heapify(arr, arrSize, largest);
		}
	}//heapify 종료
	
	
	//printArray 메서드 
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
		
	}//printArray 종료
	
	
	//main 메서드
	public static void main(String[] args) {
		
		int arr[] = {12,11,13,5,6,7};
		//int arr[] = {12,11,13,5,6,6};
		System.out.println("===========정렬 전============");
		printArray(arr);
		
		System.out.println("===========정렬 후============");
		heapSort(arr);
		printArray(arr);
 	
	}//main	종료
	
}//Heap_Sort 종료