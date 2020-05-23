package tree.binarySearchTree.alg.find.common.parent_sol_2;

import java.util.HashMap;

// 문제: 이진 트리에서 주어진 두 개의 노드의 첫 번째 공통된 부모 노드를 찾으시오. (단, 다른 자료구조는 사용 금지)
// Solution 2: 형제 노드 검색

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

// Solution 2
// 1. 한 노드의 부모한테 가서 다른 쪽의 서브 트리에 내가 찾는 노드가 있는지 물어본다.
// 2. 없다면 그 위에 부모 노드의 부모에게 물어본다. 
// t: 서브 트리의 개수
// 시간 복잡도: O(t), 최악의 경우: O(n) -> 루트가 공통 분모일 경우, 전부 확인

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
			
			// q가 p에 자손인지 확인
		}else if(covers(p, q)) {
			
			return p;
		
			// p가 q에 자손인지 확인
		}else if(covers(q, p)) {
			return q;
		}
		
		// 현재 노드가 왼쪽 자식이면 부모의 오른쪽 자식들을 가져오고 
		// 현재 노드가 오른쪽 자식이면 부모의 왼쪽 자식을 가져온다.
		Node sibling = getSibling(p);
		
		// 부모 노드
		Node parent = p.parent;
		
		// 레벨을 한 칸씩 올라가면서 찾으려는 노드가 부모의 반대쪽 노드에 있는지 확인하기.
		while(!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		
		return parent;
		
		
	}// commonAncestor 메서드 종료
	
	
	// getSibling 메서드: 부모 노드를 받아서 내가 왼쪽 자식인지 오른쪽 자식인지에 따라 반대편 형제 노드를 가져옴.
	Node getSibling(Node node) {
		
		if(node == null || node.parent == null) {
			
			return null;
		
		}
		
		Node parent = node.parent;
		
		return parent.left == node ? parent.right : parent.left;
		
				
	}// getSibling 메서드 종료
	
	
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

// BinarySearchTree_Find_CommonParent_Sol_2 클래스
public class BinarySearchTree_Find_CommonParent_Sol_2 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(0, 3);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main 메서드 종료
	
}// BinarySearchTree_Find_CommonParent_Sol_2 클래스 종료