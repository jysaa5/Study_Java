package math.one;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2869 (달팽이는 올라가고 싶다)
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Snail_Wants_To_Go_Up_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(" ");
		int a = Integer.parseInt(strArr[0]);
		int b = Integer.parseInt(strArr[1]);
		int v = Integer.parseInt(strArr[2]); 
		int d = 0;
		d = (v-b)/(a-b);
		if(((v-b)%(a-b)) !=0) {
			d++;
		}
		System.out.println(d);
		br.close();
	}
}
