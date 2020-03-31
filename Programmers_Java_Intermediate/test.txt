package io_ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Char_IO_02 {

	public static void main(String[] args) {

		// 한 줄씩 읽기
		BufferedReader br = null;

		// 출력 (쓰기)
		PrintWriter pw = null;

		try {
			// 파일에서 읽기
			// 경로: 현재 프로젝트가 기본 경로이다.
			// FileReader 예외 처리 필요
			br = new BufferedReader(new FileReader("src/io_ex/Char_IO_02.java"));

			// PrintWriter 자체가 파일을 받아들일수 있다. 그러므로 PrintWriter 한 개만 사용 가능.
			// 출력
			// println의 PrintWriter의 메서드
			pw = new PrintWriter(new FileWriter("test.txt"));

			// 파일 읽기
			// 한 줄 읽고 저장하기 위한 객체: line
			String line = null;
			// 파일의 끝이 되면 null이 된다.
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();

			// IO는 열면 닫아야 된다.
			// 반드시 처리해야할 로직을 finally 안에 쓴다.
		} finally {

			try {
				pw.close();
				br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
