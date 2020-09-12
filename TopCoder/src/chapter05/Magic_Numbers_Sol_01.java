package chapter05;

// p.179
// 문제: 마법의 숫자

class NumberMagicEasy_01{
	public int theNumber(String answer) {
		
		// 카드가 가지고 있는 숫자
		int[] c_1 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] c_2 = {1, 2, 3, 4, 9, 10, 11, 12};
		int[] c_3 = {1, 2, 5, 6, 9, 10, 13, 14};
		int[] c_4 = {1, 3, 5, 7, 9, 11, 13, 15};
		
		for(int i=1; i<=16; i++) {
			if(Check(c_1,i) != answer.charAt(0)) {
				continue;
			}
			
			if(Check(c_2,i) != answer.charAt(1)) {
				continue;
			}
			
			if(Check(c_3, i) != answer.charAt(2)) {
				continue;
			}
			
			if(Check(c_4, i) != answer.charAt(3)) {
				continue;
				
			}
			
			return i;
		}
		return 0;
	}
	
	
	char Check(int[] X, int number) {
		for(int x: X) {
			if(x==number) {
				return 'Y';
			}
		}
		return 'N';
	}
}

public class Magic_Numbers_Sol_01 {
	
	public static void main(String[] args) {
		NumberMagicEasy_01 sol = new NumberMagicEasy_01();
		//String answer = "YNYY";
		//String answer = "YNNN";
		//String answer = "YYYY";
		String answer = "NYNY";
		System.out.println(sol.theNumber(answer));
	}

}
