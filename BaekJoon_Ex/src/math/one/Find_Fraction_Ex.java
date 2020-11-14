package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1193 (분수찾기)
import java.util.Scanner;
public class Find_Fraction_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int line = 0;
		int cnt = 0;
		while(cnt<n) {
			line++;
			cnt = line *(line + 1) / 2;
		}
		if(line%2 != 0) {
			int numerator = 1+(cnt-n);
			int denominator = line - (cnt-n);
			System.out.println(numerator+"/"+denominator);
		}else {
			int numerator = line - (cnt-n);
			int denominator = 1 + (cnt-n);
			System.out.println(numerator+"/"+denominator);
		}
		sc.close();
	}
}
