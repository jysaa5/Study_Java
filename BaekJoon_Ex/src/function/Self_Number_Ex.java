package function;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 4673 (셀프 넘버)
public class Self_Number_Ex {
	public static void main(String[] args) {
		int[] selfNumbers = new int[10000];
		for(int i=1; i<10000; i++) {
			String str = String.valueOf(i);
			String[] nums = new String[str.length()];
			nums = str.split("");
			int n = 0;
			n += Integer.parseInt(str);
			for(int j=0; j<str.length(); j++) {
				n += Integer.parseInt(nums[j]);
			}
			if(10000 >= n) {
			selfNumbers[n-1] += 1;
			}
		}
		
		for (int k=0; k<selfNumbers.length; k++) {
			if(selfNumbers[k] == 0) {
				System.out.println(k+1);
			}
		}
	}
}
