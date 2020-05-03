package io_ex;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Char_IO_03 {
	public static void main(String[] args) {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter("data.txt"));
			pw.println("안녕하세요.PrintWriter입니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			pw.close();
		}

		System.out.println("안녕하세요. PrintWriter입니다.");

	}
}
