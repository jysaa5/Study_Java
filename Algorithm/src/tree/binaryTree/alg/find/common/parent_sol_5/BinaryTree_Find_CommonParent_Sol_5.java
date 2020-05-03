package tree.binaryTree.alg.find.common.parent_sol_5;

import java.util.HashMap;

// 문제: 이진 트리에서 주어진 두 개의 노드의 첫 번째 공통된 부모 노드를 찾으시오. (단, 다른 자료구조는 사용 금지)
// Solution 5: 정확한 결과 가져오기 : 트리에 없는 노드를 찾을 때. -> 이미의 저장 공간을 만들어서 확실히 찾았는지 못 찾았는지 포인터로
// 표시하기

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

	
	// Result 클래스: 결과 저장 객체
	class Result{
		// 노드 저장
		Node node;
		// 찾았는지 여부
		boolean isAncestor;
	
		// 생성자
		Result (Node n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	
	
	
	// commonAncestor 메서드: 공통 부모 찾는 메서드
	Node commonAncestor(int d1, int d2) {
		
		Node p = getNode(d1);
		Node q = getNode(d2);
		
		Result r =  commonAncestor(root, p, q);
		
		if(r.isAncestor) {
			return r.node;
		}
		return null;
	}// commonAncestor 메서드 종료
	
	// commonAncestor 메서드: 재귀 호출
	Result commonAncestor (Node root, Node p, Node q) {
		
		// 트리의 잎파리 노드까지 왔을 때 (맨 밑으로 내려 왔을 때)
		if(root == null ) {
			return new Result(null, false);
		}
		
		// p와 q와 root가 다 같으면 해당 노드가 공통 노드가 된다.
		if(root == p && root == q) {
			return new Result(root, true);
		}
		
		// 루트의 왼쪽 검색
		Result rx = commonAncestor(root.left, p , q);
		
		// 왼쪽에서 공통 부모를 찾은 경우
		if(rx.isAncestor) {
			return rx;
		}
		
		// 루트의 오른쪽 검색
		Result ry = commonAncestor(root.right, p, q);
		
		// 오른쪽에서 공통 부모를 찾은 경우
		if(ry.isAncestor) {
			return ry;
		}
		
		// 찾은 노드를 모두 찾은 경우 = 현재 노드가 공통 부모
		if(rx.node != null && ry.node !=null) {
			return new Result(root, true);
			
			// 현재 노드가 찾은 노드인 경우: 찾는 노드가 공통 분모일수도 있는 가능성이 있다.
		}else if (root == p || root == q) {
			boolean isAncestor = rx.node !=null || ry.node != null;
			return new Result(root, isAncestor);
			
			// 왼쪽, 오른쪽 노드들 중에서 한 개는 반드시 null일 때
		}else {
			
			return new Result(rx.node !=null ? rx.node: ry.node, false);
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

// BinaryTree_Find_CommonParent_Sol_5 클래스
public class BinaryTree_Find_CommonParent_Sol_5 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(0, 8);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main 메서드 종료
	
}// BinaryTree_Find_CommonParent_Sol_5 클래스 종료