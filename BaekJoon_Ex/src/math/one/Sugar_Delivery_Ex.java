package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2839 (설탕 배달)
import java.util.Scanner;
public class Sugar_Delivery_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		while(true) {
			if(n%5 == 0) {
				System.out.println((n/5) + count);
				break;
			}else if(n<=0) {
				System.out.println(-1);
				break;
			}
			n = n -3;
			count++;
		}
		
		sc.close();
	}
}
