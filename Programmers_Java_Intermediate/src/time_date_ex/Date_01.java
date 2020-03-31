package time_date_ex;

import java.text.SimpleDateFormat;
import java.util.Date;

//Date: 날짜와 시간을 구하기 위한 클래스 Date 클래스
//Date클래스는 JDK 1.0때 만들어졌고, Calendar클래스는 JDK1.1에 만들어졌다.
//Date는 지역화에 대한 부분이 고려되지 않았다. 
//지역화란, 지역에 따라서 시간, 통화(원, 달러, 엔 등) 언어등에 대하여 고려하는 프로그래밍을 지역화에 맞춘 프로그래밍이라고 한다.
//Date클래스를 보면 대부분의 생성자와 메소드가 Deprecated되어 있다. 
//Deprecated된 것은 앞으로 지원을 안하거나 문제가 있을 수 있으니 사용하지 말라는 뜻이다.

public class Date_01 {
	public static void main(String[] args) {
		// 기본 생성자로 Date인스턴스를 만들게 되면 현재 시간과 날짜 정보를 Date인스턴스가 가지게 된다.
		Date date = new Date();
		// toString()메소드를 이용하여 현재 시간을 문자열로 구한다.
		System.out.println(date.toString());

		// 원하는 형식으로 값을 가공하기
		// a: 오전인지 오후인지 표시해준다.
		// zzz: timezone을 표시해준다.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");

		// 설정한 형식대로 출력됨.
		System.out.println(ft.format(date));

		// 현재 시간을 출력
		System.out.println(date.getTime());

		// long값으로 현재 시간 값을 얻을 수 있다.
		long today = System.currentTimeMillis();
		System.out.println(today);

		// 인스턴스를 만들었던 시간을 현재 시간에서 빼면 그 동안 걸린 시간을 구할 수 있다.
		System.out.println(today - date.getTime());
	}

}
