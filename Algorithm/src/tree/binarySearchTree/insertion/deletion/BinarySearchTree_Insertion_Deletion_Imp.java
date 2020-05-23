package tree.binarySearchTree.insertion.deletion;

// 문제: BST(Binary Search Tree)의 insertion / deletion 구현

// BinarySearchTree 클래스
class BinarySearchTree{
	
	// Node 클래스
	class Node{
		int data;
		Node left, right;
		
		//생성자
		public Node(int data) {
			this.data = data;
		}
	}// Node 클래스 종료
	
	Node root;
	
	// search 메서드: 검색 기능
	public Node search(Node root, int key) {
		
		if(root==null || root.data == key) {
			return root;
		}
		
		
		if(root.data > key) {
			return search (root.left, key);
		}
		
		return search(root.right, key);
		
	}// search 메서드 종료
	
	
	// insert 메서드: 삽입 기능
	public void insert(int data) {
		// 재귀함수 호출
		root = insert(root, data);
		
	}// insert 메서드 종료
	
	
	// insert 메서드 
	private Node insert(Node root, int data) {
		
		// leaf 노드에 도달했을 때 또는 root 노드가 null일때.
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		// root 데이터와 삽입할 데이터 비교
		if(data < root.data) {
			root.left = insert(root.left, data);
			
			// root 데이터와 삽입할 데이터 비교
		}else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		
		return root;
	}// insert 메서드 종료
	
	
	public void delete(int data) {
		root = delete(root, data);
	}
	
	private Node delete(Node root, int data) {
		
		if(root == null) {
			return root;
		}
		
		
		if(data < root.data) {
			root.left = delete(root.left, data);
		}else if(data > root.data) {
			root.right = delete(root.right, data);
		
		// 삭제할 데이터를 찾았을 때.
		}else {
			// 자식 노드가 다 없을 때: 부모에게 null을 반환
			if(root.left == null && root.right == null) {
				return null;
			}
			
			// 왼쪽 노드 또는 오른쪽 노드 자식이 1개만 있을 때: 자식을 위로 올리면 된다.
			else if(root.left == null) {
				return root.right;
			}
			
			else if(root.right == null) {
				return root.left;
			}
			
			root.data = findMin(root.right);
			root.right = delete(root.right, root.data);
			
		}
		return root;
	}
	
	// findMin: 오른쪽 서브 트리에서 가장 작은 노드를 찾는 메서드
	int findMin(Node root) {
		int min = root.data;
		
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		
		return min;
	}// findMin 메서드 종료
	
	
	public void inorder() {
		inorder(root);
		System.out.println("");
	}
	
	
	private void inorder(Node root) {
		
		if(root != null) {
			inorder(root.left);
			
			System.out.print(root.data + " ");
			
			inorder(root.right);
		}
		
	}

}// BinarySearchTree 클래스 종료

// BinarySearchTree_Insertion_Deletion_Imp 클래스
public class BinarySearchTree_Insertion_Deletion_Imp {
	
	
	// main 메서드
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		/*     4
		 *    /  \
		 *   2    6
		 *  / \  / \
		 * 1  3  5  7
		 * 
		 * */
		
		tree.insert(4);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(6);
		tree.insert(5);
		tree.insert(7);
		
		tree.inorder();
		//tree.delete(7);
		tree.delete(5);
		tree.delete(6);
		tree.delete(2);
		tree.inorder();
		
	}// main 메서드 종료
	
}// BinarySearchTree_Insertion_Deletion_Imp 클래스 종료
