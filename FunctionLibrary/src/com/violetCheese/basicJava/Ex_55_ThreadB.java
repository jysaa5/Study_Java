package com.violetCheese.basicJava;

public class Ex_55_ThreadB extends Thread {

	// 누적
	int total;

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(i + "를 더합니다.");
				total += i;

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			//wait() 하고 있는 메서드를 깨운다.
			notify();
		}

	}

}
