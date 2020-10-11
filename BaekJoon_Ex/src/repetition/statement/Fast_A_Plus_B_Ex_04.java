package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 15552 (빠른 A+B)
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Fast_A_Plus_B_Ex_04 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			String str = br.readLine();
			int target = str.indexOf(" ");
			int result = Integer.parseInt(str.substring(0, target))+Integer.parseInt(str.substring(target+1));
			sb.append(result+"\n");
		}
		br.close();
		System.out.println(sb);
		
	}
}
