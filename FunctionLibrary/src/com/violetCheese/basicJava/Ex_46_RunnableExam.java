package com.violetCheese.basicJava;

public class Ex_46_RunnableExam {

	public static void main(String[] argv) {
		Ex_45_Bus bus = new Ex_45_Bus();
		/*
		 * Runnable을 구현한 클래스를 이용해 쓰레드를 이용할때는 아래와 같이 Thread의 생성자에 해당 객체(bus)를 전달하면 됩니다.
		 * 하지만 이대로 실행하면 에러가 발생합니다. bus가 runnable을 implements하고 있지 않기 때문입니다.
		 */
		Thread busThread = new Thread(bus);
		busThread.start();
	}

}
