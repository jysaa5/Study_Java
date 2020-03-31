package io_ex;

import java.io.DataInputStream;
import java.io.FileInputStream;

//data.dat로부터 값을 읽어들여 화면에 출력하는 클래스
//파일 쓴 것을 우리 눈으로 해석이 안되지만 InputStream을 사용하면 읽을 수 있다.
public class TryWithResources_IO_03 {

	public static void main(String[] args) {
		
		try (
				//데이터 읽기                                                             //파일로부터 읽기
				DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));) {

			// 저장된 순서로 읽어야 된다.
			int i = in.readInt();
			boolean b = in.readBoolean();
			double d = in.readDouble();

			System.out.println(i);
			System.out.println(b);
			System.out.println(d);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
