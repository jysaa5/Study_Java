package thread_ex;

//쓰레드 만들기(extend Thread)
//자바에서 Thread를 만드는 방법은 크게 Thread 클래스를 상속받는 방법과 Runnable인터페이스를 구현하는 방법이 있다.
public class MyThread_01 extends Thread {
	
	String str;
	
	//생성자
	public MyThread_01(String str) {
		this.str = str;
		
	}

	
	//수행 흐름이 하나 더 생겼을 때 흐름을 가지는 다른 메인 메서드 라고 생각하면 된다.
	@Override
	public void run() {

		super.run();
	
		for(int i=0; i<10; i++) {
			System.out.println(str);
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

	
	
	
	

}
