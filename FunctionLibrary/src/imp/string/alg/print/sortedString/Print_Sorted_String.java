package imp.string.alg.print.sortedString;

// 문제: 주어진 문자열의 길이 k를 가지고 길이가 k인 정렬된 문자열의 모든 조합을 만드는 함수를 구하시오. 이 함수는 k길이의 모든 문자열을 
// 만든 후에 각 문자열이 정렬이 되어 있는 지를 확인해야 한다.

// 예시: 문자열의 길이 k가 2일 때. 모든 문자열의 조합을 만들어야 한다.
/* k = 2
 * aa, ab, ac, ad, ... az -> 26개의 경우가 나온다.
 * ba, bb, bc, bd, ... bz -> 26개의 경우가 나온다.
 * ca, cb, cc, cd, ... cz -> 26개의 경우가 나온다.
 * ...
 * za, zb, zc, zd, ... zz -> 26개의 경우가 나온다. 
 * 
 * -> C를 26개라고 할때, C^k만큼 경우의 수가 늘어난다.
 * -> k가 3이되면 큐빅모양이 된다. C^3이므로.
 * -> 각 문자열이 정렬이 된 건지만 확인하면 되므로 매번 앞에 문자랑만 비교하면 된다. 문자열의 길이 만큼만 돌면 된다. 
 * -> k*C^k
 * -> 시간복잡도 = O(kC^k)
 * */

// Print_Sorted_String 클래스
public class Print_Sorted_String {

	// 상수 C
	public static final int C = 26;
	
	
	// printSortedStrings 메서드: 정렬된 문자열을 출력하는 메서드 
	// k = 문자열의 길이
	private static void printSortedStrings(int k) {
		
		// "" : prefix(접두사)를 비워서 실행할 함수에 넘겨준다.
		printSortedStrings(k, "");
		
	}
	
	private static void printSortedStrings(int k, String prefix) {
		
		// k가 0이 되었을때, 문자열들이 정렬되었는 지 확인한다.
		if(k==0) {
			
			if(isInOrder(prefix)) {
				System.out.println(prefix);
			}
			
		}else {
		
		
		for(int i=0; i<C; i++) {
			
			// 문자를 받아온다.
			char c = ithLetter(i);
			
			// prefix에 받아온 문자를 추가한다. 
			// k를 감소 시키면서 문자열의 개수가 원하는 만큼 도달하는 지 알 수 있다.
			printSortedStrings(k-1, prefix+c);
			}
		}
	}//printSortedStrings 메서드 종료
	
	
	// isInOrder 메서드: 해당 문자열이 정렬이 되었는지 확인하는 메서드
	// s: 정렬이 되었는지 확인할 문자열 
	private static boolean isInOrder(String s) {
		
		for (int i=1; i<s.length(); i++) {
			// 이전 문자
			int prev = ithLetter(s.charAt(i-1));
			// 현재 문자
			int curr = ithLetter(s.charAt(i));
			
			// 문자 순서 비교 
			if(prev > curr) {
				return false;
			}
		}
		
		return true;
		
	}// isInOrder 메서드 종료
	
	
	// ithLetter 메서드: i번째 문자를 가져오는 메서드
	private static char ithLetter(int i) {
		
		return (char)(((int) 'a')+i);
		
	}// ithLetter 메서드 종료
	
	
	
	// main 메서드
	public static void main(String[] args) {
		
		// 351개 = (C^2 / 2) + (C/2)
		printSortedStrings(2);
		
		
	}// main 메서드 종료
	
}// Print_Sorted_String
