package sort.quickSort;

//Quick Sort: 퀵 정렬 클래스 
public class Quick_Sort {
	
	//quickSort: 퀵 정렬 메서드
	private static void quickSort(int[] arr) {
		//재귀 함수 호출
		//arr: 배열
		//0: 배열의 시작 인덱스
		//arr.length-1: 배열의 마지막 인덱스
		quickSort(arr, 0, arr.length-1);
		
	}//quickSort 종료
	
	
	//quickSort: 재귀함수
	//start, end: 파티션을 나눌 범위
	private static void quickSort(int[] arr, int start, int end) {
		
		// part2: 파티션을 나누고 오른쪽 파티션 첫 번째 배열의 인덱스 값
		int part2 = partition(arr, start, end);
		
		//왼쪽 파티션에서 정렬
		//왼쪽 파티션에 배열 개수가 1개 초과 일때만 정렬
		if(start < part2 -1 ) {
		
			quickSort(arr, start, part2 -1 );
		
		}
		
		//오른쪽 파티션에서 정렬
		//오른쪽 파티션에 배열 개수가 1개 초고가 일 때만 정렬
		if(part2 < end) {
		
			quickSort(arr, part2, end);
		
		}
		
	}//quickSort 종료
	
	
	//배열방 파티션을 나누는 메서드
	private static int partition(int[] arr, int start, int end) {
		
		//pivot: 중간 지점으로 정할 것이다.
		int pivot = arr[(start+end)/2];
		
		// start포인터와 end포인터가 마주쳐서 지나칠때까지 반복
		while(start <= end) {
			while(arr[start] < pivot) {
				start ++;
			}
			
			while(arr[end] > pivot) {
				end --;
			}
			
			if(start <= end) {
				swap(arr, start, end);
				start ++;
				end--;
			}
			
		}
		
		// 파티션을 다 나뉘면 오른쪽 파티션을 나눌 start 포인터 값을 반환한다.
		return start;
		
	}//partition 종료
	
	
	//swap: 교환 메서드
	private static void swap(int[] arr, int start, int end) {
	
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	
	}//swap 종료
	
	
	//printArray: 배열 출력 메서드
	private static void printArray(int[] arr) {
		
		for(int data: arr) {
			
			System.out.print(data+",");
			
		}
		
		System.out.println();
		
	}//printArray 종료
	
	
	//main: 메인 실행 메서드
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		System.out.println("===========정렬 전============");
		printArray(arr);
		System.out.println("===========정렬 후============");
		quickSort(arr);
		printArray(arr);
	}//main 종료

}//Quick_Sort 종료