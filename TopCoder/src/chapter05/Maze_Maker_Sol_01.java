package chapter05;

// p.169
// 문제: 미로 만드는 사람

import java.util.*;

class MazeMaker{
	
	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		
		int max = 0; 
		
		// 가로로 몇 칸 있는지
		int width = maze[0].length();
		// 세로로 몇 칸 있는지 
		int height = maze.length;
		
		// 짐이 이동하는 경로 위치까지 이동한 거리의 값을 가지고 있음.
		int[][] board = new int[height][width];
		
		// 초기화
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				board[i][j] = -1;
			}
		}
		
		// 시작점
		board[startRow][startCol] = 0;
		
		//너비 우선 탐색
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();
		queueX.add(startCol);
		queueY.add(startRow);
		
		while(!queueX.isEmpty()) {
			
			int x = queueX.poll();
			int y = queueY.poll();
			
			for(int i=0; i<moveRow.length; i++) {
				int nextX = x+moveCol[i];
				int nextY = y+moveRow[i];
				
				if(0 <= nextX && nextX <width && 0<=nextY && nextY <height && board[nextY][nextX]==-1 && maze[nextY].charAt(nextX)=='.') {
					board[nextY][nextX] = board[y][x]+1;
					
					queueX.add(nextX);
					queueY.add(nextY);
				}
				
			}
			
		}
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(maze[i].charAt(j) == '.' && board[i][j] == -1) {
					return -1;
				}
				
				// 마이크가 출구를 멀리 해놓았을 테니, 출구에서부터 가장 멀리 이동한 경로를 찾는다.
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
}

public class Maze_Maker_Sol_01 {
	
	public static void main(String[] args) {
		MazeMaker sol = new MazeMaker();
		String[] maze = {"...", "...", "..."};
		int startRow = 0;
		int startCol = 1;
		int[] moveRow = {1, 0, -1, 0};
		int[] moveCol = {0, 1, 0, -1};
		
		System.out.println(sol.longestPath(maze, startRow, startCol, moveRow, moveCol));
	}

}
