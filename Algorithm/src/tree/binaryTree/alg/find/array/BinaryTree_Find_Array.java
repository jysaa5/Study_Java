package tree.binaryTree.alg.find.array;

import java.util.ArrayList;
import java.util.LinkedList;

// 문제: 배열의 값을 왼쪽부터 하나씩 넣으면서 이진검색트리를 만들었다.
// 주어진 이진검색트리를 만들 수 있는 모든 배열을 찾는 알고리즘을 구현하시오. (단, 트리에 중복값이 없다.)

/* 배열: |2|0|1|3|4|
 *    
 *     2
 *    / \
 *   0   3
 *    \   \
 *     1   4
 * 
 * 배열: |2|0|3|1|4|
 * 
 *     2
 *    / \
 *   0   3
 *    \   \
 *     1   4
 * 
 * -> 동일한 트리가 나오는 배열이 6가지가 있다.
 * 
 * 배열: |2|4|0|1|3|
 * 
 *     2
 *    / \
 *   0   4
 *    \  /
 *    1  3   
 * 
 * -> 다른 트리가 나온다.
 * 
 * solution: root = 2, left = 0 -> 1, right = 3 -> 4
 * 이 순서를 지켜야 동일한 트리가 나온다.
 * 
 * ------
 * 2
 * ------
 * 2의 배열에 밑에 파이프라인 2개에서 순서에 상관없이 배열에 넣는다.
 * 
 * ---------
 * 0 1
 * ---------
 * 3 4
 * ---------
 * 
 * -> 경위의 수를 따지면 아래와 같다.
 * 
 * |2|0|1|3|4|
 * 
 * |2|0|3|1|4|
 * 
 * |2|0|3|4|1|
 * 
 * |2|3|0|1|4|
 * 
 * |2|3|0|4|1|
 * 
 * |2|3|4|0|1|
 * 
 * */

// Tree 클래스
class Tree{
	
	// Node 클래스
	static class Node{
		int data;
		Node left;
		Node right;
		
		// 생성자
		Node (int data){
			this.data  = data;
		}
		
	}// Node 클래스
	
	Node root;
	
	// 생성자
	Tree (int size){
		root = makeBST(0, size-1);
	}
	
	// makeBST 메서드: 이진 검색 트리를 만드는 메서드
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
	
}// Tree 클래스 종료


// BinaryTree_Find_Array 클래스
public class BinaryTree_Find_Array {

	// allSequences 메서드: 트리를 만드는 모든 배열을 가져오는 메서드
	static ArrayList<LinkedList<Integer>> allSequences(Tree.Node node){
		
		// 결과 저장 공간 
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		// 노드가 null 일때
		if(node == null) {

			result.add(new LinkedList<Integer>());			
			return result;
		
		}
		
		// 맨 처음 root로 들어가는 것.
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		// 루트 추가
		prefix.add(node.data);
	
		// 이진 검색 트리 맨 밑에서 부터 파이프라인에 넣을 노드를 가져와야한다.
		// 왼쪽, 오른쪽 서브 트리도 재귀 호출한다. 
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		
		// 왼쪽과 오른쪽 서브 트리의 순서를 모두 가져온다.
		for(LinkedList<Integer> left: leftSeq) {
			for(LinkedList<Integer> right : rightSeq) {
				
				// 모든 경우의 수를 담을 곳 선언 및 생성
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				// 경우의 수를 만드는 메서드 
				weaveLists(left, right, weaved, prefix);
				// 결과에 저장
				result.addAll(weaved);
			}
		}
		return result;
	
	}// allSequences 메서드 종료
	
	
	// weaveLists 메서드: 경우의 수를 만들어주는 함수
	// first: 첫 번째 파이프, second: 두 번째 파이프, results: 결과 저장, prefix: 현재 노드
	static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		
		// 두 파이프 중 하나가 빌때 -> 결과 반환
		if(first.size() == 0 || second.size() == 0) {
			
			// 경우의 수 한 개 저장
			LinkedList<Integer> result = new LinkedList<Integer>();
			
			for(int data : prefix) { 
				result.add(data);
			}
			
			result.addAll(first);
			result.addAll(second);
			
			// 경우의 수 여러개 저장하는 곳에 저장
			results.add(result);
			
			return;
		}
		
		// 첫 번째 파이프
		// 첫 번째 경우
		// 첫 번째 파이프에서 앞에 부분 떼어서 현재 배열방 뒤에 붙이기
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		
		// 또 다른 경우의 수 확인
		weaveLists(first, second, results, prefix);
		
		// 원래 모양으로 다시 파이프 라인 만들기
		prefix.removeLast();
		first.addFirst(headFirst);
		
		
		// 두 번째 파이프
		// 두 번째 경우
		// 두 번째 파이프에서 앞에 부분 떼어서 현재 배열방 뒤에 붙이기
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		// 또 다른 경우의 수 확인
		weaveLists(first, second, results, prefix);
		
		// 원래 모양으로 다시 파이프 라인 만들기
		prefix.removeLast();
		second.addFirst(headSecond);
		
	}// weaveLists 메서드 종료
	
	
	// main 메서드 
	public static void main(String[] args) {
		
		Tree t = new Tree(3);
		ArrayList<LinkedList<Integer>> result = allSequences(t.root);
		
		for(LinkedList<Integer> l : result) {
			
			for(int data : l) {
				System.out.print(data);
			}
			
			System.out.println();
		}
		
	}// main 메서드 종료
	
}// BinaryTree_Find_Array 클래스 종료
