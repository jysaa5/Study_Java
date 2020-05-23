package sort.countingSort;

//Counting_Sort 클래스
public class Counting_Sort {

	private static void countingSort(int[] arr) {
		
		int max = arr[0];
		
		//입력된 배열중 가장 큰 값 찾기
		for(int i=0; i<arr.length; i++) {
			
			if(max < arr[i]) {
				max =  arr[i];
			}
			
		}
		max ++;
		
		//counting 배열 선언 및 생성
		int[] c = new int[max];
		
		//정렬된 배열 선언 및 생성
		int[] b = new int[arr.length];
		
		//counting 배열 초기화
		for(int i=0; i<max; i++) {
			c[i] = 0;
		}
		
		//입력된 배열의 값 카운팅 값 넣기
		for(int i=0; i<arr.length; i++) {
			c[arr[i]] = c[arr[i]] + 1;
		}
		
		
		// c배열의 값 누적하기
		for(int i=1; i<max; i++) {
			c[i] = c[i] + c[i-1];
		}
		
		//계수 정렬
		for(int i=(arr.length-1); i>=0; i--) {
			b[c[arr[i]]-1] = arr[i];
			c[arr[i]] = c[arr[i]] - 1;

		}
		
		//원래 배열에 정렬된 배열을 덮어쓰기
		for(int i=0; i<arr.length; i++) {
			arr[i] = b[i];
		}
		
	}
	
	//printArray: 배열을 출력하는 메서드
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data+",");
		}
		System.out.println();
	}
	
	
	
	//main 메서드
	public static void main(String[] args) {
		int[] arr = {2,5,3,0,2,3,0,3};
		System.out.println("===========정렬 전============");
		printArray(arr);
		System.out.println("===========정렬 후============");
		countingSort(arr);
		printArray(arr);
		
		
	}//main 종료
	
}//Counting_Sort 종료
