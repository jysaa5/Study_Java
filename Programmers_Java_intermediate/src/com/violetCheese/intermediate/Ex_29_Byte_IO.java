package com.violetCheese.intermediate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Byte 단위 입출력
//파일로 부터 512byte씩 읽어들여 파일에 512byte씩 저장하는 프로그램을 작성
public class Ex_29_Byte_IO {

	public static void main(String[] args) {
		
		//실행시간 체크
		long startTime = System.currentTimeMillis();

		// 파일을 읽는 객체
		FileInputStream fis = null;
		// 파일에 쓸수 있는 객체
		FileOutputStream fos = null;

		try {
			// 읽어드릴 파일 경로를 쓰면 된다. 지금 프로젝트 기준
			// 파일이 없을 때의 notfoundException이 생김. 이외의 예외도 발생할 수 있음.
			fis = new FileInputStream("src/com/violetCheese/basicJava/Ex_27_Byte_01.java");

			// 파일을 쓸 위치를 넣는다. 경로를 넣지 않으면 현재 프로젝트 경로에 생긴다.
			fos = new FileOutputStream("byte.txt");

			// 읽어들였을 때 넣을 변수
			int readCount = -1;

			// 512바이트 만큼 읽기 위해서 배열 선언
			// 수행시간이 짧아짐.
			byte[] buffer = new byte[512];

			// read() 한 바이트씩 읽어서 정수를 반환 = 4byte중에서 마지막 바이트 저장한다.
			// 읽을 데이터가 있으면 양수 반환
			// 512바이트를 읽어들이기위해 buffer 배열을 넣는다.
			// 마지막에 파일을 다 읽으면 -1을 반환한다.
			while ((readCount = fis.read(buffer)) != -1) {
				// 파일에 쓴다.
				// buffer: 버퍼에 해당하는 것을 쓴다.
				// readCount: 0부터 읽어들인 수만큼 쓴다.
				fos.write(buffer, 0, readCount);
			}

		} catch (Exception e) {

			e.printStackTrace();

			// IO는 반드시 닫아야 된다.
		} finally {

			try {
				// IOException 예외를 일으킨다.
				fos.close();

			} catch (IOException e) {

				e.printStackTrace();

			}
			try {
				// IOException 예외를 일으킨다.
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
