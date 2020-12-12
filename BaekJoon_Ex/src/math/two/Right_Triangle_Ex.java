package math.two;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 4153 (직각삼각형)
import java.util.Scanner;
public class Right_Triangle_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String str = sc.nextLine();
			int a = Integer.parseInt(str.split(" ")[0]);
			int b = Integer.parseInt(str.split(" ")[1]);
			int c = Integer.parseInt(str.split(" ")[2]);
			int max = Math.max(a, b);
			max = Math.max(max, c);
			int x1 = 0;
			int x2 = 0;
			if(max != a && max !=b) {
				x1 = a;
				x2 = b;
			}else if(max != a && max != c) {
				x1 = a;
				x2 = c;
			}else if(max != b && max != c) {
				x1 = b;
				x2 = c;
			}
			if(a==0) {
				break;
			}
			if((Math.pow(x1, 2)+Math.pow(x2, 2)) == Math.pow(max, 2)) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
		sc.close();
	}
}
