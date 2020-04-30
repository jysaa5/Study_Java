package tree.binaryTree.alg.find.common.parent_sol_1;

import java.util.HashMap;

// 문제: 이진 트리에서 주어진 두 개의 노드의 첫 번째 공통된 부모 노드를 찾으시오. (단, 다른 자료구조는 사용 금지)
// Solution 1: 길이 맞추서 풀기

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

// Solution 1 
// 1. 루트에서 두 노드 길이를 젠다. 
// 2. 두 노드 간의 길이를 맞춘다. 긴 노드가 노드 차만큼 위로 올라간다.
// 3. 한 칸씩 같이 올라가면서 공통 분모 확인
// 시간 복잡도: O (d)
// d: 트리의 길이

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
		
		// 길이 차이
		int diff = depth(p) - depth(q);
		
		// first: 짧은 것, second: 긴 것
		Node first = diff > 0? q : p;
		Node second = diff > 0? p : q;
		
		// goUpBy 메서드를 이용해서 first와 second 노드의 길이를 같게 맞춘다.
		second = goUpBy(second, Math.abs(diff));
		
		// 두 노드를 올라가면서 공통 부모 노드를 찾는다.
		while(first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
					
		}
		
		return first == null || second == null ? null : first;
		
	}// commonAncestor 메서드 종료
	
	
	// goUpBy 메서드: 두 노드의 길이 차이 만큼 긴 쪽을 올려서 둔 노드의 길이를 맞춰준다.
	Node goUpBy(Node node, int diff) {
		
		// diff 숫자 만큼 노드를 위로 올려 보낸다.
		while(diff > 0 && node != null) {
			node = node.parent;
			diff --;
		}
		
		return node;
		
	}// goUpBy 메서드 종료
	
	
	// depth: 노드에서부터 루트(root)까지 길이 구하는 메서드
	int depth(Node node) {
		int depth = 0;
		
		while(node != null) {
			node = node.parent;
			depth++;
		}
		
		return depth;
	
	}// depth 메서드 종료
	
	
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


public class BinaryTree_alg_find_commonParent_sol_1 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		Tree.Node fa = t.commonAncestor(3, 5);
		System.out.println( "The first common ancestor is " + fa.data);
		
	}// main 메서드
	
}