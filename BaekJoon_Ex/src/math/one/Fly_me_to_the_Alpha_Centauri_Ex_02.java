package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 1011 (Fly me to the Alpha Centauri)
import java.util.Scanner;
public class Fly_me_to_the_Alpha_Centauri_Ex_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();
		for(long i=0; i<t; i++) {
		long x = sc.nextInt();
		long y = sc.nextInt();
		long length = y - x;
		long answer = 1;
		long distance = 0;
		while(length > distance ) {
			answer ++;
			distance += answer/2;
		}
		System.out.println(answer-1);
		}
		sc.close();
	}
}
