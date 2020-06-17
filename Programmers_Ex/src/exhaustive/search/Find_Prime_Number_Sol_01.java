package exhaustive.search;

import java.util.Arrays;
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


/*
솔루션 두 가지 방법
첫 번째: 숫자 조각으로 만들 수 있는 모든 숫자를 만들고 그 숫자들 중 소수의 개수를 세는 방법
두 번째: 숫자 조각으로 구할 수 있는 최대 수까지 소수를 모두 구한 뒤 모든 소수를 검사하며 해당 소수가 숫자 조각들로 이루어질 수
있는 지 확인하는 방법

-> 두 번째 방법
1) 숫자 조각들로 구할 수 있는 가장 큰 값을 구한다.
2) 가장 큰 값까지 소수를 구한다.
3) 구해진 소수들 중 숫자 조각들로 만들어질 수 있는지 확인한다.

-> 0~9의 개수를 세어 준다. 
소수에서 사용된 숫자 만큼 숫자의 개수를 줄여준다.
소수에서 사용된 수가 사용할 수 있는 수보다 많다면 숫자 조각들로 만들 수 없는 소수이다.


ex) 주어진 수: 1, 2, 3
       숫자    : 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
사용가능 개수: 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 
*/

// 
class Find_Prime_Number_Solution_01 {
	
	
	public int solution(String numbers) {
	    int maxNum = makeMaxNum(numbers.toCharArray());
	    boolean[] primeNum = findPrimeNum(maxNum);

	    return findMakePossiblePrimeNum(primeNum, maxNum);
	}
	
	// 주어진 숫자중에서 만들 수 있는 최대 수
	// 주어진 숫자 조각들에서 구하 수 있는 가장 큰 값을 int형으로 반환한다.
	private int makeMaxNum(char[] inputNum) {
		
		// 오름차순 정렬
	    Arrays.sort(inputNum);
	    int len = inputNum.length;
		// 내림차순으로 다시 재정렬
	    for (int i = 0; i < len/2; i++) {
	        char temp = inputNum[i];
	        inputNum[i] = inputNum[len - 1 - i];
	        inputNum[len - 1 - i] = temp;
	    }
	 // 문자배열을 문자열로 만들고 정수로 변환 후, 반환
	    return Integer.parseInt(new String(inputNum));
	}
	
	
	// 최대 수 안에서 소수를 찾는 메서드 
	// 주어진 가장 큰 값까지의 소수를 에라토스테네스의 체를 이용하여 구한다.
	private boolean[] findPrimeNum(int maxNum) {
	    boolean[] result = new boolean[maxNum + 1];
	    for (int i = 2; i < Math.sqrt(maxNum); i++) {
	        if (!result[i]) {
	            for (int j = i * 2; j <= maxNum; j += i) {
	                result[j] = true;
	            }
	        }
	    }
	    return result;
	}
	
	

	// 주어진 숫자조각으로 만들 수 있는 소수들의 개수를 구하여 반환하는 함수이다.
	private int findMakePossiblePrimeNum(boolean[] primeNum, int maxNum) {
	    int possiblePrimeNumCount = 0;

	    for (int primeNumIndex = 2; primeNumIndex <= maxNum; primeNumIndex++) {
	        if (!primeNum[primeNumIndex] && isPossible(maxNum, primeNumIndex)) {
	            possiblePrimeNumCount++;
	        }
	    }
	    return possiblePrimeNumCount;
	}

	
	// 해당 소수가 주어진 숫자 조각으로 만들어질 수 있는지 여부를 판단하는 함수이다. 
	private boolean isPossible(int maxNum, int primeNum) {
	    int[] numCount = countAvailableNums(maxNum);

	    while(primeNum != 0) {
	        if (numCount[primeNum % 10] <= 0) return false;
	        numCount[primeNum % 10]--;
	        primeNum /= 10;
	    }

	    return true;
	}
	
	// 주어진 숫자조각에서 사용할 수 있는 0~9의 개수를 세는 함수이다.
	private int[] countAvailableNums(int maxNum) {
	    char[] str = String.valueOf(maxNum).toCharArray();
	    int[] numCount = new int[10];
	    for (int i = 0; i < str.length; i++) {
	        numCount[str[i] - '0']++;
	    }
	    return numCount;
	}
}

public class Find_Prime_Number_Sol_01 {
	
	public static void main(String[] args) {
		
		Find_Prime_Number_Solution_01 sol = new Find_Prime_Number_Solution_01();
		
		String numbers = "17";
		System.out.println(sol.solution(numbers));
	}

}
