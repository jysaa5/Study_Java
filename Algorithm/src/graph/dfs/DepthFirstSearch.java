package graph.dfs;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


// DFS: Depth-First Search
// inorder, preorder, postorder 순회 방법들이 DFS에 속한다.
// 하나의 child 노드 분석 -> 그 다음 child 노드 이런 식으로 깊이로 파고 든다.
// 인접한 노드로 깊이로 파고 들고 올라오면서 다시 파고들고 하는 식이다.
// stack을 이용해서 구현한다.
// solution: 재귀함수로 구현이 가능하다.

//Queue 클래스
class Queue<T> {

	// Node 클래스
	class Node<T> {

		// 데이터
		private T data;
		// 다음 노드
		private Node<T> next;

		// 생성자
		public Node(T data) {
			this.data = data;
		}

	}// Node 클래스 종료

	// 큐는 앞과 뒤의 주소를 알고 있어야 한다.
	// 맨 처음 노드
	private Node<T> first;

	// 맨 마지막 노드
	private Node<T> last;

	// enqueue 메서드: 데이터 추가하는 기능
	public void enqueue(T item) {
	
		// 노드 생성
		Node<T> t = new Node<T>(item);

		// 마지막 노드가 있을 때
		if (last != null) {
		
			last.next = t;
	
		}

		// 추가한 노드가 맨 마지막 노드
		last = t;

		// 큐가 비어있을 때
		if (first == null) {
		
			first = last;
		
		}

	}// enqueue 메서드 종료

	
	//dequeue 메서드: 큐에 있는 데이터를 제거하는 기능
	public T dequeue() {
		
		// 큐가 비어 있을 때
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}

		// 데이터 임시 저장
		T data = first.data;
		
		// 맨 처음 노드의 다음 노드에 있던 것을 맨 처음으로 만든다.
		first = first.next;

		//큐가 비어 있을 때
		if (first == null) {
		
			last = null;
		
		}
		
		return data;

	}// dequeue 메서드 종료

	
	// peek 메서드: 큐에 있는 거 보는 기능
	public T peek() {
		
		//큐가 비어 있을 때
		if (first == null) {
		
			throw new NoSuchElementException();
		
		}
	
		return first.data;
	
	}// peek 메서드 종료

	
	//isEmpty 메서드
	public boolean isEmpty() {
	
		return first == null;

	}// isEmpty 메서드 종료

}// Queue 클래스 종료


// Graph 클래스
class Graph{
	
	// Node 클래스
	class Node{
		
		//데이터는 정수로
		int data;
		
		//인접한 노드는 연결리스트로 구현
		LinkedList<Node> adjacent;
		
		//방문했는지 표시하는 마킹
		boolean marked;
		
		//생성자
		Node (int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
		
	}// Node 클래스 종료

	//노드 저장 배열 
	Node [] nodes;
	
	//그래프의 노드는 제한함 = 코드의 편의를 위해서.
	//생성자
	Graph(int size){
		nodes = new Node[size];
		
		for(int i=0; i< size; i++) {
		
			nodes[i] = new Node(i);
		
		}
		
	}
	
	//addEdge 메서드: 두 노드의 관계를 저장하는 함수
	void addEdge(int i1, int i2) {
		//데이터 == 인덱스와 같게 설정해 놨음.
		
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		//인접한 노드가 있는지 확인하고 없으면 추가해주기.
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
		
	}//addEdge 메서드 종료
	
	
	// dfs 메서드: 노드 0부터 DFS
	void dfs() {
		
		dfs(0);
		
	}//dfs 메서드 종료
	
	// dfs 메서드: 시작 인덱스를 받아서 DFS 순회 결과를 출력하는 메서드
	void dfs(int index) {
		
		Node root = nodes[index];
		
		//스택 생성
		Stack<Node> stack = new Stack<Node>();
		//스택에 데이터 넣기
		stack.push(root);
		//스택에 들어갔다고 표시
		root.marked = true;
		
		while(!stack.isEmpty()) {
			
			Node r = stack.pop();
			
			for(Node n : r.adjacent) {
			
				if(n.marked == false) {
				
					n.marked = true;
					
					stack.push(n);
				}
			}
			
			visit(r);
		}
	
	}//dfs 메서드 종료
	
	
	// visit 메서드: 데이터 출력 메서드
	void visit(Node n) {
	
		System.out.print(n.data + " ");

	}// visit 종료
	

	
	// dfsR 메서드: 재귀호출을 이용한 DFS
	void dfsR(Node r) {
		if(r == null) {
			return;
		}
		
		r.marked = true;
		
		visit(r);
		
		for(Node n : r.adjacent) {
			
			if(n.marked == false) {
			
				dfsR(n);
		
			}
			
		}
		
	}//dfsR 메서드 종료
	
	
	// dfsR: 해당 인덱스 노드부터 DFS -> 재귀호출 방법으로 
	void dfsR(int index) {
		
		Node r = nodes[index];
		
		dfsR(r);
	
	}// dfsR 메서드 종료
	
	
	// dfsR: 0 인덱스 노드부터 DFS -> 재귀호출 방법으로 
	void dfsR() {
		
		dfsR(0);
		
	}// dfsR 메서드 종료
	
	
}// Graph 클래스 종료

/*
 *   0
 *  /
 * 1 -- 3    7
 * |  / | \ /
 * | /  |  5
 * 2 -- 4   \
 *           6 - 8
 *
 *-----------------
 * DFS(0)
 * 0 1 3 5 7 6 8 4 2
 * 
 * BFS(0)
 * 0 1 2 3 4 5 6 7 8
 * 
 * DFS(0) - Recursive
 * 0 1 2 4 3 5 6 8 7 
 *------------------
 *
 * DFS(3)
 * 3 5 7 6 8 4 2 1 0
 * 
 * BFS(3)
 * 3 1 2 4 5 0 6 7 8
 * 
 * DFS(3) - Recursive
 * 3 1 0 2 4 5 6 8 7 
 *------------------
 * 
 * */

//DepthFirstSearch 클래스
public class DepthFirstSearch {
	
	//main 메서드
	public static void main(String[] args) {
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfs();
		
	}//main 메서드 종료

}//DepthFirstSearch 클래스 종룐
