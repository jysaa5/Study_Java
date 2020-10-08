package condition.statement;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 9498 (시험 성적)
import java.util.Scanner;
public class Test_results_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(90<=score && score <=100) {
			System.out.println('A');
		}else if(80<=score && score <= 89) {
			System.out.println('B');
		}else if(70<=score && score<=79) {
			System.out.println('C');
		}else if(60<=score && score<=69) {
			System.out.println('D');
		}else {
			System.out.println('F');
		}
	}
}
