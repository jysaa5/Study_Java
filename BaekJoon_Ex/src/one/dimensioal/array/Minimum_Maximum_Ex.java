package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10818 (최소, 최대)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Minimum_Maximum_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = -1000001;
		int min = 1000001;
		while (st.hasMoreTokens()) {
			int val = Integer.parseInt(st.nextToken());
			if (val > max) {
				max = val;
			}
			if (val < min) {
				min = val;
			}
		}
		bw.write(min+" "+max);
		br.close();
		bw.flush();
		bw.close();
	}
}
