package com.violetCheese.intermediate;

public class Ex_43_ThreadExam_02 {

	//메인 스레드
	public static void main(String[] args) {
		Ex_42_MyThread_02 t1 = new Ex_42_MyThread_02("*");
		Ex_42_MyThread_02 t2 = new Ex_42_MyThread_02("-");
		
		//Thread의 생성자중에서 Runnable을 받을 수 있게 되어 있다.
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("main end!!!");
		
	}

}
