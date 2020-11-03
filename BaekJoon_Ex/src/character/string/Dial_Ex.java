package character.string;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 5622 (다이얼)
import java.util.Scanner;
public class Dial_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alp = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		int time = 2;
		int result = 0;
		String str = sc.nextLine().trim();
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<alp.length; j++) {
				if(alp[j].indexOf(str.charAt(i)) > -1) {
					result += (time+j+1);
				}
			}
		}
		System.out.println(result);
	}
}
