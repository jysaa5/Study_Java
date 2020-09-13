package string.ex.check.palindrome.permutation;

// 문제: 주어진 문자열이 회문(palindrome)을 만들수 있는 문자열의 치환(permutation)인지를 확인하는 함수를 만드시오.

// 회문(palindrome): 앞으로 읽으나 뒤로 읽으나 똑같은 단어나 문자열을 말한다. 
// 회문인지 찾는 방법: 문자열 맨 처음이랑 맨 끝에 포인터를 두고 한 칸씩 뒤와 앞으로 움직이면서 같은 문자인지 확인한다.
// 회문 특징: 문자열을 가운데 딱 나누면 거울처럼 데칼코마니가 된다. 가운데 문자만 홀수가 될 수 있다. 그래서 하나를 제외한 다른 문자들이 회문이 될 수 있다.
// ex) mom, racecar

// 치환(permutation): 문자열 안에 문자의 종류와 개수가 같은 것
// ex) mmo, omm
// Solution 2: 
/*  a b c  ...  y  z
 * |0|1|2| ... |24|25 -> 배열의 인덱스
 * 
 * -> 각 문자의 개수를 세어서 문자별로 배열에 저장한 후에 그 배열을 돌면서 홀수 개인 문자가 1개 초과이면 회문 규칙에 어긋나므로, 회문 규칙에 맞는
 *    것을 찾는다. 
 * -> 코드 길이를 줄이기만 가능 : 개수를 세면서 홀수개 문자가 몇 개인지 센다.
 * 
 * */

// 시간복잡도 = O(n)

// String_Check_Palindrome_And_Permutation_Sol_2 클래스 
public class String_Check_Palindrome_And_Permutation_Sol_2 {
	
	// isPermutationOfPalindrome 메서드: 회문인지 아닌지 찾는 메서드
	private static boolean isPermutationOfPalindrome(String s) {
		
		// 홀수 값의 개수
		int countOdd = 0;
		
		// 배열방을 26개 생성
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		
		// 문자열을 한 개씩 가져온다.
		for(char c : s.toCharArray()) {
			
			// 배열방 번호 가져오기
			int x = getCharNumber(c);
			
			if(x != -1) {
				
				table[x]++;
				
				if(table[x]%2 == 1) {
					
					countOdd++;
				
				}else {
					countOdd--;
				}
				
			}
			
		}
		
		return countOdd <= 1;
		
	}// isPermutationOfPalindrome 메서드 종료
	
	
	// getCharNumber 메서드: 문자를 가지고 배열방 인덱스를 가져오는 메서드 
	private static int getCharNumber(Character c) {
		
		// 소문자 a, z의 ASCII 코드 값을 가져온다.
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		
		if(a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}// getCharNumber 메서드 종료
	
	
	// main 메서드 
	public static void main(String[] args) {
		
		System.out.println(isPermutationOfPalindrome("aa bb cc dd"));
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e"));
		
		// 회문을 못 만듦
		System.out.println(isPermutationOfPalindrome("aa bb cc dd e fff"));
	}// main 메서드 종료

}// String_Check_Palindrome_And_Permutation_Sol_2 클래스 종료
