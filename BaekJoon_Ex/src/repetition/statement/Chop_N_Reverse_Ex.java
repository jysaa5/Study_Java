package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2741 (N Âï±â)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Chop_N_Reverse_Ex {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=n; i>0; i--) {
			bw.write(i+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
