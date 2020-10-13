package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 11021 (A+B-7)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class A_Plus_B_7_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int[] num = new int[2];
		int k = 0;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			num[k] = Integer.parseInt(st.nextToken());
			num[k+1] = Integer.parseInt(st.nextToken());
			int n = i+1;
			int sum = num[k]+num[k+1];
			bw.write("Case #"+n+":"+" "+sum+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
