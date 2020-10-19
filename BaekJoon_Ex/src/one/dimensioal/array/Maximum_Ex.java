package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2562 (최대값)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Maximum_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 1;
		int count = 0;
		int num = 0;
		while(count < 9) {
			count ++;
			int x = Integer.parseInt(br.readLine().trim());
			if(x > max) {
				max = x;
				num = count;
			}
		}
		bw.write(max+"\n");
		bw.write(num+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
