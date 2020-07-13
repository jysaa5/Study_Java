package practice.problem;
//문제: 가운데 글자 가져오기
/*
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.

입출력 예
s     | return
abcde | c
qwer  |	we
*/
//솔루션: substring 사용
// 문자열이 짝수면 두번째 인덱스는 첫 번째 인덱스의 +2이다.
// 문자열이 홀수면 두번째 인덱스는 첫번째 인덱스의 +1이다.

class Get_The_Middle_Letter_Solution_02 {
    public String solution(String s) {
        String answer = "";
        
        return s != null ? s.substring((s.length()-1)/2, (s.length()+2)/2): "";
        
    }
}

public class Get_The_Middle_Letter_Sol_02 {
	public static void main(String[] args) {
		//String s = "abcde";
		String s = "qwer";
		Get_The_Middle_Letter_Solution_01 sol = new Get_The_Middle_Letter_Solution_01();
		System.out.println(sol.solution(s));
		
	}
}
