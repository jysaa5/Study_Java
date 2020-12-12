package math.two;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 3009 (네 번째 점)
import java.util.Scanner;
import java.util.HashMap;

public class Fourth_Point_Ex_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hmX = new HashMap<String, Integer>();
		HashMap<String, Integer> hmY = new HashMap<String, Integer>();
		for (int i = 0; i < 3; i++) {
			String str = sc.nextLine();
			String x = str.split(" ")[0];
			String y = str.split(" ")[1];
			if (hmX.containsKey(x)) {
				hmX.put(x, hmX.get(x) + 1);
			} else {
				hmX.put(x, 1);
			}
			if (hmY.containsKey(y)) {
				hmY.put(y, hmY.get(y) + 1);
			} else {
				hmY.put(y, 1);
			}
		}
		for(String str : hmX.keySet()) {
			if(hmX.get(str)%2 !=0) {
				System.out.print(str+" ");
			};
		}
		for(String str: hmY.keySet()) {
			if(hmY.get(str)%2 != 0) {
				System.out.print(str);
			}
		}
		sc.close();
	}
}
