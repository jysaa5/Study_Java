package io_ex;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class TryWithResources_IO_02 {
	public static void main(String[] args) {

		try (
				// try의 뒤에나오는 괄호()사이에서 만든 stream은 별도로 close하지 않아도 됩니다.
				DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));) {
			// 이 아래에 out을 이용해서 data.txt에 int값 100, double값 3.14를 저장하세요.
			out.writeInt(100);
			out.writeDouble(3.14);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
