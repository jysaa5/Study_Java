package sort.insertionSort;

public class Insertion_Sort_while {
	
	//insertionSort 메서드: 삽입 정렬
	private static void insertionSort(int[] arr) {
		
		//key값
		int key;
		int i, j;
		
		for(j=1; j<arr.length; j++) {
			
			//key 값
			key = arr[j];
			i = j-1;
			
			//인덱스가 0보다 크고 key 값보다 앞에 정렬된 값이 클때
			while(i>=0 && arr[i] > key) {
				//배열을 한 칸씩 뒤로 밀어낸다.
				arr[i+1] = arr[i];
				i = i-1;
			}
			
			arr[i+1] = key;
		}
	}


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
	
}//Insertion_Sort_while 종료
