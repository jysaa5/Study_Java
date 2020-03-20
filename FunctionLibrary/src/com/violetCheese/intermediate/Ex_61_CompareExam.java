package com.violetCheese.intermediate;

public class Ex_61_CompareExam {

	public static void exec(Ex_60_Compare compare) {
		int k = 10;
		int m = 20;
		int value = compare.compareTo(k, m);
		System.out.print(value);
	}

	public static void main(String[] args) {

		exec((i, j) -> {
			return i - j;
		});

	}

}
