package chapter05;

// p. 127
// 巩力: 模备 荐
// 贾风记: for巩, if巩

public class Number_of_friends_Sol_02 {
	
	public static int highestScore(String[] friends) {
		int ans = 0;
		int n = friends[0].length();
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			
			for(int j=0; j<n; j++) {
				if(i==j) {
					continue;
				}
				
				if(friends[i].charAt(j)=='Y') {
					cnt++;
				}else {
					for(int k=0; k<n; k++) {
						if((friends[i].charAt(k)=='Y')&&(friends[k].charAt(j)=='Y')) {
							cnt++;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		
//		String[] friends = {
//				"NNN",
//				"NNN",
//				"NNN"
//		};
		
		String[] friends = {
				"NYY",
				"YNY",
				"YYN"
		};
		
		
		System.out.println(highestScore(friends));
		
	}
}
