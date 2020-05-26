package summer.winter.coding;

//수학적 사고력 문제
//정해진 규칙을 찾는 문제
public class Fine_Rectangle {

	public static long solution(long w, long h) {

		// 종이의 가로
		long width = w;

		// 종이의 세로
		long height = h;

		// 가로와 세로 중에 작은 값 넣을 변수
		long num_small = 0;
		// 반복문에서 사용
		long i = 0;
		// 최대공약수
		long gcd = 0;
		// 반환값
		long answer;

		// 가로와 세로중에서 작은 값 찾기
		if (width > height) {
			num_small = height;
		} else {
			num_small = width;
		}

		// i 값으로 나누면서 최대 공약수 찾기
		for (i = num_small; i > 0; i--) {
			if ((width % i == 0) && (height % i == 0)) {
				gcd = i;
				break;
			}
		}

		// 완전한 정사각형 = 전체 정사각형 - (불완전한 사각형)
		answer = (width * height) - (width + height - gcd);

		return answer;

	}

	// test
	public static void main(String[] args) {
		System.out.print(solution(8, 12));
	}

}
