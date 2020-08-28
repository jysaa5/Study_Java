package chapter05;

import java.util.ArrayList;

// p.107
// 문제: 재밌는 수학
// 솔루션: 다중 for문 사용, 배열 사용
public class Funny_Mathematics_Sol_01 {
	public static int[] digits(int base) {
		ArrayList<Integer> v = new ArrayList<Integer>();

		for (int n = 2; n < base; n++) {

			boolean ok = true;

			for (int k1 = 0; k1 < base; k1++) {

				for (int k2 = 0; k2 < base; k2++) {

					for (int k3 = 0; k3 < base; k3++) {

						if ((k1 + k2 * base + k3 * base * base) % n == 0 && (k1 + k2 + k3) % n != 0) {
							// n의 배수가 숫자로 각각 숫자의 합이 n의 배수가 아니면 n을 제외한다.
							ok = false;
							break;
						}
					}
					if (!ok) {
						break;
					}
				}
				if (!ok) {
					break;
				}
			}
			if (ok) {
				v.add(n);
			}
		}

		int[] ans = new int[v.size()];
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i);
		}

		return ans;
	}

	public static void main(String[] args) {
		//int base = 10;
		//int base = 3;
		//int base = 9;
		//int base = 26;
		int base = 30;
		
		for (int i : digits(base)) {
			System.out.println(i);
		}
	}
}
