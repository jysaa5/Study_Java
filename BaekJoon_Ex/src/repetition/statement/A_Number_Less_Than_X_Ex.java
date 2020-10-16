package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10871 (x보다 작은 수)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class A_Number_Less_Than_X_Ex {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		String l = br.readLine();
		String[] nums = new String[l.length()];
		nums = l.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String s: nums) {
			if(Integer.parseInt(s) < x) {
				sb.append(s+' ');
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
