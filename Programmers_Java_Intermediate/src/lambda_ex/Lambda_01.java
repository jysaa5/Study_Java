package lambda_ex;

//恩促侥
public class Lambda_01 {

	public static void main(String[] args) {

		//Runnable 积己
		//Thread 积己
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}

			}

		}).start();

	}

}
