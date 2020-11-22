package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 10250 (ACM호텔)
import java.util.Scanner;
public class ACM_Hotel_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine().trim());
		int count = 0;
		while(n>count) {
			String str = sc.nextLine();
			String[] nums = str.split(" ");
			int height = Integer.parseInt(nums[0]);
			int width = Integer.parseInt(nums[1]);
			int guest = Integer.parseInt(nums[2]);
			int x = (guest/height) + 1;
			int y = guest%height;
			
			if(guest%height==0) {
				x = guest/height;
				y = height;
			}
			System.out.println(y*100+x);
			count++;
		}
		sc.close();
	}
}
