package practice.problem;
// 문제: 가운데 글자 가져오기
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
// 솔루션: 문자열 배열 사용

class Get_The_Middle_Letter_Solution_01 {
    public String solution(String s) {
        String answer = "";
        
        String[] str = new String[s.length()];
        str = s.split("");
        
        
        if(s.length()%2==0) {
        	answer += str[(s.length()/2)-1];
        	answer += str[s.length()/2];
        }else {
        	
        	answer += str[s.length()/2];
        }
        
        
        return answer;
    }
}

public class Get_The_Middle_Letter_Sol_01 {
	
	public static void main(String[] args) {
		//String s = "abcde";
		String s = "qwer";
		Get_The_Middle_Letter_Solution_01 sol = new Get_The_Middle_Letter_Solution_01();
		System.out.println(sol.solution(s));
		
	}

}
