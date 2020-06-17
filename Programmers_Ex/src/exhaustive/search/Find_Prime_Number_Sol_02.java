package exhaustive.search;

import java.util.HashSet;

//문제: 소수 찾기
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

class Find_Prime_Number_Solution_02 {

	public int solution(String numbers) {
		
		HashSet<Integer> set = new HashSet<>();
		permutation("", numbers, set);
		
		int count = 0;
		
		while (set.iterator().hasNext()) {
			int a = set.iterator().next();
			set.remove(a);
			if (a == 2)
				count++;
			if (a % 2 != 0 && isPrime(a)) {
				count++;
			}
		}
		return count;
	}

	
	public boolean isPrime(int n) {
	
		if (n == 0 || n == 1) {
			return false;
		}
		
		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void permutation(String prefix, String str, HashSet<Integer> set) {
		
		int n = str.length();
		// if (n == 0) System.out.println(prefix);
		
		if (!prefix.equals("")) {
			set.add(Integer.valueOf(prefix));
		}

		for (int i = 0; i < n; i++) {
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
