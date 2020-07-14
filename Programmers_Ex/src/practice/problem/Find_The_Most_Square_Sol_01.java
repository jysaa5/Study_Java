package practice.problem;

// 문제: 가장 큰 정사각형 찾기
/*
문제 설명
1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. 
(단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 있다면 가장 큰 정사각형은

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

제한사항
표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.

입출력 예
board                                     |	answer
[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]] |	9
[[0,0,1,1],[1,1,1,1]]	                  | 4

입출력 예 설명
입출력 예 #1
위의 예시와 같습니다.

입출력 예 #2
| 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 |
로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.
*/
// 솔루션:


class Find_The_Most_Square_Solution_01{
    public int solution(int [][]board)
    {
    	// 우측하단부터 만들려고하는데, 길이가 1인경우에도 검사 될 수 있도록 크기가1더 큰 배열을 새로 만든다.
    			int[][] newBoard = new int[board.length+1][board[0].length+1];
    			
    			for ( int i = 0 ; i < board.length; i++ ) {
    				for ( int j = 0 ; j < board[0].length; j++ ) {
    					newBoard[i+1][j+1] = board[i][j];
    				}
    			}
    			
    			int max = 0;
    			
    			// 모든 board를 확인한다.
    			for ( int i = 1 ; i < newBoard.length; i ++ ) {
    				for ( int j = 1 ; j < newBoard[i].length; j++ ) {

    					// 2x2 사각형의 우측하단을 기준으로 정사각형이 되는 경우에는 변의 길이를 기록해간다.

    					// 우측하단이 기준인 이유는 마지막 좌표의 값을 구하기전에는 나머지 board들은 계산이 끝나야하기 때문이다.

    					// 변의 길이는 2x2 정사각형을 구성하는 변들의 최솟값이다.
    					if ( newBoard[i][j] >= 1 ) {
    						
    						//좌측
    						int left = newBoard[i-1][j];
    						//상단
    						int up = newBoard[i][j-1];
    						//좌측상단(대각선)
    						int leftDiagonal = newBoard[i-1][j-1];

    						int min = Math.min(left, up);
    						min = Math.min(min, leftDiagonal);

    						newBoard[i][j] = min+1;

    						max = Math.max(max, min+1);
    					}
    				}
    			}

    			return (int)Math.pow(max, 2);
    }
}

public class Find_The_Most_Square_Sol_01 {
	
	public static void main(String[] args) {
		Find_The_Most_Square_Solution_01 sol = new Find_The_Most_Square_Solution_01();
		
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		
		System.out.println(sol.solution(board));
		
		
	}

}
