package singleton.pattern;

public class SingletonPattern_main {

	public static void main(String[] args) {
		
		//생성자에 private 키워드가 있기 때문에 new를 통해 인스턴스를 생성할 수 없다.
		SingletonPattern_01 s1 = SingletonPattern_01.getInstance();
		SingletonPattern_01 s1_1 = SingletonPattern_01.getInstance();
		
		//com.violetCheese.designPattern.SingletonPattern_01@15db9742
		System.out.println(s1);
		//com.violetCheese.designPattern.SingletonPattern_01@15db9742
		System.out.println(s1_1);

		System.out.println("-----------------------------------------------------------");
		

		SingletonPattern_02 s2 = SingletonPattern_02.getInstance();
		SingletonPattern_02 s2_1 = SingletonPattern_02.getInstance();
		
		//com.violetCheese.designPattern.SingletonPattern_02@6d06d69c
		System.out.println(s2);
		//com.violetCheese.designPattern.SingletonPattern_02@6d06d69c
		System.out.println(s2_1);
		
		System.out.println("-----------------------------------------------------------");
		
		SingletonPattern_03 s3 = SingletonPattern_03.getInstance();
		SingletonPattern_03 s3_1 = SingletonPattern_03.getInstance();
		
		//com.violetCheese.designPattern.SingletonPattern_03@7852e922
		System.out.println(s3);
		//com.violetCheese.designPattern.SingletonPattern_03@7852e922
		System.out.println(s3_1);
		
		System.out.println("-----------------------------------------------------------");
		
		SingletonPattern_04 s4 = SingletonPattern_04.getInstance();
		SingletonPattern_04 s4_1 = SingletonPattern_04.getInstance();
		
		//com.violetCheese.designPattern.SingletonPattern_04@4e25154f
		System.out.println(s4);
		//com.violetCheese.designPattern.SingletonPattern_04@4e25154f
		System.out.println(s4_1);
		
		System.out.println("-----------------------------------------------------------");
		
		
		SingletonPattern_05 s5 = SingletonPattern_05.getInstance();
		SingletonPattern_05 s5_1 = SingletonPattern_05.getInstance();
		
		//com.violetCheese.designPattern.SingletonPattern_05@70dea4e
		System.out.println(s5);
		//com.violetCheese.designPattern.SingletonPattern_05@70dea4e
		System.out.println(s5_1);
		
		
	}//End of main

}//End of SingletonPattern_main
