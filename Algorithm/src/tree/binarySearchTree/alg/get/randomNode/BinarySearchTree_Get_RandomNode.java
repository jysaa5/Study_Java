package tree.binarySearchTree.alg.get.randomNode;

import java.util.Random;

// 문제: 이진 검색 트리에서 임의의 노드를 가져오는 알고리즘을 구현하시오.
// 단, 모든 노드에 동일한 확률로 임의의 노드를 가져와야 하며, 필요한 경우 노드에 추가 정보를 저장해도 된다.

// Solution 1: 트리를 모두 순회해서 노드를 배열에 담는다. 그 다음 랜덤으로 배열 인덱스를 뽑는다.
// -> 문제점: 공간을 따로 사용해야 되고 트리 전체를 돌기 때문에 시간복잡도가 비효율적으로 늘어난다.

// Solution 2: 레벨을 랜덤으로 선택해서 두 줄기 중에서 랜덤 선택으로 고르는 방법
// -> 문제점: 트리 balance가 맞지 않으면 짧은 부분이 뽑힐 확률이 높다.

// Solution 3: 노드 전체 개수 안에서 랜덤 숫자를 한 개 가져와서 루트부터 카운트하면서 순회하다가 해당 숫자에 도착하면 반환.
// inorder로 순회한다. 인덱스는 0부터 시작한다.
// 노드에 현재 자기 밑에 있는 노드의 개수를 저장한다.자기 자신 포함한 개수이다.

/*     
 *     (4) -> 10개
 *    /   \
 *  (0)   (5)    -> 4개 / 5개
 *    \      \
 *    (1)    (7)  -> 3개 / 4개   
 *      \    /  \
 *      (2) (6) (8)  -> 2개 / 1개 / 2개
 *        \       \
 *        (3)     (9) -> 1개 / 1개
 * 
 * -> 7번 인덱스 = 8번째 노드 찾기
 * -> 루트에서 왼쪽 노드(0)의 개수가 4이므로 7보다 작다. 4와 같지도 아니므로 루트도 제외된다.
 * -> 7 - 5  = 2 (찾는 인덱스에서 제외되는 개수 빼기)
 * -> 오른쪽 노드(5)에서 왼쪽은 노드 개수 0보다 작지 않고 같지도 않기 때문에 오른쪽 노드(7)로 간다.
 * -> 2 - 1 = 1 (찾는 인덱스에서 제외되는 개수 빼기)
 * -> 찾는 인덱스 개수가 1인데, 현재 노드 7의 왼쪽 노드의 개수보다 작지 않고 같기 때문에 현재 노드를 가리킨다.
 * 
 * (찾는 인덱스의 개수 < 왼쪽 노드의 개수  -> 왼쪽 노드)
 * (찾는 인덱스의 개수 = 왼쪽 노드의 개수 -> 루트 노드)
 * (찾는 인덱서의 개수 > 왼쪽 노드의 개수 -> 오른쪽 노드)
 * 
 * */

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		int size = 0;
	
		// 생성자
		Node (int data){
			this.data = data;
			this.size = 1;
		}
		
		// insert 메서드: 트리에 노드를 삽입
		void insert(int data) {
			
			if(data <= this.data) {
				
				if(left == null) {
				
					left = new Node(data);
				
				}else {
				
					left.insert(data);
			
				}
			
			}else {
			
				if(right == null) {
				
					right = new Node(data);
				
				}else {
				
					right.insert(data);
				
				}
			}
			
			size++;
	
		}// insert 메서드 종료
		
		
		// size 메서드: size 반환 메서드
		int size() {
			
			return size;
			
		}// size 메서드 종료 
		
		
		// find 메서드: 값으로 노드를 찾는 메서드
		Node find(int data) {
			
			if(data == this.data) {
			
				return this;
			
			}else if(data < this.data) {
			
				return left != null ? left.find(data) : null;
			
			}else if(data > this.data) {
				
				return right != null ? right.find(data) : null;
			
			}else {
			
				return null;
			
			}
			
		}// find 메서드 종료

		
		// getItNode 메서드: 인덱스를 인자로 넣으면 노드를 반환하는 메서드
		Node getIthNode(int i) {
			
			int leftSize = left == null ? 0 : left.size();
			
			if(i < leftSize) {
				
				return left.getIthNode(i);
			
			}else if (i == leftSize) {
			
				return this;
			
			}else {
			
				return right.getIthNode(i - (leftSize+1));
			
			}
			
		}// getIthNode 메서드 종료 		
	}// Node 클래스
	
	Node root;
	
	// size 메서드: 현재 트리의 사이즈를 반환하는 메서드
	int size() {
		return root == null ? 0 : root.size();
	}// size 메서드 종료
	
	
	// insert 메서드: 값을 인자로 받아서 노드 추가
	void insert(int data) {
		
		if(root == null) {
			root = new Node(data);
		}else {
			root.insert(data);
		}
		
	}// insert 메서드 종료
	
	
	// getRandomNode 메서드: 임의의 노드를 가져오는 메서드
	Node getRandomNode() {
		if(root == null) {
			return null;
		}
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}// getRandomNode 메서드 종료
	
}// Tree 클래스 종료


// BinarySearchTree_Get_RandomNode 클래스
public class BinarySearchTree_Get_RandomNode {

	// main 메서드
	public static void main(String[] args) {
		
		Tree t = new Tree();
		t.insert(4);
		t.insert(0);
		t.insert(1);
		t.insert(2);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(6);
		t.insert(9);
		System.out.println(t.getRandomNode().data);
		
		
	}// main 메서드 종료
	
}// BinarySearchTree_Get_RandomNode 클래스 종료