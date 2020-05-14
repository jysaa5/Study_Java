package matrix.alg.rotate.image;

// 문제: 2차원 배열에 관한 알고리즘(Matrix)
// 가로, 세로 = N pixel, N pixel -> 2차원 배열에 저장되어 있다.
// N * N 픽셀 이미지가 2차원 배열에 저장되어 있다.
/*     
 *  _ _ _ _ 
 * |_|_|_|_|
 * |_|_|_|_|
 * |_|_|_|_|
 * |_|_|_|_|
 * 
 * */
// Rotate 90 degree = 이미지를 90도 회전한다.
// In place = 별도의 자료 구조을 사용하지 않는다. 

// 문제를 간단하게 만들기 위해서 Layer 단위대로 한다.
// 맨 바깥에 한 줄씩 안쪽 방향으로 Layer로 구분한다.

//
/* 1 = 파란색, 2 = 초록색, 3 = 노란색, 4 = 빨간색
 *  _ _ _ _           _ _ _ _ 
 * |1|1|1|2|         |4|4|4|1|
 * |4|_|_|2|   < -   |3|_|_|1| 
 * |4|_|_|2|         |3|_|_|1|
 * |4|3|3|3|         |3|2|2|2|
 * 
 * 4개의 배열 데이터를 서로 스왑 해주면 하나의 레이어가 회전이 된다.
 * 1. 변수를 한 개 선언한다.
 * 2. 선언한 변수에 빨간배열의 (맨 앞에 배열)첫번째 배열을 넣는다.
 * 3. 빈 자리에 파란방 첫번째 배열을 옮긴다.
 * 4. 파란방 첫번째 배열이 있던 곳에 초록색 방의 첫번째 배열을 넣는다.
 * 5. 초록색방 첫번째 배열이 있던 곳에 노란색 방의 첫번째 배열을 넣는다.
 * 6. 임시 변수에 넣었던 빨간 배열을 비어 있는 노란색 방의 첫번째 배열이 있던 곳에 넣는다.
 * 7. 빨간배열 2번째 방도 2~6번 반복한다.
 * 8. 빨간 배열 3번째 방도 2~6번 반복한다.
 * 
 * |00|01|02|03|04|
 * |10|11|12|13|14|
 * |20|21|22|23|24|
 * |30|31|32|33|34|
 * |40|41|42|43|44|
 * 
 * tmp = 00
 * 00 = 04
 * 04 = 44
 * 44 = 40
 * 40 = tmp
 * -> 이런식으로 n-1 번 실행하면 된다.
 * 
 * tmp = 11
 * 11 = 13
 * 13 = 33
 * 33 = 31
 * 31 = tmp
 * 
 * 첫번째 layer: s(시작) = 0, e(끝) = 4
 * 두번째 layer: s(시작) = 1, e(끝) = 3
 * 레이어가 안쪽으로 들어올때마다, s(시작점)++ = 시작점은 증가한다. e(끝점)-- = 끝점은 감소한다.
 * 
 * layer에 들어오면, 시작점부터 끝점까지 루프를 돌린다. 
 * s = 1, e = 3
 * Loop: 
 * i = s to i = e
 * i = 1, 2, 3 (11, 12, 13 / 11, 21, 31 / 13, 23, 33 일 때)
 * j = e to j = s (31, 32, 33 일 때)
 * j = 3, 2, 1 
 * 
 * 두 번째 layer 맨 위에 있는 것: Top[s][i] -> (11, 12, 13)
 * 두 번째 layer 맨 오른쪽에 있는 것: Right[i][e] -> (13, 23, 33)
 * 두 번째 layer 맨 밑에 있는 것: Bottom[e][j] -> (33, 32, 31)
 * 두 번째 layer 맨 왼쪽에 있는 것: Left[j][s] -> (31, 21, 11)
 * 
 * tmp = Top
 * Top = Right
 * Right = Bottom
 * Bottom = Left
 * Left = tmp
 * 
 * tmp = [s][i]
 * [s][i] = [i][e]
 * [i][e] = [e][j]
 * [e][j] = [j][s]
 * [j][s] = tmp
 * 
 * 첫번째, 두번째 layer의 규칙을 종합해보면,
 * 
 * Loop: s = 0, e = 4
 * s++, e--
 * Loop: i = s -> e
 *       j = e -> s
 * 
 * tmp = [s][i]
 * [s][i] = [i][e]
 * [i][e] = [e][j]
 * [e][j] = [j][s]
 * [j][s] = tmp
 * 
 * 
 * -> swapping한다.
 * 
 * */

// Rotate_Matrix_Image 클래스
public class Rotate_Matrix_Image {
	
	
	// roateImage 메서드: 이미지 회전하는 메서드 
	private static int[][] rotateImage(int[][] image){
		
		int tmp;
		
		for(int s = 0, e = image.length-1; s<e; s++, e--) {
			for(int i=s, j=e; i<e; i++, j--) {
				tmp = image[s][i];
				image[s][i] = image[i][e];
				image[i][e] = image[e][j];
				image[e][j] = image[j][s];
				image[j][s] = tmp;
			}
		}
		
		return image;
		
	}// rotateImage 메서드 종료
	
	
	// printImage 메서드: 이미지 회전 출력
	private static void printImage(int[][] image) {
		
		//행 * 열
		for(int i=0; i<image.length; i++) {
			
			for(int j=0; j<image[i].length; j++) {
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}// printImage 메서드 종료
	
	// main 메서드 
	public static void main(String[] args) {
		
		int[][] image = {
				{1, 0, 0, 0, 1},
				{0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0}
		};
		
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		rotateImage(image);
		printImage(image);	
		
	}// main 메서드 종료
	
}// Rotate_Matrix_Image 클래스
