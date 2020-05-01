package sort.bubbleSort;

//Bubble_Sort_For 클래스: for문을 이용한 버블정렬 구현
public class Bubble_Sort_For {

	//bubbleSort: for문 이용한 메서드 
	private static void bubbleSort(int[] arr) {
		
		int tmp = 0;
		
		//배열 끝에서부터 정렬시킨다.
		for(int i=arr.length-1; i>=0; i--) {
			
			for(int j=0; j<i; j++) {
				
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}	
			}
		}
	}//bubbleSort 종료
	
	//printArray: 배열 출력 메서드
	private static void printArray(int[] arr) {
		
		for (int data : arr) {
			
			System.out.print(data + ",");
			
		}
			
			System.out.println();
			
		}//printArray 종료
	
	//main 실행 메서드
	public static void main(String[] args) {
		
		int[] arr = {3,5,4,2,1};
		
		System.out.println("===========정렬 전============");
		printArray(arr);
		
		System.out.println("===========정렬 후============");
		bubbleSort(arr);
		printArray(arr);
		
	}//main 종료
	
}//Bubble_Sort_For 종료
