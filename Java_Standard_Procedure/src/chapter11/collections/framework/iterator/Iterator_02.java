package chapter11.collections.framework.iterator;

// p.616
import java.util.*;
public class Iterator_02 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
	}
}
