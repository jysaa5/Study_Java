package character.string;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2908 (상수)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Constant_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb;
		for(int i=0; i<2; i++) {
			sb = new StringBuilder(st.nextToken());
			num = Integer.parseInt(sb.reverse().toString());
			if (num > max) {
				max = num;
			}
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
