package dynamicprograming.ex.robot;

import java.util.ArrayList;

/*
알고리즘: Dynamic Programming
문제: Robot In a Grid
A robot is sitting on the upper left corner of a grid. The robot can only move in two directions, right and down.
Certain cells are "off limits" such that the robot cannot step on them.
Design and algorithm to find a path for the robot from the top left to the bottom right.

= 그리드(바둑판 같은 것) 안에 로보트가 있는데, 맨 좌측 상단에 있다. 오른쪽과 아래쪽으로만 움직일 수 있다. (딱 2가지 방향만 가능)
어떤 칸은 로보트가 못 들어간다. 이 로봇이 좌측 상단에서 우측 하단까지 가는 경로를 찾는다.

 |로봇  |    |    |    |
 |    |    |    | x  |
 | x  | x  |    |    | 
 |    |    |    |goal|

-> x는 못 가는 칸이다. 
-> Goal에서부터 시작해서 로봇이 있는 곳 까지 가는 것을 찾으면 반환하면서 원래 찾는 답으로 출력 가능 할 수 있다.
-> 위, 왼쪽으로 움직이면 된다.
-> 최단 경로 X 
-> Goal을 시작으로 왼쪽을 먼저 쭉 가고 길이 없으면 위로 가고 만약 갈 수 없는 곳이면 못 가는 칸이라고 판단한다.
-> 로봇이 있는 곳을 찾으면 그 곳에서 경로를 Goal까지 경로를 출력하고 반환한다. 
*/

// 경로를 반환하려면, 각 경유하는 포인트들이 담긴 리스트을 만들어야 한다.
// Point 클래스
class Point{
	
	// x, y 포인트
	int row, col;
	
	// 생성자 
	Point(int row, int col){
		this.row = row;
		this.col = col;
	}
	
}// Point 클래스 종료

// Solution 클래스
class Solution{
	// grid false = 아무 것도 없는 칸
	// grid true = blocked
	public ArrayList<Point> findPath(boolean[][] grid){
		
		if(grid == null || grid.length == 0) {
			return null;
		}
		
		// 경로 저장
		ArrayList<Point>path = new ArrayList<Point>();
		
		// 재귀함수 호출
		if(findPath(grid, grid.length-1, grid[0].length-1, path)) {
			return path;
		}else {
			return null;
		}
	
	}// findPath 메서드 종료
	
	
	// findPath 메서드: 재귀함수 -> grid, 현재 위치, 저장할 경로
	private boolean findPath(boolean[][]grid, int row, int col, ArrayList<Point>path) {
		
		// 해당 포인트가 grid 안에 없거나 blocked 되어 있는 좌표일 경우
		if(!isInRange(grid,row,col)|| grid [row][col]) {
			return false;
		}
		
		// 최종 목적지에서 로봇이 있는 곳으로 경로 찾기
		// 위쪽, 왼쪽으로 가는 경우를 한 가지로 쭉 찾고 그다음 방향으로 쭉 찾기
		if((row == 0 && col ==0) || findPath(grid, row, col-1, path)|| findPath(grid, row-1, col,path)) {
			Point p = new Point(row, col);
			// path 추가
			path.add(p);
			return true;
		}
		return false;
	}
	
	// isInRange 메서드: 그리드 안에 포인트가 있는 가를 체크하는 메서드
	private boolean isInRange(boolean[][] grid, int row, int col) {
		return row >= 0 && row <= grid.length -1 && col >= 0 && col <= grid[row].length - 1;
	}
	
}// Solution 클래스 종료


// Robot_In_a_Grid 클래스
public class Robot_In_a_Grid {
	
	// main 메서드
	public static void main(String[] args) {
	
		// 그리드
		boolean[][] grid = {
				{false, false, false, false},
				{false, false, false, true},
				{true, true, false, false},
				{false, false, false, false}
		};
		
		Solution sol = new Solution();
		
		ArrayList<Point> path = sol.findPath(grid);
		
		if(path != null) {
			for(Point p:path) {
				System.out.print(p.row+""+p.col+"->");
			}
		}
		
	}// main 메서드 종료

}// Robot_In_a_Grid 클래스 종료 