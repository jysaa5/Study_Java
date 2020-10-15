package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 2438 (º° Âï±â-1)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
              
public class Chop_Star_1_Ex {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder start = new StringBuilder();
		for(int i=0; i<n; i++) {
			start.append("*");
			bw.write(start.toString());
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
