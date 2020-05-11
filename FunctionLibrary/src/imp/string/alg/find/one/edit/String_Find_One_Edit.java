package imp.string.alg.find.one.edit;

// 문제: 세 가지 문자열 편집기능이 있다. 문자를 한 개 삽입하는 기능. 문자를 한 개 삭제하는 기능. 그리고 하나의 문자를 교체할 수 있는 기능이
// 있다. 주어진 두 개의 문자열이 편집기능을 단 한번만 이용한 경우(또는 한번도 이용하지 않은 경우)인지를 알아내는 함수를 구현하시오.
// insert(삽입): ple -> pale
// remove(제거): pale -> pale
// replace(교체): pale -> bale

// insert, remove: short와 long으로 문자를 각각 저장하고 long이 short보다 1개가 더 많으면 insert나 remove 기능이 사용된 것.
// replace: flag 변수를 한 개 두고, 변형되기전 문자열과 변형 후 문자열을 비교해서 다르면 flag를 true로 세팅해서(초기에는 false) 반환.


// String_Find_One_Edit 클래스
public class String_Find_One_Edit {
	
	// isOneAway 메서드: String이 한번 편집 되었거나 혹은 한 번도 편집이 안되었는지 확인하는 메서드
	private static boolean isOneAway(String s1, String s2) {
		
		String ss, ls;
		
		if(s1.length() < s2.length()) {
			ss = s1;
			ls = s2;
		}else {
			ss = s2;
			ls = s1;
		}
		
		// 1개 이상 차이나면 한 번만 편집된 것이 아니므로 false 반환
		if(ls.length() - ss.length() > 1) {
			return false;
		}
		
		boolean flag = false;
		
		// 교체
		for(int i = 0, j = 0; i <ss.length(); i++, j++) {
		
			if(ss.charAt(i) != ls.charAt(j)) {
				if(flag) {
					return false;
				}
				flag = true;
				
				// 삽입이나 삭제가 일어나서 문자열의 길이가 다를때
				if(ss.length() != ls.length()) {
					j++;
				}
				
			}
			
		}
		
		return true;
		
	}// isOneAway 메서드 종료
	
	
	// main 메서드
	public static void main(String[] args) {
		
		System.out.println(isOneAway("pal", "pal"));
		System.out.println(isOneAway("pal", "pale"));
		System.out.println(isOneAway("pale", "pal"));
		System.out.println(isOneAway("pale", "bale"));
		
		System.out.println(isOneAway("pal", "pales"));
		System.out.println(isOneAway("pale", "pel"));
		System.out.println(isOneAway("pale", "bake"));
	}// main 메서드 종료

}//String_Find_One_Edit 클래스 종료