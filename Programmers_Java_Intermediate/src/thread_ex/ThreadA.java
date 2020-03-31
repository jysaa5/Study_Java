package thread_ex;

public class ThreadA {

	//메인 스레드
	public static void main(String[] args) {
		ThreadB b = new ThreadB();

		//b 스레드 시작
		b.start();

		synchronized (b) {
			try {
				System.out.println("b가 완료될때까지 기다립니다.");
				//메인을 멈추게 한다.
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Total is :" +b.total);
		}

	}

}
