package chapter11.collections.framework.arrayList;

import java.util.ArrayList;
import java.util.List;

// p.587
public class ArrayList_02 {
	
	public static void main(String[] args) {
		
		// 자르고자 하는 글자의 개수를 지정한다.
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		// 크기를 약간 여유 있게 잡는다.
		List list = new ArrayList(length/LIMIT+10);
		
		for(int i=0; i<length; i+=LIMIT) {
			if(i+LIMIT<length) {
				list.add(source.substring(i, i+LIMIT));
			}else {
				list.add(source.substring(i));
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}//main()

}
