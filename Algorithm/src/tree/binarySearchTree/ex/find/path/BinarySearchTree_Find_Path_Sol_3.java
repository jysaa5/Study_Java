package tree.binarySearchTree.ex.find.path;

import java.util.HashMap;

// 문제: 주어진 이진트리가 있다. 이진트리의 노드에는 정수값이 저장되어있다. (음의 정수 포함) 연결된 노드의 합산이 특정 숫자가 되는
// 경로의 개수를 찾으시오. 경로의 시작과 끝점은 어디든 될 수 있지만 언제나 위에서 아래로만 합산이 되어야 한다.

/*
 *      (4)
 *      /  \
 *     /    \
 *    /      \
 *   (1)     (7)
 *   / \    /  \
 * (0) (2) (5) (8)
 *       \   \   \
 *       (3) (6) (9)
 * 
 * -> 합: 6을 만드는 경로 = 1 + 2 + 3 , 6
 * -> 총 2개
 *
 *
 * <합산의 값이 5인 경우 찾기>
 *
 *       (4) 
 *      /   \
 *     /     \
 *    /       \
 *   (-2)      (2)  
 *   /  \     /   \
 * (1)  (8) (-1) (-3) 
 *        \    \     \
 *        (-4) (3)   (7) 
 *                     \
 *                     (-4)
 *          
 */

// Solution 3: Hash맵을 사용하여 풀이해보자.
// 시간복잡도: O(n)
// Tree 클래스
class Tree_03{
	class Node{
		int data;
		Node left;
		Node right;
		
		//생성자
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node root;
	
	//생성자
	Tree_03(int size){
		this.root = makeBST(0,size-1);
	}
	
	
	// makeBST: 이진 검색 트리를 만드는 메서드
	Node makeBST(int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
		
	}// makeBST 메서드 종료
	
	
	// countPathsWithSum 메서드: 합산 값을 받으면 루트를 시작으로 경로를 탐색하는 재귀함수 호출
	int countPathsWithSum(int targetSum) {
		
		// 해시맵 선언
		// 노드의 값을 key로 사용
		HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();

		// 초기값으로 출발점을 0을 넣는다.
		hashTable.put(0, 1);
		
		return countPathsWithSum(root, targetSum, 0, hashTable);

	}// countPathsWithSum 메서드 종료
	
	
	// countPathsWithSum 메서드: 검사할 노드, 찾을 합산값, 현재 합산값, 해시테이블
	int countPathsWithSum(Node node, int targetSum, int currSum, HashMap<Integer, Integer> hashTable) {
		
		// 트리의 끝에 도착했을 때.
		if(node == null) {
			return 0;
		}
		
		// 현재 합산값
		currSum += node.data;
		// 현재 값에서 원하는 합산 값을 뺐을 때의 값 
		int sum = currSum - targetSum;
		// sum값에 해당하는 키값 = 노드 값이 있는지 찾는다.
		int totalPaths = hashTable.getOrDefault(sum, 0);
		// 해시맵의 현재 값에 1을 추가한다. 그 숫자에 노드가 1개 있음을 저장한다.
		incrementHashTable(hashTable, currSum, 1);
		
		totalPaths += countPathsWithSum(node.left, targetSum, currSum, hashTable);
		totalPaths += countPathsWithSum(node.right, targetSum, currSum, hashTable);
		
		// 현재 합산 값을 가지는 key값의 value를 수정한다.
		// 해시맵에서 현재 노드 값의 value 값을 1을 빼줘야 된다.
		incrementHashTable(hashTable, currSum, -1);
		
		return totalPaths;
		
	}// countPathsWithSum 메서드 종료
	
	
	// incrementHashTable 메서드: key와 val로 해시테이블을 업데이트 해주는 메서드
	void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int val) {
		
		int newCount = hashTable.getOrDefault(key, 0) + val;
		if(newCount == 0) {
			// 해시맵에서 키값 제거
			hashTable.remove(key);
		}else {
			// 해시맵에서 키의 value 업데이트(기존에 없었으면 새롭게 추가)
			hashTable.put(key, newCount);
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
// BinarySearchTree_Find_Path_Sol_3 클래스
public class BinarySearchTree_Find_Path_Sol_3 {

	
	// main 메서드
	public static void main(String[] args) {
		
		Tree_03 tree = new Tree_03(10);
		System.out.println(tree.countPathsWithSum(3));
		
		
	}// main 메서드 종료
	
	
}// BinarySearchTree_Find_Path_Sol_3 클래스 종료
