package com.violetCheese.basicJava;

public class Ex_47_MusicBox {

	public void playMusicA() {

		for (int i = 0; i < 10; i++) {
			System.out.println("½Å³ª´Â À½¾Ç!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void playMusicB() {

		for (int i = 0; i < 10; i++) {
			System.out.println("½½ÇÂ À½¾Ç!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void playMusicC() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Ä«Æä À½¾Ç!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
