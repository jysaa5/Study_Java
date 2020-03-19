package com.violetCheese.basicJava;

public class Ex_57_Daemon implements Runnable {

	@Override
	public void run() {

		while (true) {
			System.out.println("데몬 쓰레드가 실행중입니다.");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

	}

	// 메인도 스레드이다.
	public static void main(String[] args) {
		Thread thread = new Thread(new Ex_57_Daemon());
		// 데몬 스레드로 설정됨.
		thread.setDaemon(true);
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("메인 스레드가 종료됩니다.");

	}

}
