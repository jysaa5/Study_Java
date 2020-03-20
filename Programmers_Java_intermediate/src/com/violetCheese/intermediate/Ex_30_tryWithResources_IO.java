package com.violetCheese.intermediate;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

//try-with-resources 블럭 선언: 자동 close() 
public class Ex_30_tryWithResources_IO {

	public static void main(String[] args) {

		try (
		//IO 객체 선언
		//DataOutputStream: 다양한 타입을 저장할 수 있는 객체
		//OutputStream을 받아들인다.
		DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));
		) {
			
			//4byte 정수 저장
			out.writeInt(100);
			//1byte 불린 저장
			out.writeBoolean(true);
			//8byte 더블 저장
			out.writeDouble(50.5);

		} catch (Exception e) {

		}

	}

}
