package function;

/*
public class Main{
public static void main(String[] args){
}
}
*/
// 문제: 1065 (한수)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class OneNumber_Ex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 0;
		for (int i = 1; i < n + 1; i++) {
			String str = String.valueOf(i);
			if (str.length() == 1) {
				num++;
			} else {
				String[] strs = new String[str.length()];
				strs = str.split("");
				HashSet<Integer> hs = new HashSet<Integer>();
				for (int j = 0; j < strs.length - 1; j++) {
					int d = 0;
					d = Integer.parseInt(strs[j + 1]) - Integer.parseInt(strs[j]);
					hs.add(d);
				}
				if (hs.size() == 1) {
					num++;
				}
				hs.removeAll(hs);
			}
		}
		System.out.println(num);
	}
}
