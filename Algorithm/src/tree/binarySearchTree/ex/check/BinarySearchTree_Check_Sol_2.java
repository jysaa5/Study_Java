package tree.binarySearchTree.ex.check;

// 문제: 주어진 트리가 이진검색트리 인지를 확인하는 함수를 구현하시오.
// Solution 1 : inorder(L, root, R) -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// 트리를 inorder로 순회 한 다음, 배열방에 값을 담는다. 그리고 배열 방의 값들이 ascending(오름 차순)인지 확인한다.
// 공간 복잡도: O(n) -> 배열만큼의 공간이 필요하다.
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
 *               /
 *             (10)
 *             
 * -> 규칙에서 어긋난다. 10번노드가 9번 노드보다 크면 오른쪽에 있어야 하기 때문이다.
 * */


// Solution 2: 이전 노드를 저장하는 변수를 선언하고 이전노드와 다음 노드만 비교하는 방식으로 풀이한다.

// Tree 클래스
class Tree_02{
	
	// Node 클래스
	class Node{
		
		int data;
		Node left;
		Node right;
		
		// 생성자
		Node(int data){
			
			this.data = data;
		}
		
	}// Node 클래스 종료
	
	Node root;
	int size;
	
	// 생성자
	Tree_02(int size){
		
		this.size = size;
		root = makeBST(0, size - 1 ); 
		
		// 9번 노드에 왼쪽으로 10번 노드 추가
		//root.right.right.right.left = new Node(10);
		//this.size ++;
		
		
	}
	
	
	// makeBST 메서드: 이진트리를 만드는 기능
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid+1, end);
		
		return node;
		
	}// makeBST 메서드 종료
	
	
	// isValidateBST1 메서드
	// Solution1: inorder 순회를 변형하여 이진 검색 트리를 확인하는 메서드 
	boolean isValidateBST1() {
		
		// 노드 개수만큼 배열을 선언 및 생성
		int[] array = new int[size];
		
		// inorder 메서드 호출: root 노드, 배열방 
		inorder(root, array);
		
		// 오름차순 정렬인지 확인하는 부분
		for(int i=1; i< array.length; i++) {
			if(array[i]<array[i-1]) {
				return false;
			}
		}
		return true;
	}// isValidateBST1 메서드 종료
	
	// 몇 번째 방까지 노드를 담았는지 기억하고 있는 변수 선언
	int index = 0;
	
	
	// inorder 메서드
	void inorder(Node root, int[] array) {
		
		// 노드가 null이 아닐때까지 반복
		if(root != null) {
			// 노드의 왼족 서브 트리 호출
			inorder(root.left, array);
			// 배열 방에 저장
			array[index] = root.data;
			// 배열 인덱스 1 증가
			index ++;
			
			// 노드의 오른쪽 서브 트리 호출
			inorder(root.right, array);
		
		}
		
	}// inorder 메서드 종료
	
	
	// Solution2 
	// 바로 이전 노드에 있었던 값을 저장하는 정수 객체의 주소를 넘기는 클래스 타입으로 선언
	Integer last_printed = null;
	
	// isValidateBST2 메서드: 인자 없이 호출 되면, root 부터 이진 검색 트리인지 확인.
	boolean isValidataBST2() {
		
		return isValidateBST2(root);
	}// isValidateBST2 메서드 종료
	
	
	// isValidateBST2 메서드: Integer형 변수를 선언해서, 이전 노드를 담고 그 다음 노드와 비교하여 이진 검색 트리인지 확인.
	boolean isValidateBST2(Node n) {
		
		// 노드가 null 일 때. 노드의 마지막을 지났을 때.
		if(n == null) {
			return true;
		}
		
		// 노드의 왼쪽 서브 트리에서 정렬되지 않은 값을 만났을 때
		if(!isValidateBST2(n.left)) {
			return false;
		}
		
		// 바로 전에 저장된 값을 현재 노드와 비교
		if (last_printed != null && n.data < last_printed ) {
			return false;
		}
		
		// 현재 데이터를 변수에 할당한다.
		last_printed = n.data;
		
		// 노드의 오른쪽 서브 트리에서 정렬되지 않은 값을 만났을 때
		if(!isValidateBST2(n.right)) {
			return false;
		}
		
		return true;
	}//isValidateBST2 메서드 종료
	
	
	
}// Tree 클래스 종료


// BinarySearchTree_Check_Sol_2 클래스
public class BinarySearchTree_Check_Sol_2 {

	// main 메서드
	public static void main(String[] args) {
		
		Tree_02 t = new Tree_02(10);
		
		System.out.println("Solution 1 - using inorder: "+t.isValidateBST1());
		
		System.out.println("Solution 2 - without array: " + t.isValidataBST2());
		
	}// main 메서드 종료
	
	
}// BinarySearchTree_Check_Sol_2 클래스 종료
