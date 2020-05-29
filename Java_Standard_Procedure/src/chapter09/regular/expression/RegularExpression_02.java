package chapter09.regular.expression;

import java.util.regex.*;

public class RegularExpression_02 {

	public static void main(String[] args) {

		String[] data = { "bat", "baby", "bonus", "c", "cA", "ca", "co", "c.", "c0", "c#", "car", "combat", "count",
				"date", "disc" };

		String[] pattern = { ".*", "c[a-z]*", "c[a-z]", "c[a-zA-z]", "c[a-zA-Z0-9]", "c.", "c.*", "c.*", "c\\.", "c\\w",
				"c\\d", "c.*t", "[b|c].*", ".*a.*", ".*a.+", "[b|c].{2}" };
		
		for(int x=0; x<pattern.length; x++) {
			Pattern p = Pattern.compile(pattern[x]);
			System.out.print("Pattern: "+ pattern[x]+" 결과:");
			
			for(int i=0; i<data.length; i++) {
				Matcher m = p.matcher(data[i]);
				if(m.matches()) {
					System.out.print(data[i]+",");
				}
				
			
			}
			System.out.println();
		}

	}

}

// 큰 따옴표(")내에서 escape문자 '\'를 표현하려면 escape문자를 '\\'와 같이 두번 사용해야 한다. 