package graph.alg.find.path;

import java.util.LinkedList;

// 문제: 그래프에서 두 지점의 경로 찾기
// Solution: BFS 방법 사용

// Graph: 그래프 클래스
class Graph {

	// Node: 노드 클래스
	class Node {

		// 데이터
		int data;
		// 마킹
		boolean marked;
		// 인접한 노드
		LinkedList<Node> adjacent;

		// 생성자
		Node(int data) {
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}

	// 노드를 관리할 배열방 선언
	Node[] nodes;

	// 생성자
	Graph(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}

	}

	// addEdge 메서드: 간선(엣지) 추가하는 기능
	void addEdge(int i1, int i2) {

		// 연결할 노드
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];

		// 인접한 노드가 있는지 확인하고 없으면 추가해주기.
		// contains: 리스트안에 데이터가 존재 하는지 확인하는 메서드
		// n1과 인접한 노드중에 n2가 없을 때
		if (!n1.adjacent.contains(n2)) {
			// n1에 인접한 노드에 n2를 추가
			n1.adjacent.add(n2);
		}

		// n2와 인접한 노드중에 n1이 없을 때
		if (!n2.adjacent.contains(n1)) {
			// n2에 인접한 노드에 n1를 추가
			n2.adjacent.add(n1);
		}

	}// addEdge 메서드 종료

	// initMarks 메서드: 모든 노드를 처음에 마킹을 초기화하는 기능
	void initMarks() {

		//모든 노드 마킹을 false로 초기화
		for (Node n : nodes) {
			
			n.marked = false;
		
		}

	}// initMarks 메서드 종료

	
	// search 메서드: 노드 인덱스를 인자로 받으면 노드 값을 반환하는 기능
	boolean search(int i1, int i2) {

		return search(nodes[i1], nodes[i2]);

	}// search 메서드 종료

	
	// search 메서드: start와 end의 경로가 존재하는 지 확인하는 메서드: BFS 방법
	boolean search(Node start, Node end) {

		initMarks();
		
		// 큐를 생성
		LinkedList<Node> q = new LinkedList<Node>();
		// 시작 노드를 큐에 추가한다.
		q.add(start);

		// 큐가 빌때까지 반복
		while (!q.isEmpty()) {
			
			// 큐에서 데이터를 꺼내기
			Node root = q.removeFirst();

			// 꺼낸 데이터가 end일 때
			if (root == end) {
				return true;
			}

			// 꺼낸 노드의 자식 노드를 돌면서 큐에 추가한다.
			for (Node n : root.adjacent) {
				
				if (n.marked == false) {
				
					n.marked = true;
					q.add(n);
				
				}
			}
		}
		
		// 반환되지 못했다면, 경로가 없는 것이므로 마지막에는 false를 반환한다.
		return false;
		
	}//search 메서드 종료

}

/*
 *   0
 *  /
 * 1 -- 3    7
 * |  / | \ /
 * | /  |  5
 * 2 -- 4   \
 *           6 - 8
 * */



public class Graph_alg_Find_Path_Imp {
	
	public static void main(String[] args) {
		
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		//g.addEdge(1, 3);
		//g.addEdge(2, 4);
		//g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		
		System.out.println(g.search(1, 8));
		
	}

}
