package tree.binaryTree.alg.balance;

// 문제: 주어진 이진 트리의 Balance가 맞는지 확인하는 함수를 구현하시오.
// (여기서 Balance가 맞다는 의미는 어떤 노드의 양쪽 서브 트리의 길이가 1초과 차이가 나지 않는 것을 뜻함)

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
 *-> Balance가 맞다. 길이가 다른 서브 트리가 있지만 1이상 차이가 나지 않는다.
 * */

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
 *                 \
 *                (10)
 *           
 *-> Balance가 맞지 않다. 8에서 보면 양쪽 Child가 0과 2이므로.               
 * */          

/*
 *       (4)
 *      /   \
 *     /     \
 *    /       \
 *   (1)       (7)
 *   / \     /     \
 * (0) (2)  (5)    (8)
 *       \    \   /    \
 *       (3) (6) (11) (9)
 *                      \
 *                      (10)
 *           
 *-> Balance가 맞다. 양쪽 노드의 가장 긴 줄기를 보고 Balance를 판단할때, 2의 Child와 8의 Child는 1개 차이만 난다.      
 * */       

// Solution: 노드들 하나씩 돌면서 자식 노드를 재귀 호출하고, 서브 트리의 길이를 측정하는 함수를 만들어서 양쪽 서브 
// 트리의 길이를 비교하다가 두 개의 서브 트리 길이가 1초과가 발생하면 false를 반환한다.
// 시간 복잡도: O(n log n)
class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		
		// 생성자
		Node(int data){
			this.data = data;
		}
	}
	
	Node root;
	
	// 생성자
	Tree(int size){
		root = makeBST(0, size-1);
		// unbalanced 만들기
		root.right.right.right.right = new Node(10);
	}
	
	// 이진트리를 만드는 메서드
	Node makeBST(int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid + 1, end);
		return node;
		
	}//makeBST 메서드 종료

	
	// isBalanced 메서드
	// 노드의 주소를 인자로 받는다.
	boolean isBalanced(Node root) {
	
		// 마지막 노드를 만나면 true를 반환
		if(root == null) {
			return true;
		}
		
		// 서브 트리 길이 차이 비교
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		// 1초과 차이가 날때
		if(Math.abs(heightDiff)>1) {
			return false;
		
		}else {
		
			// 왼쪽과 오른쪽이 모두 balanced 일 때 true 반환
			return isBalanced(root.left) && isBalanced(root.right);
		
		}
		
	}// isBalanced 메서드 종료
	
	
	// getHeight 메서드 
	// 노드의 주소를 인자로 받는다.
	int getHeight(Node root) {
		
		// 마지막 노드를 만날 때.
		if(root == null) {
			return -1;
		}
		
		// 반환할 때마다 1을 더한다.
		return Math.max(getHeight(root.left), getHeight(root.right)) +1;
	}// getHeight 메서드 종료
	
	

}


// Tree_Balance_Imp 클래스
public class BinaryTree_alg_Balance_Imp {
	
	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		// balanced 한 경우
		System.out.println(t.isBalanced(t.root));
		
		
	}// main 메서드 종료

}// Tree_Balance_Imp 클래스 종료