package chapter05;

import java.util.Arrays;

// p. 99
// 문제: 암호
// 솔루션: for문, Array.sort 사용

public class Cryptography_Sol_02 {

	public static long encrypt(int[] numbers) {
		long ret = 1;
		Arrays.sort(numbers);
		numbers[0]++;
		for (int i = 0; i < numbers.length; i++) {
			ret *= numbers[i];
		}

		return ret;
	}

	public static void main(String[] args) {
		// int[] numbers = {1, 2, 3};
		// int[] numbers = {1, 3, 2, 1, 1, 3};
		// int[] numbers = {1000, 999, 998, 997, 996, 995};
		int[] numbers = { 1, 1, 1, 1 };

		System.out.println(encrypt(numbers));
	}

}
