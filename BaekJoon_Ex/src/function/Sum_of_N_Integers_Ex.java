package function;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 15596 (정수 N개의 합)
public class Sum_of_N_Integers_Ex {
	public long sum (int[] a) {
		long ans = 0;
		for(int i=0; i<a.length; i++) {
			ans += a[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		Sum_of_N_Integers_Ex sol = new Sum_of_N_Integers_Ex();
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(sol.sum(a));
	}
}
