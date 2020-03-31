package sort.selectionSort;

//for문을 이용한 선택정렬
public class Selection_Sort_for {
	
	//selectionSort: 선택정렬
	private static void selectionSort(int[] arr) {
		
		int tmp = 0;
		
		for(int i=0; i <=arr.length-1; i++) {
			
			for(int j=1+i; j<=arr.length-1; j++) {
			
				if(arr[i]>=arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				
			}
			}	
		}	
	}//selectionSort 종료
	
	
	//printArray: 배열을 출력하는 메서드
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			
			System.out.print(data+",");
			
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

}//Selection_Sort_for 종료
