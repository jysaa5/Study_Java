package tree.binarySearchTree.alg.building.originalTree;

// 문제: 순회결과로 원본트리 재현하기 (Building tree from traversal results)
/*
- Binary Tree Traversals: preorder, inorder, postorder
- preorder: root, left, right -> 왼쪽
- inorder: left, root, right -> 아래를 지날 때 순회
- postorder: left, right, root -> 오른쪽을 지날 때 순회 
 
- 그냥 preorder 또는 inorder 또는 postorder 한 가지 순회 가지고는 원본 트리를 구현할 수 없다.
- preorder와 inorder로 만든 배열로 트리를 구현할 수 있다.
- postorder와 inorder로 만든 배열로 트리를 구현할 수 있다.
- preorder와 postorder만 가지고 원본 트리를 구현 할 수 없다. -> full binary tree 제외 
 */

// 트리 클래스
class Tree{
	// 노드 클래스
	class Node{
		int data;
		Node left, right;
		
		//생성자
		Node(int data){
			
			this.data = data;
		}
		
	}
	
	// 트리의 첫 번째 루트 노드 저장
	Node root;
	
	// 배열방을 어디까지 읽었는 지 저장
	static int pIndex = 0;
	
	//Inorder, preorder 순회를 가지고 메서드 원본 트리 만드는 메서드
	public void buildTreeByInPre(int in[], int pre[]) {
		pIndex = 0;
		
		// 재귀함수: 배열 맨 처음부터 끝까지.
		root = buildTreeByInPre(in, pre, 0, in.length-1);
		
	}// buildTreeByInPre 메서드 종료
	
	
	// inorder 배열, preorder 배열, inorder에서 처리할 start와 end 인덱스
	private Node buildTreeByInPre(int in[], int pre[], int start, int end) {
		
		// start와 end가 서로 지나칠 때
		if(start>end) {
			return null;
		}
		
		Node node = new Node(pre[pIndex++]);
		
		if(start == end) {
			return node;
		}
		
		
		int mid = search(in, start, end, node.data);
		node.left = buildTreeByInPre(in, pre, start, mid-1);
		node.right = buildTreeByInPre(in, pre, mid+1, end);
		
		return node;
	}
	
	
	// inorder와 postorder 순회를 가지고 메서드 원본 트리 만드는 메서드
	public void buildTreeByInPost(int in[], int post[]) {
		
		// postorder에서는 루트가 맨 마지막에 있다. 
		pIndex = post.length-1;
		
		// 재귀함수
		root = buildTreeByInPost(in, post, 0, in.length-1);
	}
	
	private Node buildTreeByInPost(int in[], int post[], int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		Node node = new Node(post[pIndex--]);
		
		if(start == end) {
			return node;
		}
		
		int mid = search(in, start, end, node.data);
		node.right = buildTreeByInPost(in, post, mid+1, end);
		node.left = buildTreeByInPost(in, post, start, mid-1);
		return node;
	}
	
	
	private int search(int arr[], int start, int end, int value) {
		int i;
		for(i=start; i<=end; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return i;
	}

	
	void printInorder(Node node) {
		if(node == null) {
			return;
		}
		
		printInorder(node.left);
		System.out.print(node.data +  " ");
		printInorder(node.right);
	}
	
	
}

// Original_Tree_Imp 클래스
public class Original_Tree_Imp {
	
	// main 메서드 
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		int[] pre = {4,2,1,3,6,5,7};
		int[] in = {1,2,3,4,5,6,7};
		int[] post = {1,3,2,5,7,6,4};
		
		tree.buildTreeByInPre(in, pre);
		tree.printInorder(tree.root);
		System.out.println(" ");
		tree.buildTreeByInPost(in, post);
		tree.printInorder(tree.root);
		
	}
}
