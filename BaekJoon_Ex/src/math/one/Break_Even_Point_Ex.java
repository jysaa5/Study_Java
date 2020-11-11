package math.one;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10809 (손익분기점)
import java.util.Scanner;

public class Break_Even_Point_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] nums = str.split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int c = Integer.parseInt(nums[2]);
		int result = 1;
		
		if((c-b)<=0) {
			result = -1;
		}else {
			result = (a/(c-b))+1;
		}
		System.out.println(result);
		sc.close();
	}
}
