package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 10952 (A+B-5)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class A_Plus_B_5_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = 1;
		int b = 1;
		StringTokenizer st;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		while((a != 0) || (b != 0)) {
			st =  new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ar.add(a);
			ar.add(b);
		}
		
		for(int i=0; i<ar.size(); i=i+2) {
			if(ar.get(i)+ar.get(i) != 0) {
			bw.write(ar.get(i)+ar.get(i+1)+"\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
