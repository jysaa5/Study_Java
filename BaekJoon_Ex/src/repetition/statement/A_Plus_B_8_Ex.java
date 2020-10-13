package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 11022 (A+B-8)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class A_Plus_B_8_Ex {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int[] num = new int[2];
		int k=0;
		for(int i=1; i<t+1; i++) {
			st = new StringTokenizer(br.readLine());
			num[k] = Integer.parseInt(st.nextToken());
			num[k+1] = Integer.parseInt(st.nextToken());
			int n = num[k]+num[k+1];
			bw.write("Case #"+i+": "+num[k]+" + "+num[k+1]+" = "+n+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
