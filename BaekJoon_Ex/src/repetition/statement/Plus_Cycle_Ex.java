package repetition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1110 (더하기 사이클)
import java.util.Scanner;
public class Plus_Cycle_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = "";
		if(n<10) {
			str = "0"+n;
		}else {
			str = n+"";
		}
		int result = 0;
		int cnt = 0;
		do {
			if(str.length()>1) {
			int a = Integer.parseInt(str.charAt(0)+"");
			int b = Integer.parseInt(str.charAt(1)+"");
			int c = a+b;
			result = (b*10)+(c%10);
			str = result+"";
			cnt++;
			}else {
				str = "0"+result;
			}
		}while(n != result);
		
		System.out.println(cnt);
	}
}
