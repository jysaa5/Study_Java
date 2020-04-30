package tree.binaryTree.alg.find.common.parent_sol_3;

import java.util.HashMap;

// 문제: 이진 트리에서 주어진 두 개의 노드의 첫 번째 공통된 부모 노드를 찾으시오. (단, 다른 자료구조는 사용 금지)
// Solution 3: 부모 노드를 알 수 없는 경우

/*
 *            (4)
 *          /      \
 *         /        \
 *        /          \
 *       (1)         (7)
 *      /   \       /   \
 *     /     \     /     \
 *    /       \   /       \
 *   (0)     (2) (5)      (8)
 *  /  \       \    \        \
 * /    \       \    \        \ 
 *(13)  (12)    (3)   (6)     (9)
 *      /  \      \
 *    (15) (14)  (10)
 *
 *
 * */

// Solution 3
// 1. 루트에서부터 내려오면서 찾는 노드 p, q를 찾는다.
// 2. 루트의 왼쪽 서브 트리에 있는지 오른쪽 서브 트리에 있는지 확인
// 3. 내려가면서 확인.
// t: 서브 트리의 개수
// 시간 복잡도: O(log n)^2 = O(n)

// Tree 클래스
class Tree{
	
	// Node 클래스
	static class Node{
		
		int data;
		Node left;
		Node right;
		Node parent;
		
		// 생성자
		Node (int data){
			this.data = data;
		}
	}// Node 클래스
	
	
	Node root;
	
	HashMap<Integer, Node> rootMap;
	
	// Tree 생성자
	Tree (int size){
		rootMap = new HashMap<Integer, Node>();
		root = makeBST(0, size-1, null);
				
	}
	
	
	// makeBST 메서드: 이진 검색 트리
	Node makeBST(int start, int end, Node parent) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1, node);
		node.right = makeBST(mid+1, end, node);
		node.parent = parent;
		// 값으로 노드를 찾아올 수 있게 해시맵에 노드 추가
		rootMap.put(mid, node);
		return node;
		
	}// makeBST 메서드 종료
	
	
	// getNode 메서드
	Node getNode(int data) {
		
		// 해시 맵에서 get으로 노드르 가져온다.
		return rootMap.get(data);
	
	}// getNode 메서드 종료
	
	
	// covers 메서드: 인자로 받은 노드가 루트의 자손인지 확인하는 메서드
	boolean covers(Node root, Node node) {
		
		if(root == null) {
			return false;
		}
		
		if(root == node) {
			return true;
		}
		
		return covers(root.left, node) || covers(root.right, node);
		
	}// covers 메서드 종료
	
	
	
	
	// commonAncestor 메서드: 공통 부모 찾는 메서드
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		// 가장 먼저 root에서 p와 q가 있는 지 존재 여부 확인
		if (!covers(root, p)|| !covers(root, q)) {
			
			return null;
			
		}
		
		return ancestorHepler(root, p, q);
		
	}// commonAncestor 메서드 종료
	
	
	// ancestorHepler 메서드 
	Node ancestorHepler(Node root, Node p, Node q) {
		
		if(root == null || root == p || root == q) {
			return root;
		}
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		
		// 둘이 다른 방향에 있다면 그때 갈라지는 곳이 같은 부모이다.
		if(pIsOnLeft != qIsOnLeft) {
			return root;
		}
		
		// 위에서 둘이 같은 곳에 있을 때, 왼쪽에 있는지 오른쪽에 있는지 확인
		Node childSide = pIsOnLeft? root.left : root.right;
		
		return ancestorHepler(childSide, p, q);
	}// ancestorHepler 메서드 종료

	
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
 *
 * */

// BinaryTree_alg_find_commonParent_sol_3 클래스
public class BinaryTree_alg_find_commonParent_sol_3 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(2, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main 메서드 종료
	
}// BinaryTree_alg_find_commonParent_sol_3 클래스 종료