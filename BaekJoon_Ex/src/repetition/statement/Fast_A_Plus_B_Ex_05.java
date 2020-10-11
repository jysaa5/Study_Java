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
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Fast_A_Plus_B_Ex_05 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			String str = br.readLine();
			int target = str.indexOf(" ");
			int result = Integer.parseInt(str.substring(0, target))+Integer.parseInt(str.substring(target+1));
			sb.append(result+"\n");
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
