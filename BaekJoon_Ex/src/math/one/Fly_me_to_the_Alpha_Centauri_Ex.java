package math.one;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// ¹®Á¦: 1011 (Fly me to the Alpha Centauri)
import java.util.Scanner;
public class Fly_me_to_the_Alpha_Centauri_Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine().trim());
		int[] nums = new int[t];
		for(int i=0; i<t; i++) {
			String s = sc.nextLine();
			int x = Integer.parseInt(s.split(" ")[0]);
			int y = Integer.parseInt(s.split(" ")[1]);
			int d = 1;
			int n = 1;
			int times = 1;
			d = x+1;
			while(d < y-1) {
				int k1 = n-1;
				int k2 = n;
				int k3 = n+1;
				if(k3 < y-1) {
					d += k3;
					n = n+1;
				}else if(k3>y-1) {
					if(k2<y-1) {
						d += k2;
					}else if(k2>y-1) {
						d += k1;
						if(d==y-1) {
							times++;
							break;
						}
						n = n-1;
					}else {
						times++;
						break;
					}
				}else {
					times++;
					break;
				}
				times++;
			}
			
			nums[i] = times;
		}
		
		for(int num : nums) {
			System.out.println(num);
		}
		
		sc.close();
	}
}
