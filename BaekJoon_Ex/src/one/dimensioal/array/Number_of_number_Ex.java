package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2577 (숫자의 개수)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Number_of_number_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = 0;
		int multi = 1;
		while(num < 3) {
			int n = Integer.parseInt(br.readLine().trim());
			multi *= n;
			num ++;
		}
		String str = String.valueOf(multi);
		int[] numbers = new int[10];
		for(int i=0; i<str.length(); i++) {
			int k = Integer.parseInt(str.charAt(i)+"");
			numbers[k] ++; 
		}
		for(int j : numbers) {
			bw.write(j+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
