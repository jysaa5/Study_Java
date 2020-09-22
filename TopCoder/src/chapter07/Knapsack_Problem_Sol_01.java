package chapter07;

public class Knapsack_Problem_Sol_01 {
	
	static int[] ws = {3, 4, 1, 2, 3};
	static int[] ps = {2, 3, 2, 3, 6};
	
	static int maxw = 10;
	static int ret = 0;
	
	static void knapsack(int n, int w, int p) {
		if(w>maxw) {
			return;
		}
		ret = Math.max(ret, p);
		
		if(n>=ws.length) {
			return;
		}
		
		knapsack(n+1, w, p);
		knapsack(n+1, w+ws[n], p+ps[n]);
	}
	
	
	public static void main(String[] args) {
		
		
	}

}
