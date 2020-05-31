package summer.winter.coding;

// 문제: 멀쩡한 사각형
/*
가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

제한사항
W, H : 1억 이하의 자연수

입출력 예
W |	H  | result
8 |	12 | 80
*/
// 수학적 사고력 문제
// 정해진 규칙을 찾는 문제
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
