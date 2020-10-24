package one.dimensioal.array;
/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 4344 (평균은 넘겠지)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class It_Will_Be_Above_Average_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine().trim());
		String[] str = new String[c];
		for(int i=0; i<c; i++) {
			str[i] = br.readLine().trim();
		}
		
		double result = 0;
		int p = 0;
		int sum = 0;
		ArrayList<String> nums;
		double avg = 0;
		
		for(int j=0; j<str.length; j++) {
				nums = new ArrayList<String>(Arrays.asList(str[j].split(" ")));
				int n = Integer.parseInt(nums.get(0));
				for(int k=1; k<n+1; k++) {
					sum += Integer.parseInt(nums.get(k)); 
				}
				avg = (double)sum / (double)n;
				for(int l=1; l<n+1; l++) {
					if(Integer.parseInt(nums.get(l))>avg) {
						p++;
					}
				}
				result = (double)p / (double)n *100;
				System.out.println(String.format("%.3f", result)+"%");
				result = 0;
				p = 0;
				sum = 0;
				nums.clear();
				avg = 0;
		}
		br.close();
	}
}
