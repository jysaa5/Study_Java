package tree.binarySearchTree.ex.building.originalTree;

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


      (4)
    /     \
   (2)    (6)
  /   \   /  \
 (1) (3) (5) (7)

- preorder: 4|2|1|3|6|5|7|
- inorder:  1|2|3|4|5|6|7|

- postorder: 1|3|2|5|7|6|4|
- inorder:   1|2|3|4|5|6|7|



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
	}// Node 클래스 종료
	
	
	// 트리의 첫 번째 루트 노드 저장
	Node root;
	
	// 배열방을 어디까지 읽었는 지 저장
	static int pIndex = 0;
	
	// buildTreeByInPre 메서드: Inorder, preorder 순회를 가지고 메서드 원본 트리 만드는 메서드
	public void buildTreeByInPre(int in[], int pre[]) {
		// 초기화
		pIndex = 0;
		
		// 재귀함수 호출: 배열 맨 처음부터 끝까지.
		root = buildTreeByInPre(in, pre, 0, in.length-1);
		
	}// buildTreeByInPre 메서드 종료
	
	
	// buildTreeByInPre 메서드: inorder 배열, preorder 배열, inorder에서 처리할 start와 end 인덱스
	private Node buildTreeByInPre(int in[], int pre[], int start, int end) {
		
		// start와 end 포인터가 서로 지나칠 때
		if(start>end) {
			return null;
		}
		
		// preorder 순회의 결과를 0번지 배열부터 가져와서 노드를 생성 -> 트리에 넣을 노드
		Node node = new Node(pre[pIndex++]);
		
		// start와 end가 같을 때, 서브트리에 노드가 1개만 있는 것이다.
		if(start == end) {
			return node;
		}
		
		// inorder 순회 결과에서 배열의 방 번호
		int mid = search(in, start, end, node.data);
		// 왼쪽 서브트리
		node.left = buildTreeByInPre(in, pre, start, mid-1);
		// 오른쪽 서브트리
		node.right = buildTreeByInPre(in, pre, mid+1, end);
		
		return node;
		
	}// buildTreeByInPre 메서드 종료
	
	
	// buildTreeByInPost 메서드: inorder와 postorder 순회를 가지고 메서드 원본 트리 만드는 메서드
	public void buildTreeByInPost(int in[], int post[]) {
		
		// postorder에서는 루트가 맨 마지막에 있다. 
		pIndex = post.length-1;
		
		// 재귀함수
		root = buildTreeByInPost(in, post, 0, in.length-1);
		
	}// buildTreeByInPost 메서드 종료
	
	
	// buildTreeByInPost 메서드: inorder 배열, postorder 배열, inorder에서 처리할 start와 end 인덱스
	private Node buildTreeByInPost(int in[], int post[], int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		Node node = new Node(post[pIndex--]);
		
		if(start == end) {
			return node;
		}
		
		// 범위 안에 있는 노드들을 반으로 나누기
		int mid = search(in, start, end, node.data);
		// 오른쪽 서브 트리 노드 부터 -> 배열 뒤에서 앞으로 오기 때문에 오른쪽 부터 찾는다. postorder: left, right, root
		node.right = buildTreeByInPost(in, post, mid+1, end);
		// 왼쪽 서브 트리 노드
		node.left = buildTreeByInPost(in, post, start, mid-1);
		return node;
		
	}// buildTreeByInPost 메서드 종료
	
	
	// search 메서드
	private int search(int arr[], int start, int end, int value) {
		int i;
		for(i=start; i<=end; i++) {
			if(arr[i] == value) {
				return i;
			}
		}
		return i;
	}// search 메서드 종료

	
	// printInorder 메서드: 트리를 만들고 결과가 맞는지 inorder로 출력하는 메서드
	void printInorder(Node node) {
		if(node == null) {
			return;
		}
		
		printInorder(node.left);
		System.out.print(node.data +  " ");
		printInorder(node.right);
	}// printInorder 메서드 종료
	
}// tree 클래스 종료


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
		
	}// main 메서드 종료
	
}// Original_Tree_Imp 클래스 종료
