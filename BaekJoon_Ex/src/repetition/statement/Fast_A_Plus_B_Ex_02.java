package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 15552 (빠른 A+B)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fast_A_Plus_B_Ex_02 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String s = br.readLine();
			String[] num = s.split(" ");
			int x = Integer.parseInt(num[0]);
			int y = Integer.parseInt(num[1]);
			bw.write((x+y)+ "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
