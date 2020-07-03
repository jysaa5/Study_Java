package sort;

import java.util.Arrays;


// 문제: 가장 큰 수
/*
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를
 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장
 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers	          | return
[6, 10, 2]	      | 6210
[3, 30, 34, 5, 9] |	9534330

*/
// 솔루션


class Largest_Number_Solution_01 {

	public String solution(int[] numbers) {
    	
    	String[] arr = new String[numbers.length];
    	
    	for(int i=0; i<numbers.length; i++) {
    		arr[i] = String.valueOf(numbers[i]);
    	}
    		Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
    		
    		if(arr[0].equals("0")) {
    			return "0";
    		}
    		
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i=0; i<arr.length; i++) {
    			sb.append(arr[i]);
    		}
    		
        return sb.toString();
    }
}

public class Largest_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		Largest_Number_Solution_01 sol = new Largest_Number_Solution_01();
		
		//int[] numbers = {6, 10, 2};
		
		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(sol.solution(numbers));
		
	}

}
