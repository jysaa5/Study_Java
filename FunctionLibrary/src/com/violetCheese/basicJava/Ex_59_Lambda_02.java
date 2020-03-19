package com.violetCheese.basicJava;

//람다식
public class Ex_59_Lambda_02 {

	public static void main(String[] args) {
		
		//람다식
		new Thread(()-> {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}
		}).start();

	}

}
