package condition.statement;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2884 (알람 시계)
import java.util.Scanner;

public class Alarms_clocks_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();

		if (m < 45) {
			if (h == 0) {
				h = 23;
			} else {
				h = h - 1;
			}
			m = 15 + m;
		} else {
			m = m - 45;
		}
		System.out.print(h);
		System.out.print(" ");
		System.out.print(m);
		sc.close();
	}
}
