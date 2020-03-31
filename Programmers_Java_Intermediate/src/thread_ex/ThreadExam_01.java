package thread_ex;

public class ThreadExam_01 {

	//메인 스레드
	public static void main(String[] args) {
		MyThread_01 t1 = new MyThread_01("*");
		MyThread_01 t2 = new MyThread_01("-");
		
		//Thread동작시 run()이 아닌 start()메서드를 호출해야 한다.
		//스레드 2개
		t1.start();
		
		//스레드 3개
		//수행 흐름이 3개가 된다.
		t2.start();
		
		//메인이 종료가 되도 다른 스레드가 종료가 되야 완전히 끝난다.
		System.out.println("main end!!!");
	}

}
