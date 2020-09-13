package string.ex.check.palindrome.permutation;

// 문제: 주어진 문자열이 회문(palindrome)을 만들수 있는 문자열의 치환(permutation)인지를 확인하는 함수를 만드시오.

// 회문(palindrome): 앞으로 읽으나 뒤로 읽으나 똑같은 단어나 문자열을 말한다. 
// 회문인지 찾는 방법: 문자열 맨 처음이랑 맨 끝에 포인터를 두고 한 칸씩 뒤와 앞으로 움직이면서 같은 문자인지 확인한다.
// 회문 특징: 문자열을 가운데 딱 나누면 거울처럼 데칼코마니가 된다. 가운데 문자만 홀수가 될 수 있다. 그래서 하나를 제외한 다른 문자들이 회문이 될 수 있다.
// ex) mom, racecar

// 치환(permutation): 문자열 안에 문자의 종류와 개수가 같은 것
// ex) mmo, omm
// Solution 3: 
/*  a b c  ...  y  z
 * |0|1|2| ... |24|25 -> 배열의 인덱스
 * 
 * -> 각 문자의 개수를 세어서 문자별로 배열에 저장한 후에 그 배열을 돌면서 홀수 개인 문자가 1개 초과이면 회문 규칙에 어긋나므로, 회문 규칙에 맞는
 *    것을 찾는다. 
 * -> Bit Operator(비트 연산자) 사용: 짝수 = 0, 홀수 = 1 -> 1이 한개만 있거나 아예 없을 때 회문 가능
 * 
 * 
 * ex) "dadccd"
 * 1) d
 * 1<<3 (알파벳 자리수만큼 시프트연산)
 * -> 0000001
 * -> 0001000
 * -> 결과값: 0001000
 * 
 * 2) a
 * 1<<0
 * -> 0000001
 * -> 0000001
 * 
 * 이전의 결과값과 AND 연산
 * -> 결과값: 0001000 
 *         & 0000001
 *         ----------
 *           0000000 -> 이전 결과값과 지금 시프트 값의 &연산값이 0이면, 기존에 있던 자리에 짝수개라는 의미
 * 
 * -> &연산값이 0이면 |연산을 한다.
 * -> 결과값: 0001000 
 *         | 0000001
 *         ----------
 *           0001001 
 * -> 결과값:  0001001      
 * 
 * 3) d
 * 1<<3
 * -> 0000001
 * -> 0001000
 * 
 * 이전의 결과값과 AND 연산
 * -> 결과값: 0001001 
 *         & 0001000
 *         ----------
 *           0001000 -> 0이 아니므로 기존에 있던 자리의 수가 홀수 개라는 의미이다. 그러므로 해당 자리의 값을 0으로 만들어줘야 된다.
 *                      1을 빼주면 해당 자리를 0으로 만들 수 있다.
 *
 * 시프트 값을 토글해준다.
 * ~ 0001000
 * ----------
 *   1110111
 *
 * 1을 빼주는 방법 = 토글값과 이전 결과값을 & 연산한다.
 *   0001001
 * & 1110111
 * -----------
 *   0000001
 * 
 * -> 결과값: 0000001
 * 
 * 
 * 4) c
 * 1<<2
 * -> 0000001
 * -> 0000100
 *
 * 이전의 결과값과 AND 연산
 * -> 결과값:  0000001 
 *         & 0000100
 *         ----------
 *           0000000 -> 0
 *
 * -> &연산값이 0이면 |연산을 한다.
 * -> 결과값: 0000001
 *         | 0000100
 *         ----------
 *           0000101 
 * -> 결과값:  0000101      
 * 
 * 
 * 5) c
 * 1<<2
 * -> 0000001
 * -> 0000100
 *
 * 이전의 결과값과 AND 연산
 * -> 결과값:  0000101 
 *         & 0000100
 *         ----------
 *           0000100 -> 0이 아니다. 0이 아니므로 기존에 있던 자리의 수가 홀수 개라는 의미이다. 그러므로 해당 자리의 값을 0으로 만들어줘야 된다.
 *                      1을 빼주면 해당 자리를 0으로 만들 수 있다.
 *
 * 시프트 값을 토글해준다.
 * ~ 0000100
 * ----------
 *   1111011
 *
 * 1을 빼주는 방법 = 토글값과 이전 결과값을 & 연산한다.
 *    0000101 
 * &  1111011
 * -----------
 *    0000001
 * 
 * -> 결과값: 0000001
 * 
 * 6) d
 * 1<<3
 * -> 0000001
 * -> 0001000
 * 
 * 이전의 결과값과 AND 연산
 * -> 결과값: 0000001 
 *         & 0001000
 *         ----------
 *           0000000 -> 0
 *
 * -> &연산값이 0이면 |연산을 한다.
 * -> 결과값: 0000001
 *         | 0001000
 *         ----------
 *           0001001 
 * -> 결과값:  0001001     
 * 
 * 7) 이제 이 결과값이 홀수 개가 1개만 있거나 아예 없는 지 판단: (결과 값 - 1) & 결과값 -> 여기가 0이면 홀수개가 1개거나 아예없음. 1이면 홀수개가 1개 초과
 *   0001001 
 *  -0000001
 *  ---------
 *   0001000
 * & 0001001
 * ----------
 *   0001000 -> 0이 아니기 때문에 문자열의 홀수개인 것이 1개 초과 이다. 
 * */



public class String_Check_Palindrome_And_Permutation_Sol_3 {
	
	// isPermutationOfPalindrome 메서드: 회문인지 아닌지 찾는 메서드
	private static boolean isPermutationOfPalindrome(String s) {
		
		// 짝수, 홀수 비트 값을 만드는 함수 호출하여 결과 저장
		int bitVector = createBitVector(s);
		
		// 홀수개가 모두 없거나(모두 짝수이거나) 홀수 개가 1개일 때 true 반환
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
		
		
	}// isPermutationOfPalindrome 메서드 종료
	
	
	// createBitVector 메서드: 해당 문자열의 문자 개수를 짝수, 홀수로 표현하는 메서드
	private static int createBitVector(String s) {
		
		// 결과값 저장 변수
		int bitVector = 0;
		
		// 문자열을 한자씩 돌기 
		for(char c : s.toCharArray()) {
			
			//  배열방 인덱스 가져오기 
			int x = getCharNumber(c);
			
			// 배열방 번호를 0 -> 1, 1 -> 0 로 만드는 메서드 호출
			bitVector = toggle(bitVector, x);
			
		}
		
		return bitVector;
		
	}// createBitVector 메서드 종료
	
	
	// toggle 메서드
	private static int toggle(int bitVector, int index) {
		
		if(index < 0) {
			return bitVector;
		}
		
		// 배열방 번호 만큼 왼쪽으로 1을 시프트하여 마스크에 저장
		int mask = 1 << index;
		
		// 현재 문자 위치에 1인지 And 연산자
		if((bitVector & mask) == 0) {
			// 문자가 모두 짝수 개 일때
			bitVector |= mask;
		}else {
			// 문자가 홀수 개 일때
			bitVector &= ~mask;
		}
		return bitVector;
		
	}// toggle 메서드 종료
	
	
	// checkExactlyOneBitSet 메서드: 하나만 홀수 개인지 확인하는 메서드
	private static boolean checkExactlyOneBitSet(int bitVector) {
		
		return (bitVector & (bitVector - 1)) == 0;
	
	}// checkExactlyOneBitSet 메서드 종료
	
	
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

}
