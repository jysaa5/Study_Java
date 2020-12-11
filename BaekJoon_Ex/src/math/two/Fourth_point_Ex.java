package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 3009 (네 번째 점)
import java.util.Scanner;
public class Fourth_point_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];
		int n = 0;
		while(n<3) {
			String str = sc.nextLine();
			x[n] = Integer.parseInt(str.split(" ")[0]);
			y[n] = Integer.parseInt(str.split(" ")[1]);
			n++;
		}
		int resultX = 0;
		if(x[0]==x[1]) {
			resultX = x[2];
		}else if(x[0] != x[1]) {
			if(x[0]==x[2]) {
				resultX = x[1];
			}else if(x[0] != x[2]) {
				resultX = x[0];
			}
		}
		
		int resultY = 0;
		if(y[0]==y[1]) {
			resultY = y[2];
		}else if(y[0] != y[1]) {
			if(y[0]==y[2]) {
				resultY = y[1];
			}else if(y[0] != y[2]) {
				resultY = y[0];
			}
		}
		
		System.out.println(resultX+" "+resultY);
		
 		sc.close();
	}
}
