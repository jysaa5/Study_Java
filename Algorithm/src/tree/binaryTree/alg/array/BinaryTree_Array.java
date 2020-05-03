package tree.binaryTree.alg.array;

// 문제: 정렬이 되어 있고, 고유한 정수로만 이루어진 배열이 있다. 이 배열로 이진검색트리를 구현하시오.
// 배열: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// Solution: 재귀 호출

// Tree 클래스: 트리 클래스
class Tree {
	class Node {
		
		// 데이터
		int data;
		// 왼쪽 노드
		Node left;
		// 오른쪽 노드
		Node right;
		
		// 생성자
		Node(int data){
			
			this.data = data;
		
		}
		
	}// Node 클래스 종료
	
	// 루트 노드
	Node root;
	
	// makeTree 메서드: 배열 정보를 받아서 트리를 만드는 일을 시작하는 기능
	public void makeTree(int[] a) {
		
		// 재귀 호출에 필요한 인자들을 처음으로 주는 역할
		// 재귀 호출이 끝나면, 제일 위에 있는 루트 노드의 주소를 저장
		root = makeTreeR(a, 0, a.length-1);
		
	}
	
	// 재귀함수
	// a: 배열 정보, start: 시작 인덱스, end: 마지막 인덱스
	public Node makeTreeR(int[] a, int start, int end) {
		
		// 끝나는 부분을 제대로 명시해야 한다. 그렇지 않으면 무한 루프를 돈다.
		if(start > end) {
			return null;
		}
		
		// 중간값
		int mid = (start+end)/2;
		// 중간값으로 노드 생성
		Node node = new Node(a[mid]);
		
		// 재귀 호출
		node.left = makeTreeR(a, start, mid-1);
		node.right = makeTreeR(a, mid+1, end);
		
		return node;
	}
	
	
	// searchBTree: 이진 검색을 할 메서드 
	// n: 검색을 시작할 노드
	// find: 찾는 값
	public void searchBTree(Node n, int find) {
		
		// 찾는 값과 현제 데이터 크기 비교
		if(find < n.data) {
			
			System.out.println("Data is smaller than "+ n.data);
			searchBTree(n.left, find);
		
		}else if(find > n.data) {
			
			System.out.println("Data is bigger than "+ n.data);
			searchBTree(n.right, find);
			
		}else {
			
			System.out.println("Data found!");
		
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
 * */

//BinaryTree_alg_array_Imp 클래스
public class BinaryTree_Array {
	
	public static void main(String[] args) {
		
		// 배열 방 선언
		int[] a = new int[10];
	
		// 배열에 숫자 넣기
		for(int i=0; i<a.length; i++) {
			a[i] = i;
		}
	
		// 트리 생성
		Tree t = new Tree();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	}

	
}//BinaryTree_alg_array_Imp 클래스 종료