package tree.binarySearchTree.alg.balance_sol_3;

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

// Solution 3 : 어떤 서브 트리든 1초과가 나지 않도록 만든다. Object로 저장해서 맨 아래의 마지막 노드에 길이를 
// 저장한다.
// 시간 복잡도: O(n)

// Tree 클래스
class Tree{
	// Node 클래스
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
		root.right.right.left = new Node(11);
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
		
		// 제일 맨 마지막 노드가 지났을 때, 레벨에서 1을 뺀다.
		if(root == null) {
			return -1;
		}
		
		// 반환할 때마다 1을 더한다.
		return Math.max(getHeight(root.left), getHeight(root.right)) +1;
	}// getHeight 메서드 종료
	
	
	// checkHeight 메서드: solution2 를 사용하여, 길이를 체크하는 메서드
		int checkHeight(Node root) {
			
			// 제일 맨 마지막 노드가 지났을 때, 레벨에서 1을 뺀다.
			if(root == null) {
				
				return -1;
			
			}
			
			// 왼쪽 노드들의 서브 트리 길이를 젠다.
			int leftHeight = checkHeight(root.left);
			
			// 길이를 비교했을 때, false로 약속한 값이면, false로 약속한 값을 반환
			if(leftHeight == Integer.MIN_VALUE) {
				
				return Integer.MIN_VALUE;
			
			}
			
			// 오른쪽 노드들의 서브 트리 길이를 젠다.
			int rightHeight = checkHeight(root.right);
			
			// 길이를 비교했을 때, false로 약속한 값이면, false로 약속한 값을 반환
			if(rightHeight == Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			
			// 양쪽 서브 트리 길이 차이 저장
			int heightDiff = leftHeight - rightHeight;
			
			// 오른쪽고 왼쪽 차이가 1 초과 차이가 날 때, false로 약속한 값을 반환한다.
			if(Math.abs(heightDiff)>1) {
				
				return Integer.MIN_VALUE;
				
			}else {
				
				// 그 다음 레벨로 넘어 간다.
				return Math.max(leftHeight, rightHeight)+1;
			}
			
		}// checkHeight 메서드 종료
		
		
		
		// isBalanced2 메서드: 재귀 함수를 호출하는 메서드
		boolean isBalanced2 (Node root) {
			
			return checkHeight(root) != Integer.MIN_VALUE;
		
		}// isBalanced2 메서드 종료
	

	// Level 클래스: level 정보 저장할 클래스
	class Level{
		// 초기화
		// 어떤 값과 비교해도 새로운 값이 되도록 한다.
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
	}//Level 클래스 종료

	
	// isBalanced3 메서드
	boolean isBalanced3 (Node root) {
		// 레벨 객체 선언 및 새엉
		Level obj = new Level();
		
		// 재귀 함수 호출
		checkBalanced(root, obj, 0);
		
		// level 객체의 min과 max의 차이가 1초과 일 때, false을 반환
		if(Math.abs(obj.min - obj.max) > 1) {
			return false;
		}else {
			return true;
		}
		
	}// isBalanced3 메서드 종료
	
	
	// checkBalanced 메서드: 재귀적 호출을 하면서 level 객체의 값을 업데이트 해주는 메서드
	// node: 기준 노드, obj: 저장할 객체의 주소 level: 현재 레벨
	void checkBalanced(Node node, Level obj, int level) {
		
		// 맨 마지막 노드에서 level 객체 업데이트
		if(node == null) {
			
			
			if(level<obj.min) {
			
				obj.min = level;
			
			}else if(level>obj.max) {
			
				obj.max = level;
			}
			
			return;
		}
		
		// 노드 왼쪽과 오른쪽 재귀 호출
		checkBalanced(node.left, obj, level+1);
		checkBalanced(node.right, obj, level+1);

	}// checkBalanced 메서드 종료
	
}// Tree 클래스 종료


// BinarySearchTree_Balance_Sol_3 클래스
public class BinarySearchTree_Balance_Sol_3 {
	
	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		// balanced 한 경우
		System.out.println(t.isBalanced(t.root));
		System.out.println(t.isBalanced2(t.root));
		System.out.println(t.isBalanced3(t.root));
		
		
		
	}// main 메서드 종료

}// BinarySearchTree_Balance_Sol_3 클래스 종료