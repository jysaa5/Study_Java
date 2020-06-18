package exhaustive.search;

import java.util.HashSet;

// 문제: 소수 찾기
/*
문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

입출력 예
numbers | return
17      | 3
011	    | 2

입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
11과 011은 같은 숫자로 취급합니다.
*/

// 솔루션: 재귀를 이용함.

class Find_Prime_Number_Solution_02 {

	public int solution(String numbers) {
		
		// 해시집합 선언 -> 중복된 것을 만들지 않기 위해서.
		HashSet<Integer> set = new HashSet<Integer>();
		
		permutation("", numbers, set);
		
		int count = 0;
		
		// 해시집합에서 숫자들을 삭제하면서 소수이면 count를 증가 시킨다.
		while (set.iterator().hasNext()) {
		
			int a = set.iterator().next();
			
			set.remove(a);
			
			if (a == 2) {
				count++;
			}
			
			// 2의 배수가 아니면서 홀수로도 나누었을 때 아니어야 소수가 된다.
			if (a % 2 != 0 && isPrime(a)) {
				count++;
			}
		}
		return count;
	}

	
	// 소수인지 아닌지 판별 
	public boolean isPrime(int n) {
	
		if (n == 0 || n == 1) {
			return false;
		}
		
		// 수의 제곱근까지 홀수를 찾아서 해당 수를 나누는 것을 반복한다.
		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			
			if (n % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

	// prefix: 접두사 -> "" 공백 없는 문자 한 개씩을 만들어냄
	// str: 주어진 숫자를 string으로 받는다. 
	// permutation: 순열 
	public void permutation(String prefix, String str, HashSet<Integer> set) {
		
		int n = str.length();
		// if (n == 0) System.out.println(prefix);
		
		// 공백이 아니면 해시집합에 저장
		if (!prefix.equals("")) {
			
			// 문자의 접두를 정수로 받아서 저장
			set.add(Integer.valueOf(prefix));
		
		}

		// 재귀함수 호출
		for (int i = 0; i < n; i++) {
			// 문자열에서 한 개씩 떼어내기 위해서 재귀를 부른다.
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
		}
	}

}


public class Find_Prime_Number_Sol_02 {

	public static void main(String[] args) {

		Find_Prime_Number_Solution_02 sol = new Find_Prime_Number_Solution_02();

		String numbers = "17";
		
		System.out.println(sol.solution(numbers));
	}

}