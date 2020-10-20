package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 3052 (나머지)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
public class Rest_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		while(cnt < 10) {
			int n = Integer.parseInt(br.readLine().trim());
			int r = n % 42;
			hs.add(r);
			cnt++;
		}
		bw.write(hs.size()+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
