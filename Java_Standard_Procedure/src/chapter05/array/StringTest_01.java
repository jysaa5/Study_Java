package chapter05.array;

public class StringTest_01 {
	
	public static void main(String[] args) {
		String str1 = "ABCDEF";
		String str2 = "AB";
		String str3 = "EF";

		
		// str1, str2
		System.out.println("startsWith: " +str1.startsWith(str2));		
		// str1, str3
		System.out.println("startsWith: "+ str1.startsWith(str3,4));	
		// str2, str3
		System.out.println("startsWith: " + str2.startsWith(str3));
		// str1, str3
		System.out.println("startsWith: " + str1.startsWith(str3,2));
		
		// str1, str2
		System.out.println("endsWith: " + str1.endsWith(str2));	
		// str1, str3
		System.out.println("endsWith: " + str1.endsWith(str3));
		
		
		// str1, str2
		System.out.println("indexOf: " + str1.indexOf(str2));	
		// str1, str3
		System.out.println("indexOf: " + str1.indexOf(str3));
		// str2, str3
		System.out.println("indexOf: " + str2.indexOf(str3));	
		// str1
		System.out.println("indexOf: " + str1.indexOf('A'));
		
		// str1, str2
		System.out.println("lastIndexOf: " + str1.lastIndexOf(str2));	
		// str1, str3
		System.out.println("lastIndexOf: " +str1.lastIndexOf(str3));
		// str2, str3
		System.out.println("lastIndexOf: " +str2.lastIndexOf(str3));
		// str1
		System.out.println("lastIndexOf: " +str1.lastIndexOf('A'));
		// str1
		System.out.println("lastIndexOf: " +str1.lastIndexOf('D', 4));
		
	}

}
