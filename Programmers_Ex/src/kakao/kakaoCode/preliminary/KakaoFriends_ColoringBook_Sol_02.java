package kakao.kakaoCode.preliminary;

import java.util.ArrayList;
import java.util.Collections;

// 문제: 카카오프렌즈 컬러링북
/*
문제 설명
카카오 프렌즈 컬러링북
출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. 
(영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
alt text
위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.
입력 형식
입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 
제한조건은 아래와 같다.
1 <= m, n <= 100
picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
출력 형식
리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
예제 입출력
m |	n	| picture                                                                              |	answer
6 |	4	|[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]  |	[4, 5]
예제에 대한 설명
예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 
가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
*/


// 솔루션: BFS
/*
1. 영역: 상하좌우로 연결된 같은 색상의 공간 -> 현재 위치에서 상하 좌우로 움직일 수 있다. -> 그래프
2. 이차배열: 그래프로 풀어야 하는 단서를 준다.

*/

class KakaoFriends_ColoringBook_Solution_02{
	// 공간
	int span = 0;
	
	
	// m: 가로, n: 세로 
	// picture: 그림
	public int[] solution(int m, int n, int[][] picture) {
		
		// 영역의 개수
		int numberOfArea = 0;
		// 가장 큰 영역의 크기
		int maxSizeOfOneArea = 0;
		// 지나간 경로인지 아닌지 저장하는 배열
		boolean[][] pathBool = new boolean[m][n];
		
		// 공간영역을 저장하는 어레이 리스트
		ArrayList<Integer> answerList = new ArrayList<>();
		
		// 반환할 배열
		int[] answer = new int[2];
		
		
		// picture 크기 만큼 이중 for
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				
				// 이차 행렬에 값이 0보다 클때
				if(picture[i][j]>0) {
					
					findPath(i,j,picture,pathBool);
					
					// 공간이 0보다 클때.
					if(span > 0) {
						answerList.add(span);
						span = 0;
					}
					
				}
				
			}
			
		}

		// 공간 영역의 개수
		numberOfArea = answerList.size();
		
		// 영역의 개수가 0일 때.
		if(numberOfArea == 0) {
			return new int[] {0,0};
		}
		
		// 공간 영역을 내림차순으로 정렬
		Collections.sort(answerList, Collections.reverseOrder());
		maxSizeOfOneArea = answerList.get(0);
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		return answer;
		
	}
	
	
	// findPath: 경로를 찾는 메서드
	public void findPath(int m, int n, int[][] picture, boolean[][] pathBool) {
		
		// 이미 거쳐간 경로일 경우
		if(pathBool[m][n] == true) {
			return;
		}
		
		// 이미지의 값 = 영역의 숫자
		long su = picture[m][n];
		
		// 이차원 배열의 세로 길이(열)
		int column = picture[0].length;
		
		// 이차원 배열의 가로 길이(행)
		int row = picture.length;
		
		pathBool[m][n] = true;
		span ++;
		
		// 오른쪽 이동
		if((n+1 < column) && (pathBool[m][n+1] == false && su == picture[m][n+1])) {
			// 재귀함수 호출
			findPath(m, n+1, picture, pathBool);
		}
		
		
		// 왼쪽 이동
		if((n-1>=0)&& (pathBool[m][n-1] == false && su == picture[m][n-1])) {
			// 재귀함수 호출
			findPath(m, n-1, picture, pathBool);
			
		}
		
		
		// 위쪽으로 이동
		if((m-1>=0)&& (pathBool[m-1][n] == false && su == picture[m-1][n])) {
			// 재귀함수 호출
			findPath(m-1, n, picture, pathBool);
		}
		
		
		// 아래쪽 이동
		if((m+1<row)&&(pathBool[m+1][n]==false && su == picture[m+1][n])) {
			// 재귀함수 호출
			findPath(m+1, n, picture, pathBool);
		}
		
		
		
	}
	
}


public class KakaoFriends_ColoringBook_Sol_02 {
	
	public static void main(String[] args) {
		
		//int m = 4;
		int m = 6;
		int n = 4;
		
//		int[][] picture = {
//				{1,1,1,1},
//				{1,4,1,1},
//				{1,3,2,1},
//				{1,1,1,1}
//		};
		
		int[][] picture = {
				{1,1,1,0},
				{1,2,2,0},
				{1,0,0,1},
				{0,0,0,1},
				{0,0,0,3},
				{0,0,0,3}
		};
		
		KakaoFriends_ColoringBook_Solution_02 sol = new KakaoFriends_ColoringBook_Solution_02();
		
		int[] result = sol.solution(m, n, picture);
		
		for(int i : result ) {
			
			
			System.out.println(i);			
		}
		
	}
	
	

}
