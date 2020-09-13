package matrix.change.zeroToOne;

// 문제: (Matrix) 2차원 배열 안에서 0을 발견하면 해당 행과 열을 모두 0으로 세킹하는 알고리즘
/* 
 * |1|1|1|1|      |1|1|0|1|
 * |1|1|1|1|  ->  |1|1|0|1| 
 * |1|1|0|1|      |0|0|0|0|
 * |1|1|1|1|      |1|1|0|1|
 * 
 * 1. 0을 찾는다.
 * 2. 0으로 세팅될 공간에 0으로 표시될 부분을 0으로 표시한다.
 * 3. 정보를 표시해둔 열을 제외하고 행과 열을 0으로 세팅한다.
 * 4. 정보를 갖고 있는 열의 행을 0으로 세팅한다.
 * 5. 정보를 갖고 있던 열도 0으로 세팅한다.
 * 
 * -> 별도의 저장공간을 사용하지 않는다.
 * 
 * */

// Change_Matrix_Zero_to_One 클래스
public class Change_Matrix_Zero_to_One {

	
	// setZeroToAllZero 메서드
	private static void setZeroToAllZero(int[][] matrix) {
		// 0 이 들어가 있는 위치를 저장하는 변수, 행과 열
		int fc = -1;
		int fr = -1;
		
		// 행 단위 반복
		for(int row = 0; row < matrix.length; row++) {
			//열 단위 반복
			for(int col = 0; col < matrix[row].length; col++) {
				
				// 매트리스에서 0을 찾았을 때
				if(matrix[row][col] == 0) {
				
					// 처음에 찾은 0일 때
					if(fc == -1) {
					
						fc = col;
						fr = row;
				}
					
					//해당 열과 행을 0으로 표시한다.
					matrix[fr][col] = 0;
					matrix[row][fc] = 0;
				
				}
			}
			
		}
		// 0을 하나도 못 찾았을 때.
		if(fc == -1) {
			return;
		}
		
		// 열을 돌면서 0으로 세팅한다.
		for(int col = 0; col < matrix[0].length; col++) {
			
			// 정보가 들어있는 열만 빼고 0으로 세팅한다.
			if(matrix[fr][col] == 0 && col != fc) {
				setColsToZero(col, matrix);
			}
			
		}
		
		// 행을 돌면서 0으로 세팅한다.
		for(int row = 0; row < matrix.length; row++) {
			if(matrix[row][fc] == 0) {
				setRowsToZero(row, matrix);
			}
		}
		
		// 정보가 있던 열도 0으로 세팅한다.
		setColsToZero(fc,matrix);
		
	}// setZeroToAllZero 메서드 종료
	
	
	// setColsToZero 메서드
	private static void setColsToZero(int col, int[][] matrix) {
		
		for(int row = 0; row < matrix.length; row++) {
			matrix[row][col] = 0;
		}
		
	}// setColsToZero 메서드 종료
	
	
	// setRowsToZero 메서드
	private static void setRowsToZero(int row, int[][] matrix) {
	
		for(int col = 0; col<matrix[row].length; col++) {
			matrix[row][col] = 0;
		}
		
		
	}// setRowsToZero 메서드 종료
	
	

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
		
		int[][] matrix = {
				{1, 1, 1, 1},
				{1, 0, 1, 1},
				{1, 1, 1, 0},
				{1, 0, 1, 1}
		};
		
		printImage(matrix);
		setZeroToAllZero(matrix);
		printImage(matrix);
		
	}// main 메서드 종료
	
	
	
}// Change_Matrix_Zero_to_One 클래스
