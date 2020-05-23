package tree.binarySearchTree.alg.find.path_sol_1;


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
 * <가정: 루트 4에서부터 합산으로 6이 되는 경로 찾기>
 *
 *       (4) -> 4
 *      /   \
 *     /     \
 *    /       \
 *   (-2)      (2)   -> 2, 6(찾음: 1을 위로 반환)
 *   /  \     /   \
 * (1)  (8) (-1) (-3)  -> 3, 10, 5, 3
 *        \    \     \
 *        (-4) (3)   (7) -> 6(찾음: 1을 위로 반환), 8, 10
 *                     \
 *                     (-4) -> 6
 * -> 합을 못 찾으면 위로 0을 반환
 * -> 경로의 개수: 3개 
 * -> 루트에서 전체를 돌면 O(n) 이고 왼쪽 노드에서는 왼쪽노드의 서브 트리만 확인하므로 O(nlogn)이다. 
 * -> 한 쪽만 길게 되어 있는 트리일 경우 최악의 시간복잡도로 O(n^2) 이다.
 */
// 각 노드에서 하위 트리에서만 값을 합산한다. 
// 시간복잡도: 최소 = O(n log n), 최악 = O (n^2)

// Solution 1: 각 노드의 하위 트리를 돌면서 경로의 합산을 찾는다.

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
		
		return countPathsWithSum(root, targetSum);

	}// countPathsWithSum 메서드 종료
	
	
	int countPathsWithSum(Node root, int targetSum) {
		
		if(root == null){
			return 0;
		}
		
		// 현재노드를 기점으로 경로의 개수를 세는 함수를 호출
		int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
		// 왼쪽
		int pathsOnLeft = countPathsWithSum(root.left, targetSum);
		// 오른쪽
		int pathsOnRight = countPathsWithSum(root.right, targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}// countPathsWithSum 메서드 종료
	
	
	// countPathsWithSumFromNode 메서드: 특정 노드를 시작점으로 경로의 개수를 찾는 메서드
	int countPathsWithSumFromNode(Node node, int targetSum, int currSum) {
		
		if(node == null) {
			return 0;
		}
		
		currSum += node.data;
		int totalPaths = 0;
		if(currSum == targetSum) {
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, targetSum, currSum);
		totalPaths += countPathsWithSumFromNode(node.right, targetSum, currSum);
		
		return totalPaths;
		
	}// countPathsWithSumFromNode 메서드 종료
	
	
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
// BinarySearchTree_Find_Path_Sol_1 클래스
public class BinarySearchTree_Find_Path_Sol_1 {

	
	// main 메서드
	public static void main(String[] args) {
		
		Tree tree = new Tree(10);
		System.out.println(tree.countPathsWithSum(3));
		
		
	}// main 메서드 종료
	
	
}// BinarySearchTree_Find_Path_Sol_1 클래스 종료
