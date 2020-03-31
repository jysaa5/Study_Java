package thread_ex;

public class MusicBox_s {

	//동기화
	public synchronized void playMusicA() {

		for (int i = 0; i < 10; i++) {
			System.out.println("신나는 음악!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	//동기화
	public synchronized void playMusicB() {

		for (int i = 0; i < 10; i++) {
			System.out.println("슬픈 음악!!");
			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	//동기화
	public synchronized void playMusicC() {

		for (int i = 0; i < 10; i++) {
			

			System.out.println("카페 음악!!");

			try {
				Thread.sleep((int) Math.random() * 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
