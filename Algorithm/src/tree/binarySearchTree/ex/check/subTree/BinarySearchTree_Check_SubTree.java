package tree.binarySearchTree.ex.check.subTree;


// 문제: 크기가 매우 큰 두 개의 이진트리 T1과 T2가 있다. T1은 T2보다 큰 데, T2가 T1의 서브트리인지를 확인하는 알고리즘을 구현하시오.
// T2의 루트노드의 값이 T1에 존재하고 그 노드를 기준으로 줄기를 잘라냈을 때, T2의 값과 구조가 같으면 서브트리로 인정한다.

// Solution: inorder / preorder / postorder 이 순회 방법 중에 한 가지 선택 = preorder 
// root를 먼저 확인하기 때문이다.
/*
 * T1:  
 *         4
 *       /  \
 *      /    \
 *     /      \
 *     1       7
 *    / \     / \
 *   /   \   /   \
 *   0    2  5    8
 *         \  \    \
 *          3  6    9     
 * 
 * T2:
 *        7
 *       /  \
 *      /    \
 *     5      8
 *      \      \
 *       6      9
 * 
 * -> T2는 T1의 서브트리이다.
 *       
 *       
 * */

// Tree 클래스
class Tree{
	
	// Node 클래스
	class Node{
		int data;
		Node left;
		Node right;
		
		// 생성자
		Node (int data){
			this.data = data;
		}
	}
	
	Node root;
	
	
	// makeBST 메서드: 이진 검색 트리를 만드는 메서드
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start + end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}// makeBST 메서드 종료
	
	
	// containsTree 메서드: 두 개의 트리를 받아서 t2가 t1의 서브 트리인지 확인하는 메서드
	boolean containsTree(Node t1, Node t2) {
		
		if (t2 == null) {
			return true;
		}
		// 재귀함수 호출
		return subTree(t1, t2);
		
	}// containsTree 메서드 종료
	
	
	// subTree 메서드: t1을 preorder 순회 하면서 t2의 루트 값과 같은 값을 찾는 메서드
	boolean subTree(Node t1, Node t2) {
		
		if(t1 == null) {
			return false;
			
			// 찾았을 때
		}else if(t1.data == t2.data && matchTree(t1,t2)) {
			return true;
		}
		
		// 못 찾았을 때.
		return subTree(t1.left, t2)|| subTree(t1.right, t2);	
	}// subTree 메서드 종료
	
	
	// matchTree 메서드: 두 개의 트리를 순회하면서 모든 노드의 값이 일치하는지 확인
	boolean matchTree(Node t1, Node t2) {
	
		if(t1 == null && t2 == null) {
			return true;
		}else if(t1 == null || t2 == null) {
			return false;
			
			// 데이터 확인
		}else if(t1.data != t2.data) {
			return false;
		}else {
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
		
	}// matchTree 메서드 종료
	
	
}// Tree 클래스 종료

//BinarySearchTree_Check_SubTree 클래스
public class BinarySearchTree_Check_SubTree {

	
	// main 메서드
	public static void main(String[] args) {
		
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		boolean result;
		
		/*
		 * t1:
		 *         4
		 *       /  \
		 *      /    \
		 *     /      \
		 *     1       7
		 *    / \     / \
		 *   /   \   /   \
		 *   0    2  5    8
		 *         \  \    \
		 *          3  6    9   
		 *  
		 * t2:
		 *      7      
		 *     / \
		 *    /   \
		 *    5    8
		 *     \    \
		 *      6    9 
		 * 
		 * */
		
		t1.root = t1.makeBST(0, 9);
		t2.root = t2.makeBST(5, 9);
		result = t1.containsTree(t1.root, t2.root);
		System.out.println(result);
		
		/*
		 * 
		 * t2: 
		 *   
		 *     8
		 *    / \
		 *   7   9
		 *  
		 * */
		
		t2.root = t2.makeBST(7, 9);
		result = t1.containsTree(t1.root, t2.root);
		System.out.println(result);
		
	}// main 메서드 종료
	
}// BinarySearchTree_Check_SubTree 클래스 종료