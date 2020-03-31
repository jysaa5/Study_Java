package sort.mergeSort;

//재귀를 이용한 병합(합병) 정렬
public class Merge_Sort {
	
	//merge sort 함수 정의
	//arr: 정렬할 배열
	//병합정렬할때, 기존 배열에 다시 복사에서 덮어쓰기 한다. -> 원래 알고리즘에서는 새로운 배열에 넣는 거지만 여기서는 덮어쓰기한다.
	private static void mergeSort(int[] arr) {

		//임시 저장 배열을 만든다.
		//tmp: 임시 저장소
		int[] tmp = new int[arr.length];
		
		//arr: 정렬할 배열, tmp: 임시 저장 배열
		//0: 시작 인덱스
		//arr.length-1: 끝 인덱스
		//재귀함수 호출
		mergeSort(arr, tmp, 0, arr.length-1); 
		
	}
	
	//mergeSort: 배열을 쪼개는 메서드
	//재귀함수
	//arr: 정렬할 배열, tmp: 임시 공간, start: 시작 인덱스, end: 끝 인덱스
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		
		//시작 인덱스가 끝 인덱스보다 작을 때만 재귀호출
		if(start<end) {
			//함수가 호출되면 배열을 2개로 중앙에서 자르기 위해서 가운데 인덱스가 필요하다.
			int mid = (start+end)/2;
			//배열을 앞부분: 자르는 인덱스를 기준으로.
			mergeSort(arr, tmp, start, mid);
			//배열의 뒷부분: 자르는 인덱스를 기준으로.
			mergeSort(arr, tmp, mid+1, end);
			//배열방을 병합해준다.
			merge(arr, tmp, start, mid, end);
			
		}
		
	}
	
	//두개의 배열방을 병합하는 메서드
	//arr: 배열과 정렬된 결과를 반복적으로 저장하는 배열의 포인터
	//tmp: 임시 공간, mid:중간 인덱스 start: 시작 인덱스, end: 끝 인덱스 
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end ) {
		
		//임시 저장배열에 필요한 만큰 정렬된 배열을 복사한다.
		for(int i=start; i <= end; i++) {
			tmp[i] = arr[i];
			
		}
		
		//첫번째 배열방의 첫번째 배열의 인덱스 
		int part1 = start;
		//두번째 배열방의 첫번째 배열의 인덱스
		int part2 = mid+1;
		//결과 배열방에 어디에 저장해야 될지 기억해야 하므로 사용하는 변수
		int index = start;
		
		//첫번째 배열방이 끝까지 다 결과 배열방에 가거나 두번째 배열방이 끝까지 다 결과 배열방에 갈때까지 반복
		while(part1<=mid && part2 <=end) {
			
			//첫번째 배열방 비교
			if(tmp[part1] <= tmp[part2]) {
				arr[index] = tmp[part1];
				//앞쪽 포인터를 옮긴다.
				part1++;
			}else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
			
		}
		
		//첫번째 앞쪽 배열이 남아있을 경우
		for(int i = 0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
		
		//두번째 뒤쪽 배열이 남아있을 경우는 그냥 냅둬도 된다. 왜냐하면 그대로 뒤에 붙어있기 때문이다.
		
	}
	
	//printArray 메서드: 배열 출력 
	public static void printArray(int[] arr) {
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
		
	}//printArray 종료
	
	
	//main 메서드
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		System.out.println("===========정렬 전============");
		printArray(arr);
		
		System.out.println("===========정렬 후============");
		mergeSort(arr);
		printArray(arr);
	}// main 종료

}//Merge_Sort 종료
