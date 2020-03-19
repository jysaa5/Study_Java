package com.violetCheese.basicJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Char 단위 입출력(Console)
public class Ex_34_Char_IO {

	public static void main(String[] args) {

		// BufferedReader: 한 줄씩 입력 받기
		// 입력을 받을 부분 키보드: System.in
		// Reader로 바꿔주는 부분: InputStreamReader
		// Decorator Pattern: 데코레이터 패턴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		try {

			// 예외가 발생함
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(line);

	}

}
