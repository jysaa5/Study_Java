package character.string;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 11720 (숫자의 합)
import java.util.Scanner;
public class Sum_Of_Numbers_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine().trim());
		String str = sc.nextLine();
		String[] nums = str.split("");
		int result = 0;
		for(int i=0; i<n; i++) {
			
			result += Integer.parseInt(nums[i]);
		}
		System.out.print(result);
	}
}
