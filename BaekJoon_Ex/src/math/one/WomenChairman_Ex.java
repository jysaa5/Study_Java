package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 2775 (부녀회장이 될테야)
import java.util.Scanner;
public class WomenChairman_Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 아파트 생성 
		int[][] APT = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			APT[i][1] = 1;	// i층 1호
			APT[0][i] = i;	// 0층 i호
		}
 
 
		for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지
 
			for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
				APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
			}
		}
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(APT[n][k]);
		}
		sc.close();
	}
}
