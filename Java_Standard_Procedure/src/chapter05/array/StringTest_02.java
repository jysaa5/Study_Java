package chapter05.array;

public class StringTest_02 {
	public static void main(String[] args) {
		String str1 = "HelloWorld";
		char[] arr = str1.toCharArray();

		for (char c : arr) {
			System.out.println(c);
		}

		String str2 = new String(arr);
		System.out.println("새로 만들어진 문자열: " + str2);
	}

}
