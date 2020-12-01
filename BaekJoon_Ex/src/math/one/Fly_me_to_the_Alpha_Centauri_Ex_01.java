package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 1011 (Fly me to the Alpha Centauri)
import java.util.Scanner;
public class Fly_me_to_the_Alpha_Centauri_Ex_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine().trim());
		int[] nums = new int[t];
		for(int i=0; i<t; i++) {
			String s = sc.nextLine();
			int x = Integer.parseInt(s.split(" ")[0]);
			int y = Integer.parseInt(s.split(" ")[1]);
			int distance = y-x;
			int cnt = 1;
			
			while(true) {
				if(Math.pow(cnt, 2) > distance) {
					break;
				}
				cnt++;
			}
			cnt--;
			
			int move = cnt*2 -1;
			int minor = distance - (int)Math.pow(cnt, 2);
			move += Math.ceil((double)minor/(double)cnt);
			nums[i] = move;
		}
		
		for(int num : nums) {
			System.out.println(num);
		}
		
		sc.close();
	}
}
