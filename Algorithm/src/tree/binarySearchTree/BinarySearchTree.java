package tree.binarySearchTree;

/*
     (1)
               ↙         ↘
   (2)  (3)
          ↙     ↘
 (4) (5)
 
 Inorder (Left, Root, Right): 4 2 5 1 3
 Preorder (Root, Left, Right): 1 2 4 5 3
 Postorder (Left, Right, Root): 4 5 2 3 1
*/

//트리 노드 만들기
class Node {
	//이진 트리
	//데이터
	int data;
	//왼쪽 child 노드
	Node left;
	//오른쪽 child 노드
	Node right;

}//Node 클래스 종료

//트리 클래스
class Tree{
	
	//트리 루트
	public Node root;
	
	//setRoot: 루트 설정
	public void setRoot(Node node) {
		this.root = node;
		
	}//setRoot 메서드 종료
	
	//getRoot: 루트 가져오기
	public Node getRoot() {
		return root;
	
	}//getRoot 메서드 종료
	
	
	//노드를 만드는 함수
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}//makeNode 종료
	
	
	//inorder 순회: Left, Root, Right
	public void inorder(Node node) {
		
		if(node!=null) {
			//left child
			inorder(node.left);
			//루트
			System.out.println(node.data);
			//right child
			inorder(node.right);
			
		}
		
	}//inorder 종료
	
	//preorder 순회: Root, Left, Right
	public void preorder(Node node) {
		
		if(node !=null ) {
			//root
			System.out.println(node.data);
			//left child
			preorder(node.left);
			//right child
			preorder(node.right);
		}
	}//preorder 종료
	
	
	//postorder 순회: Left, Right, Root
	public void postorder (Node node) {
		
		if(node != null) {
			//left child
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}//Tree 클래스 종료


// BinarySearchTree 클래스
public class BinarySearchTree {
	
	//main 메서드
	public static void main(String[] args) {
		Tree t = new Tree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		t.setRoot(n1);
		//t.inorder(t.getRoot());
		//t.preorder(t.getRoot());
		t.postorder(t.getRoot());
		
	}// main 메서드 종료
	
}// BinarySearchTree 클래스 종료