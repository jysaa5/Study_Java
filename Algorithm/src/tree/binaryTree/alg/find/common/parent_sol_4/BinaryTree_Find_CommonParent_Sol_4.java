package tree.binaryTree.alg.find.common.parent_sol_4;

import java.util.HashMap;

// 문제: 이진 트리에서 주어진 두 개의 노드의 첫 번째 공통된 부모 노드를 찾으시오. (단, 다른 자료구조는 사용 금지)
// Solution 4: 최적화 시키기 -> postorder로 모든 노드들을 한 번씩만 돌면서 반환받은 왼쪽과 오른쪽 노드를 보는 순간 판단.

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

// postorder : L, R, root

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

	
	// commonAncestor 메서드: 공통 부모 찾는 메서드
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		return commonAncestor(root, p, q);
		
	}// commonAncestor 메서드 종료
	
	// commonAncestor 메서드: 재귀 호출
	Node commonAncestor (Node root, Node p, Node q) {
		
		// 트리의 잎파리 노드까지 왔을 때 (맨 밑으로 내려 왔을 때)
		if(root == null ) {
			return null;
		}
		
		// p와 q와 root가 다 같으면 해당 노드가 공통 노드가 된다.
		if(root == p && root == q) {
			return root;
		}
		
		// 루트의 왼쪽 검색
		Node x = commonAncestor(root.left, p , q);
		
		// 왼쪽에서 공통 부모를 찾은 경우
		if(x != null && x != p && x != q) {
			return x;
		}
		
		// 루트의 오른쪽 검색
		Node y = commonAncestor(root.right, p, q);
		
		// 오른쪽에서 공통 부모를 찾은 경우
		if(y != null && y !=p && y != q) {
			return y;
		}
		
		// 찾은 노드를 모두 찾은 경우 = 현재 노드가 공통 부모
		if(x != null && y !=null) {
			return root;
			
			// 현재 노드가 찾은 노드인 경우
		}else if (root == p || root == q) {
			return root;
		}else {
			// null이 아닌 노드를 반환한다.
			return x == null ? y : x;
		}
		
	}
	
	
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

// BinaryTree_Find_CommonParent_Sol_4 클래스
public class BinaryTree_Find_CommonParent_Sol_4 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(5, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main 메서드 종료
	
}// BinaryTree_Find_CommonParent_Sol_4 클래스 종료