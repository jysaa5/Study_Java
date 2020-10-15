package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2439 (º° Âï±â-2)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Chop_Star_2_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(" ");
		}
		
		for(int i=n-1; i>-1; i--) {
			sb.setCharAt(i, '*');
			bw.write(sb.toString()+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
