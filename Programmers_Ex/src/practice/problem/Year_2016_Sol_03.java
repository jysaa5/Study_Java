package practice.problem;

import java.util.Calendar;
import java.util.Locale;

//문제: 2016년
/*
문제 설명

2016년 1월 1일은 금요일입니다. 
2016년 a월 b일은 무슨 요일일까요? 
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건

2016년은 윤년입니다. -> 2/29 까지.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

입출력 예
a |	b  | result
5 |	24 | TUE

*/
//솔루션: 라이브러리 활용

/*
1월: 31일, 2월: 29일, 3월: 31일, 4월: 30일, 5월: 31일, 6월: 30일, 7월: 31일, 8월: 31일
9월: 30일, 10월: 31일, 11월: 30일, 12월: 31일 
*/

class Year_Solution_03{
	public String solution(int a, int b) {
	
		String answer = "";
		
		Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, a-1, b).build();
		
		answer = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
		
		
		return answer;
	}
}

public class Year_2016_Sol_03 {
	
	public static void main(String[] args) {
		Year_2016_Solution_02 sol = new Year_2016_Solution_02();

		//int a = 5;
		//int b = 24;

		int a = 1;
		int b = 1;
		
		System.out.println(sol.solution(a, b));
	}

}
