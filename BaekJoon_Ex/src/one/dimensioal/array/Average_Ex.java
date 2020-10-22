package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 1546 (Æò±Õ)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Average_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		double max = arr[n-1];
		double mean = 0;
		double sum = 0;
		for(double s:arr) {
			sum += (s/max)*100;
		}
		mean = sum / n;
		bw.write(mean+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
