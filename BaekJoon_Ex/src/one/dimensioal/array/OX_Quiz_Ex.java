package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 8958 (OXÄûÁî)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class OX_Quiz_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().trim();
		}
		int score = 0;
		int sum = 0;
		for(int j=0; j<arr.length; j++) {
			for(int k=0; k<arr[j].length(); k++) {
				if(arr[j].charAt(k)=='O') {
					score++;
					sum += score;
				}else {
					score = 0;
				}
			}
			bw.write(sum+"\n");
			score = 0;
			sum = 0;
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
