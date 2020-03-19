package com.violetCheese.basicJava;

public class Ex_53_MyThread extends Thread {

	@Override
	public void run() {
		
		for(int i=0; i< 5; i++) {
			System.out.println("MyThread: "+i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
