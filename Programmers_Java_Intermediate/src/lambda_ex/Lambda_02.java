package lambda_ex;

//람다식
public class Lambda_02 {

	public static void main(String[] args) {
		
		//람다식
		new Thread(()-> {
				for (int i = 0; i < 10; i++) {
					System.out.println("hello");
				}
		}).start();

	}

}
