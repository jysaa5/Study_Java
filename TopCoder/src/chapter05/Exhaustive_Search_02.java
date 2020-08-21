package chapter05;

import java.util.HashMap;

//p. 91
//문제: 즐거운 파티
//솔루션: for문, if문, Math.max 사용

public class Exhaustive_Search_02 {
	public static int bestInvitation(String[] first, String[] second) {
		
		// HashMap 생성  
		HashMap<String, Integer> dic = new HashMap <String, Integer>();
		
		for(int i=0; i<first.length; i++) {
			dic.put(first[i], 0);
			dic.put(second[i], 0);
		}
		
		
		for(int i=0; i<first.length; i++) {
			dic.put(first[i], dic.get(first[i])+1);
			dic.put(second[i], dic.get(second[i])+1);
		}
		
		int ans = 0;
		
		for(String key : dic.keySet()) {
			ans = Math.max(ans, dic.get(key));
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String[] first = {"fishing", "gardening", "swimming", "fishing"};	
		String[] second = {"hunting", "fishing", "fishing", "biting"};
		System.out.println(bestInvitation(first, second));
	}
}
