package chapter11.comparator.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
	
	public static void main(String[] args) {
		
		Student[] sArr = {
				new Student(100, "abc"),
				new Student(300, "aaa"),
				new Student(400, "ccc"),
				new Student(200, "bbb")
		};
		
		Arrays.sort(sArr);
		System.out.println(Arrays.toString(sArr));
		
		Arrays.sort(sArr, new NameAsccending());
		System.out.println(Arrays.toString(sArr));
	}

}


class NameAsccending implements Comparator{
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		//return s1.name.compareTo(s2.name);
		return s2.name.compareTo(s1.name); //반대로
	}
}


class Student implements Comparable{
	
	int score;
	String name;
	
	Student(int score, String name){
		this.score = score;
		this.name = name;
	}
	
	public int compareTo(Object obj) {
		Student s2 = (Student)obj;
		
		//return this.score - s2.score;
		
		return s2.score - this.score; // 반대로 정렬
		//return (this.score - s2.score)* -1; // 반대로 정렬
		
	}
	
	
	public String toString() {
		return score+","+name;
	}
	
}
