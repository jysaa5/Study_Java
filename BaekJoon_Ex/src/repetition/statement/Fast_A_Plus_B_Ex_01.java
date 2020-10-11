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
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Fast_A_Plus_B_Ex_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int[] num = new int[t * 2];
		
		for (int j = 0; j < t * 2; j = j + 2) {
			st = new StringTokenizer(br.readLine());
			num[j] = Integer.parseInt(st.nextToken());
			num[j + 1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();

		for (int k = 0; k < t * 2; k = k + 2) {
			int result = num[k]+num[k+1];
			bw.write(String.valueOf(result)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
