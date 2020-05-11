package tree.binarySearchTree.alg.find.nextNode;

// 문제: 이진 검색 트리에서 주어진 노드의 다음노드를 찾는 함수를 구현하시오.
// (단, 다음노드의 순서는 inorder traverse에 입각함.)
// inorder: L, root, R

// Solution: inorder 순회를 이용하여 오른쪽 노드가 없을 때와 있을 때를 구분하여 위, 아래에서 찾는 메서드를 구현하였다.

class Tree{
	
	class Node{
		int data;
		Node left;
		Node right;
		// 부모 노드
		Node parent;
		
		//생성자
		Node (int data){
			this.data = data;
		}
	}
	
	Node root;
	
	//생성자
	Tree (int size){
		root = makeBST(0, size-1, null);
	}
	
	// makeBST 메서드: 이진 검색 트리를 만드는 메서드
	Node makeBST(int start, int end, Node parent) {
		
		if(start > end ) {
			return null;
		}
		
		// 가운데 숫자 선택
		int mid = (start + end)/2;
		
		// 가운데 숫자로 노드 생성
		Node node = new Node(mid);
		
		// 노드의 왼쪽을 이진 검색 트리로 만들기
		node.left = makeBST(start, mid-1, node);
		// 노드의 오른쪽을 이진 검색 트리로 만들기
		node.right = makeBST(mid+1, end, node);
		// 노드의 부모 저장
		node.parent = parent;
		
		return node;
		
	}// makeBST 메서드 종료
	
	
	// 다음 노드를 찾는 메서드
	// findNext 메서드
	void findNext(Node node) {
		
		// 노드의 오른쪽에 노드가 없는 경우: 위로 올라가서 찾아야 된다.
		if(node.right == null ) {
			// 부모 노드와 현재 노드를 인자로 넘긴다.
			System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next");
		
			// 노드의 오른쪽에 노드가 있는 경우: 아래에서 찾아야 된다.
		}else {
			System.out.println(findBelow(node.right).data + " is " + node.data + " 's next");
		}
		
	}// findNext 메서드 종료
	
	
	// 위에서 찾는 방법
	// findAbove 메서드
	Node findAbove(Node root, Node child) {
		
		// null exception 처리
		if(root == null) {
			return null;
		}
		
		// 부모의 왼쪽 노드가 현재 노드일 때 부모 노드를 반환
		if(root.left == child) {
			return root;
		}
		
		// 반복 호출
		// 부모의 부모와, 부모를 인자로 반환
		return findAbove(root.parent, root);
	
	}// findAbove 메서드 종료
	
	
	// 밑에서 찾는 방법
	// findBelow 메서드
	Node findBelow(Node root) {
		
		// 왼쪽에 더 이상 자식이 없을 때 해당 노드가 찾는 노드이다.
		if(root.left == null) {
			return root;
		}
		
		// 반복 호출
		// 현재 노드의 왼쪽 노드를 인자로 반환
		return findBelow(root.left);
		
	}// findBelow 메서드 종료
	
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

// BinarySearchTree_NextNode_Find 클래스 
public class BinarySearchTree_NextNode_Find {
	
	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree(10);
		
		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left.right);
		
		
	}// main 메서드 종료

}// BinarySearchTree_NextNode_Find 클래스 종료
