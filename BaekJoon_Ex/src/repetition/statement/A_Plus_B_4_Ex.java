package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 10951 (A+B-4)
import java.io.*;
import java.util.*;
public class A_Plus_B_4_Ex {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = 0;
		int b = 0;
		String s;
		while((s=br.readLine()) != null) {
			st = new StringTokenizer(s, " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			System.out.println(a+b);
		}
		br.close();
	}
}
