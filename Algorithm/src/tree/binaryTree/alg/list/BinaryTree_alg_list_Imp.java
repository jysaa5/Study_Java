package tree.binaryTree.alg.list;

import java.util.ArrayList;
import java.util.LinkedList;

// 문제: 이진트리의 노드들을 각 레벨별로 LinkedList에 담는 알고리즘을 구현하시오.
// (예를 들어, 5개의 깊이를 가지는 트리라면 5개의 LinkedList를 만들어야 한다.)

// Solution1: 함수가 호출될 때마다, 현재 노드의 레벨이 몇 번째인지 함수의 인자로 받는다. 첫 번째 레벨은 0부터 1씩 증가.
// 각 노드들은 호출 받았을 때, 몇 번째 LinkedList에 들어가야 되는지를 함수의 인자로 받아서 알고 있기 때문에
// 그냥 LinkedList에 해당 노드를 추가하면 된다.
// 시간복잡도: O(n)
// 공간복잡도: O(n) + O(log n) -> 재귀호출을 할 때 반환할 함수를 스택으로 기억한다. ( O(log n)만큼 공간 사용 )
// 노드 개수만큼 재귀 호출을 한다. 노드 개수만큼 루프를 돈다. 

// Solution2: root를 LinkedList를 추가한다. 다른 LinkedList를 생성해서 그 자식의 노드를 추가한다.
// 그 다음에도 또 새로운 LinkedList를 생성해서 위에 것들의 자식 노드들을 추가한다. 
// 시간복잡도: O(n)
// 공간복잡도: O(n) 
//노드 개수만큼 재귀 호출을 한다. 노드 개수만큼 루프를 돈다. 

// Tree 클래스
class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		
		// 생성자 
		Node(int data){
			this.data = data;
		}// 생성자 종료

	}// Node 클래스 
	
	Node root;
	
	//생성자
	Tree (int size){
		root = makeBST(0, size-1);
		
	}
	
	
	//makeBST 메서드: 이진 트리 만들어 주는 메서드 
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}//makeBST 메서드 종료
	
	
	// Solution1 
	// 초기값 설정 메서드
	ArrayList<LinkedList<Node>> BSTtoList(){
		// 결과값으로 줄 배열방 선언 및 생성
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		
		// 재귀 호출: 이진트리의 루트, 결과 값을 담을 배열방, 레벨 0
		BSTtoList(root, lists, 0);
		return lists;
		
	}// BSTtoList 메서드 종료
	
	// 재귀함수
	// 루트, 저장할 배열, 레벨을 인자로 받음.
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		
		if(root == null) {
			return;
		}
		
		// 리스트 선언
		LinkedList <Node> list = null;
		
		// 새로운 레벨에 노드를 처음 호출할 때, 해당 레벨의 리스트가 배열방에 존재하지 않으므로 새로운 노드 생성
		// 배열방에 추가
		if(lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
			
		}else {
			// 해당 레벨에 이미 리스트가 있는 경우, 기존의 리스트의 주소를 저장
			list = lists.get(level);
		}
		
		// 해당 리스트에 노드 추가
		list.add(root);
		
		//재귀 호출
		BSTtoList(root.left, lists, level+1);
		BSTtoList(root.right, lists, level+1);
		
		
	}//BSTtoList 메서드 종료
	
	
	// Solution2
	// BFS 변형 방법
	ArrayList<LinkedList<Node>> BSTtoList2(){
		// 결과 값을 담을 배열 방
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		// LinkedList 선언 및 생성
		// 현재 레벨의 노드를 답을 리스트 생성
		LinkedList<Node> current = new LinkedList<Node>();
	
		// 초기값으로 루트 노드 담기
		if(root != null) {
			current.add(root);
		}
		
		// 현재 레벨의 노드들이 있는 동안 반복
		while(current.size()>0) {
			// 첫 번째 레벨을 결과방에 추가
			result.add(current);
			// 첫 번째 레벌을 부모 레벨로 만듬
			LinkedList<Node> parents = current;
			// 현재 레벨은 새로 시작한다.
			current = new LinkedList<Node>();
			
			for(Node parent:parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
			
		}
		// 모든 자식들을 추가하면 결과 방 반환
		return result;
	
	}//BSTtoList2 메서드 종료
	
	
	// 결과 출력 메서드
	void printList(ArrayList<LinkedList <Node>> arr) {
		for(LinkedList <Node> list: arr) {
			for(Node node: list) {
				System.out.print(node.data +" ");
			}
			System.out.println();
		}
	}//printList 메서드 종료
	
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

// BinaryTree_alg_list_Imp 클래스
public class BinaryTree_alg_list_Imp {
	
	public static void main(String[] args) {
		Tree t = new Tree(10);
		
		// Solution 1: 재귀 호출을 이용한 방법
		//t.printList(t.BSTtoList());
		
		// Solution 2: 부모 레벨의 자식 노드를 저장하는 방법
		t.printList(t.BSTtoList2());
		
	}//main 메서드 종료

	
}// BinaryTree_alg_list_Imp 클래스 종료
