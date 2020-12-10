package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1085 (직사각형에서 탈출)
import java.util.Scanner;
public class Escape_From_The_Rectangle_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int d1 = w - x;
		int d2 = h - y;
		
		int result1 = (d1>=d2) ? d2 : d1;
		int result2 = (x>= y) ? y : x;
		int ans = result1 >= result2 ? result2 : result1;
		System.out.println(ans);
		
		sc.close();
	}
}
