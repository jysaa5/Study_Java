package practice.problem;

// 문제: 2016년
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
// 솔루션: 각 월별의 일수를 파악해서 for문과 if문을 사용해서 월에 따라 일수 더하기. switch문으로 전체 일수를 7로 나눈 값에 따라 요일 반환하기.

/*
1월: 31일, 2월: 29일, 3월: 31일, 4월: 30일, 5월: 31일, 6월: 30일, 7월: 31일, 8월: 31일
9월: 30일, 10월: 31일, 11월: 30일, 12월: 31일 
*/

class Year_2016_Solution_01 {

	public String solution(int a, int b) {

		// 반환값
		String answer = "";
		
		// 전체 일 수 
		int totalDay = 0;
		
		// 각 월의 일 수 
		int dayOfMonth = 0;
		
		// 2016년 1월 ~ 12월
		for (int i = 1; i < a; i++) { 
			
			
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
			
				dayOfMonth = 31;
		
			else if (i == 2)
		
				dayOfMonth = 29;
		
			else
			
				dayOfMonth = 30;

			totalDay += dayOfMonth;
			
		}
		
		// 해당하는 월의 이전 월까지 더한 전체 일 수 + 해당하는 일 수  
		totalDay += b;

		
		// 7로 나누기: 2016년 1월 1일 = 금요일. 
		// 금: 1 / 토: 2 / 일: 3/ 월:4/ 화:5/ 수:6/ 목:7/ 
		// 7로 나누면, 1 / 2 / 3 / 4 / 5 / 6 / 0
		switch (totalDay % 7) {
		
		case 0:
			answer = "THU";
			break;
		case 1:
			answer = "FRI";
			break;
		case 2:
			answer = "SAT";
			break;
		case 3:
			answer = "SUN";
			break;
		case 4:
			answer = "MON";
			break;
		case 5:
			answer = "TUE";
			break;
		case 6:
			answer = "WED";
			break;

		}

		return answer;

	}
}

public class Year_2016_Sol_01 {

	public static void main(String[] args) {
		Year_2016_Solution_01 sol = new Year_2016_Solution_01();

		int a = 5;
		int b = 24;

		System.out.println(sol.solution(a, b));
	}

}
