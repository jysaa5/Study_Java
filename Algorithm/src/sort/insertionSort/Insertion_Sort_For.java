package sort.insertionSort;

//Insertion_Sort_For 클래스: for문을 이용한 삽입정렬 
public class Insertion_Sort_For {
	
	//insertionSort 메서드: 삽입 정렬 메서드
	private static void insertionSort(int[] arr) {
		
		int tmp = 0;
		
		for(int i=1; i<=arr.length-1; i++) {
			
			for(int j=i-1; j>=0; j--) {
				
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;	
					
				}
			}
		}
		
	}//insetionSort 종료
	
	
	//printArray 메서드: 배열을 출력하는 메서드
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			System.out.print(data+",");
		}
		System.out.println();
		
	}//printArray 종료
	
	
	//main 메서드 
	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 2, 4 };
		System.out.println("===========정렬 전============");
		printArray(arr);
		
		System.out.println("===========정렬 후============");
		insertionSort(arr);
		printArray(arr);
	
	}//main 종료
	
}//Insertion_Sort_For 종료
