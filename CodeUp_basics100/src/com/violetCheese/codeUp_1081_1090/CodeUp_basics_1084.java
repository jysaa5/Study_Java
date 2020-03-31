package com.violetCheese.codeUp_1081_1090;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CodeUp_basics_1084 {

	// 메인 메서드
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		int r = s.nextInt();
		int g = s.nextInt();
		int b = s.nextInt();

		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < g; j++) {
				for (int k = 0; k < b; k++) {

					String st = i + " " + j + " " + k;
					bf.write(st + "\n");
					//원래는 flush를 해줘야 되는데 시간초과가 자꾸 걸려서 체점이 안됨.
					//bf.flush();
				}
			}
		}
		bf.write(Integer.toString(r * g * b));
		bf.close();
		s.close();
		
	}// 메인 메서드

}// CodeUp_basics_1084 클래스 끝
