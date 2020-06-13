package practice.problem;

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
//솔루션: 각 월별의 일수를 파악해서 배열문에 저장, 요일 배열문에 저장

/*
1월: 31일, 2월: 29일, 3월: 31일, 4월: 30일, 5월: 31일, 6월: 30일, 7월: 31일, 8월: 31일
9월: 30일, 10월: 31일, 11월: 30일, 12월: 31일 
*/

class Year_2016_Solution_02 {

	public String solution(int a, int b) {

		// 반환값
		String answer = "";
		
		// 각 월별 일수
		int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};

		// 요일
		String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		
		// 해당 월의 일수
		int days = 0;
		
		// 전체 일수
		int totalDay = 0;
		
		
		// 1월이 0인덱스부터 시작하므로 a-1까지
		for(int i=0; i<a-1; i++) {
			
			totalDay += dayOfMonth[i];
		}
		
		// 7로 나눴을 때, 나머지가 0, 1, 2, 3, 4, 5, 6 이렇게 되므로 1월 1일이 금요일이 되려면 원래 1일에서 1을 빼줘야한다. 
		days = b-1;
		
		// String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		// 위와 같이 하면 b에서 1을 안 빼도 된다.
		
		totalDay += days;
		
		answer = dayOfWeek[totalDay%7]; 	
		
		return answer;
	}
}

public class Year_2016_Sol_02 {
	
	public static void main(String[] args) {
		Year_2016_Solution_02 sol = new Year_2016_Solution_02();

		//int a = 5;
		//int b = 24;

		int a = 1;
		int b = 1;
		
		System.out.println(sol.solution(a, b));
	}

}
