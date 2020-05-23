package tree.binarySearchTree.alg.find.path_sol_2;

import java.util.ArrayList;

// 문제: 주어진 이진트리가 있다. 이진트리의 노드에는 정수값이 저장되어있다. (음의 정수 포함) 연결된 노드의 합산이 특정 숫자가 되는
// 경로의 개수를 찾으시오. 경로의 시작과 끝점은 어디든 될 수 있지만 언제나 위에서 아래로만 합산이 되어야 한다.

/*
 *      (4)
 *      /  \
 *     /    \
 *    /      \
 *   (1)     (7)
 *   / \    /  \
 * (0) (2) (5) (8)
 *       \   \   \
 *       (3) (6) (9)
 * 
 * -> 합: 6을 만드는 경로 = 1 + 2 + 3 , 6
 * -> 총 2개
 *
 *
 * <합산의 값이 5인 경우 찾기>
 *
 *       (4) 
 *      /   \
 *     /     \
 *    /       \
 *   (-2)      (2)  
 *   /  \     /   \
 * (1)  (8) (-1) (-3) 
 *        \    \     \
 *        (-4) (3)   (7) 
 *                     \
 *                     (-4)
 *          
 * 1. 루트부터 시작해서 배열방에 추가              
 * |4| | | | |
 * 
 * 2. 합이 5가 있는지 검색. 없으면 다음 노드를 추가해준다.
 * 
 * 3. 루트 왼쪽 값을 추가하고 앞에 노드에 더해준다.
 * |5|1| | | |
 * 
 * 3. 합이 5가 있는지 검색. 있다. 다음 노드를 추가해준다.
 * -> 찾은 경로의 수 = 1
 * 
 * 4. 노드 0을 추가한다. 앞에 노드들에게 더해준다. 합이 5가 있는지 검색.
 * |5|1|0| | |
 * -> 찾은 경로의 수 = 2
 * 
 * 5. 다은 노드가 없으므로 위로 올라가면서 반환한다. 마지막 노드를 삭제하고 삭제한 노드 값 만큼 앞에 노드값에서 뺀다.
 * |5|1| | | |
 * 
 * 6. 노드1의 오른쪽 노드의 2를 추가해주고 앞에 노드들에게 더한다. 합이 5가 있는지 검색.
 * |7|3|2| | |
 *  -> 찾은 경로의 수 = 2
 *  
 * 7. 다음 노드로 간다.노드 3을 추가해주고 앞에 노드들에게 더한다. 합이 5가 있는지 검색.
 * |10|6|5|3| |
 * -> 찾은 경로의 수 = 3
 * 
 * 8. 다음 노드가 없으므로 노드 3을 제거해주고 앞에 노드들에게서 노드3을 빼준다. 위로 올라가면서 반환.
 * |7|3|2| | |
 * -> 찾은 경로의 수 = 3
 * 
 * 9. 노드 2를 제거해주고 앞에 노드들에게서 노드 2를 빼준다.
 * |5|1| | | |
 * -> 찾은 경로의 수 = 3
 *
 * 10. 노드 1를 제거해주고 앞에 노드들에게서 노드 1를 빼준다.
 * |4| | | | |
 * -> 찾은 경로의 수 = 3
 * 
 * 11. 노드 4의 오른쪽 노드인 7노드를 추가해주고 앞에 노드들에게 노드 7을 더해준다. 합이 5가 있는지 검색.
 * |11|7| | | |
 * -> 찾은 경로의 수 = 3
 * 
 * 12. 노드 5를 추가해주고 앞에 노드들에게 노드 5를 더해준다. 합이 5가 있는지 검색
 * |16|12|5| | |
 * -> 찾은 경로의 수 = 4
 * 
 * 13. 노드 6을 추가해주고 앞에 노드들에게 노드 6을 더해준다. 합이 5가 있는지 검색
 * |22|18|11|6 | |
 * -> 찾은 경로의 수 = 4
 * 
 * 14. 다음 노드가 없으므로 위로 올라가면서 반환한다. 노드 6을 제거해주고 앞에 노드들에게 노드 6을 빼준다.
 * |16|12|5| | |
 * -> 찾은 경로의 수 = 4 
 * 
 * 15. 다음 노드가 없으므로 위로 올라가면서 반환한다. 노드 5를 제거해주고 앞에 노드들에게 노드 5를 빼준다.
 * |11|7| | | |
 * -> 찾은 경로의 수 = 4 
 * 
 * 16. 노드7의 오른쪽 노드인 노드 8로 간다. 노드 8을 추가하고 앞에 노드들에게 노드 8을 더해준다. 합이 5가 있는지 검색
 * |19|15|8| | |
 * -> 찾은 경로의 수 = 4 
 * 
 * 17. 다음 노드로 간다. 노드 9을 추가하고 앞에 노드들에게 노드 9을 더해준다. 합이 5가 있는지 검색
 * |28|24|17|9| |
 * -> 찾은 경로의 수 = 4 
 * 
 * 18. 다음 노드가 없으므로 위로 올라가면서 반환하면서 배열에 있는 값을 다 제거 해주고 찾은 경로의 수를 반환하고 종료한다.
 */

// 시간복잡도: O(nd)
// d: 트리의 깊이
// Solution 2: 추가 공간(배열)을 사용하여 풀이한다.

// Tree 클래스
class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		
		//생성자
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node root;
	
	//생성자
	Tree(int size){
		this.root = makeBST(0,size-1);
	}
	
	
	// makeBST: 이진 검색 트리를 만드는 메서드
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}// makeBST 메서드 종료
	
	
	// countPathsWithSum 메서드: 합산 값을 받으면 루트를 시작으로 경로를 탐색하는 재귀함수 호출
	int countPathsWithSum(int targetSum) {
		// 배열 선언
		ArrayList<Integer> array = new ArrayList<Integer>();
		// 재귀함수 호출
		return countPathsWithSum(root, targetSum, array);

	}// countPathsWithSum 메서드 종료
	
	// root: 처리할 노드, targetSum: 경로의 합산 값, array: 임시 저장소
	int countPathsWithSum(Node root, int targetSum, ArrayList<Integer> array) {
		
		// 트리 끝에 왔을 때.
		if(root == null) {
			return 0;
		}
		
		// 총 경로의 개수를 저장할 변수
		int totalPaths = 0;
		// 노드에 도착하면 배열방에 현재 노드의 값을 더해준다. 배열방 맨 끝에 새로운 시작점 추가
		addValue(array, root.data);
		
		// 배열방에서 찾고하는 합산 결과의 값을 검색한다.
		totalPaths = countPaths(array, targetSum);
		
		// 왼쪽
		totalPaths += countPathsWithSum(root.left, targetSum, array);
		
		// 오른쪽
		totalPaths += countPathsWithSum(root.right, targetSum, array);
		
		// 돌아와서 부모에게 경로의 개수 값을 반환하기 전에, 배열방에서 현재 값을 삭제하고 앞선 노드들에게서 빼주는 메서드 
		removeLast(array);
		
		return totalPaths;
		
	}// countPathsWithSum 메서드 종료
	
	// addValue 메서드: 배열방에서 현재 노드를 앞선 노드들에게 더해주고 맨끝에 현재 노드 추가.
	void addValue(ArrayList<Integer> array, int value) {
		
		for(int i=0; i<array.size(); i++) {
			array.set(i, array.get(i) + value);
		}
		
		array.add(value);
		
	}// addValue 메서드 종료
	
	
	// countPaths 메서드: 배열방을 돌면서 해당하는 경로 합산 값을 찾는 메서드
	int countPaths(ArrayList<Integer>array, int targetSum) {
		
		int totalPaths = 0;
		
		for(int i=0; i<array.size(); i++) {
			if(array.get(i) == targetSum) {
				totalPaths ++;
			}
		}
		return totalPaths;
		
	}// countPaths 메서드 종료
	
	
	// removeLast 메서드: 추가할 노드가 없으면 현재 노드를 배열방에서 삭제하고 앞선 노드들에게서 현재 노드 값을 빼준다.
	void removeLast(ArrayList<Integer>array) {
		
		int value = array.remove(array.size()-1);
		
		for(int i=0; i<array.size(); i++) {
			
			array.set(i, array.get(i)-value);
		}
		
	}// removeLast 메서드 종료
	
}// Tree 클래스 종료

/*
 *       (4)
 *      /  \
 *     /    \
 *    /      \
 *   (1)     (7)
 *   / \    /  \
 * (0) (2) (5) (8)
 *       \   \   \
 *       (3) (6) (9)
 *       
 * */
// BinarySearchTree_Find_Path_Sol_2 클래스
public class BinarySearchTree_Find_Path_Sol_2 {

	
	// main 메서드
	public static void main(String[] args) {
		
		Tree tree = new Tree(10);
		System.out.println(tree.countPathsWithSum(5));
		
		
	}// main 메서드 종료
	
	
}// BinarySearchTree_Find_Path_Sol_2 클래스 종료
