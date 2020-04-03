package sort.radixSort;

import java.util.Arrays;

//RadixSort: 기수 정렬 클래스
//MSB -> LSB
public class RadixSort {

	//getMax: 최대값을 찾는 메서드
	//arr: 배열의 변수
	//n: 배열의 개수
	private static int getMax (int[] arr, int n) {
		
		//max: 최대값을 담는 변수
		int max = arr[0];
		
		for(int i=1; i<n; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	//countSort: 배열을 계수정렬하는 메서드
	//arr: 배열 변수
	//n: 배열의 개수
	//exp: 10, 100, 1000... 
	private static void countSort(int[] arr, int n, int exp) {
		
		int[] output = new int[n];
		int i;
		int[] count = new int[10];
		
		//0으로 초기화
		Arrays.fill(count, 0);
		
		//정렬할 배열의 자리수별의 값의 개수를 count 배열에 저장 
		for(i = 0; i<n; i++) {
			count[(arr[i]/exp)%10] ++;
		}
		
		//count 배열 값 누적
		for(i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		
		//원래 배열 뒤에서부터 count 배열의 값을 확인하고 해당 인덱스 배열에 값을 저장
		//저장되면 count 값을 1씩 줄이기
		for(i=n-1; i>=0; i--) {
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10] --;
		}
		
		//원래 배열에 저장된 배열 저장하기
		for(i = 0; i < n; i++) {
			arr[i] = output[i];
		}
		
	}
	
	
	//radixSort: 기수 정렬
	private static void radixSort(int[] arr, int n) {
		
		//정렬할 배열 값 중에서 가장 큰 값
		int max = getMax(arr, n);
		
		//정렬할 배열 값들을 최대값을 통해서 몇 자리 수까지 존재하는 지 확인하여서 계수 정렬을 반복한다.
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
		
	}
	
	//printArray: 배열 출력
	private static void printArray(int[] arr) {
		for(int data: arr) {
			System.out.print(data+",");
		}
		
		System.out.println();
	}
	
	//main 메서드
	public static void main(String[] args) {
		
		//int[] arr = {326, 453, 608, 835, 751, 435, 704, 690};
		int[] arr = {170, 45, 75, 90, 802, 24, 2, 66}; 
		
		int n = arr.length;
		
		System.out.println("===========정렬 전============");
		printArray(arr);
		System.out.println("===========정렬 후============");
		radixSort(arr, n);
		printArray(arr);
		
	}//main 종료
	
}//RadixSort 종료
