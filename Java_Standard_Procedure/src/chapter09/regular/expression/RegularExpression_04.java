package chapter09.regular.expression;

import java.util.regex.*;

public class RegularExpression_04 {
	
	public static void main(String[] args) {
		
		String source = "A broken hand works, but not a broken heart.";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source:"+source);
		
		int i = 0;
		
		// 문자열 source에서 "broken"을 찾은 후 처음으로 appendReplacement 메서드가 호출되면 source의 시작부터 broken을 찾은 위치까지의 내용에 drunken을 더해서 저장한다.
		// sb = "A drunken"
		// 첫 번째로 발견된 위치의 끝에서부터 다시 검색을 시작하여 두 번째 broken을 찾게 된다. 다시 appendReplacement가 호출.
		// sb = "A drunken hand works, but not a drunken"
		while(m.find()) {
			System.out.println(++i + "번째 매칭:" + m.start() + "~"+ m.end());
			
			//broken을 drunken으로 치환하여 sb에 저장한다.
			m.appendReplacement(sb, "drunken");
		}
		
		// sb = "A drunken hand works, but not a drunken heart."
		// appendTail 메서드가 호출되면 마지막 치환된 이후의 부분을 sb에 덧붙인다.
		m.appendTail(sb);
		System.out.println("Replacement count :"+i);
		System.out.println("result:"+sb.toString());
	}

}
