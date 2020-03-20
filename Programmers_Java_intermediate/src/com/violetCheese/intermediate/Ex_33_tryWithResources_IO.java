package com.violetCheese.intermediate;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Ex_33_tryWithResources_IO {
	public static int read3() {
		int sum = 0;
		// data.txt로부터 int값 3개를 읽어들여서 sum에 더하세요.
		try (DataInputStream di = new DataInputStream(new FileInputStream("data.txt"));

		) {

			int a = di.readInt();
			int b = di.readInt();
			int c = di.readInt();

			sum = a + b + c;

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 아래는 테스트를 위한 코드입니다. 수정하지 마세요.
		return sum;
	}

}
