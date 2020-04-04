package dataStructureImp.table.hashTable;

import java.util.LinkedList;

//1. HashTable 선언
class HashTable {

	// 2. HashTable에 저장할 데이터를 담는다.
	class Node {
		// 검색어: 키
		String key;
		// 검색 결과
		String value;

		// 생성자 생성
		public Node(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		// value를 가져온다. = get 함수
		String value() {
			return value;
		}

		// value를 저장한다. = set 함수
		void value(String value) {
			this.value = value;
		}

	}//Node 종료

	// 데이터를 저장할 리스트를 배열로 선언 -> 배열에 저장될 데이터의 타입을 LinkedList로 만든다.
	LinkedList<Node>[] data;

	//해시 테이블을 만드는 순간 배열방을 얼마만큼 고정된 방을 만들지 미리 선언
	HashTable(int size) {
		this.data = new LinkedList[size];
	}

	//기본적으로 중요한 함수
	//1.해시 알고리즘 함수
	//해시 알고리즘을 갖고 있는 함수: 키를 받아서 해시코드를 반환한다.
	int getHashCode(String key) {
		int hashcode = 0;
		//키 값의 아스키코드를 가져와서 덧셈하는 해시 알고리즘
		for(char c: key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
		
	}//getHashCode 종료
	
	//2.hashcode를 받아서 배열 방의 index를 받은 함수
	int convertToIndex(int hashcode) {
		
		return hashcode % data.length;
	
	}//convertToIndex 종룐
	
	
	//3. 검색 시, index로 배열 방을 찾은 이후에 배열 방 안에 노드가 여러개 존재 할 때, 검색 키로 해당 노드를 찾아오는 함수
	Node searchkey(LinkedList<Node> list, String key) {
		//배열 방이 null일때
		if(list ==null) {
			return null;
		}
		//배열 방을 돈다.
		for(Node node: list) {
			//key값을 비교하면서 node를 찾는다.
			if(node.key.equals(key)) {
				return node;
			}
			
		}
		return null;
	}//searchkey 종료
	
	//4.데이터를 받아서 저장하는 함수
	void put(String key, String value) {
		//해시 코드
		int hashcode = getHashCode(key);
		//배열 방 번호
		int index = convertToIndex(hashcode);
		
		//출력
		System.out.println(key +", hashcode("+ hashcode +"), index(" + index+")");
		
		//배열 방 번호를 이용해서 기존에 있는 데이터를 가져온다.
		LinkedList<Node> list = data[index];
		
		//배열이 null일 때.
		if(list == null) {
			list= new LinkedList<Node>();
			data[index] = list;
		}
		
		//배열방에 해당 키로 노드를 가져온다. 
		Node node = searchkey(list, key);
		
		//노드가 null이면 데이터가 없다는 뜻이다.
		if(node == null) {
			//받아온 정보를 가지로 노드 객체를 생성한다.
			list.addLast(new Node(key, value));
		}else {
			
			//노드가 null이 아닌 경우에는 해당 값으로 덮어쓰기해서 중복키 처리
			node.value(value);
			
		}
		
	}//put 종료
	
	
	//5.키를 가지고 데이터를 가져오는 함수
	String get(String key) {
		
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		
		Node node = searchkey(list, key);
		
		return node == null? "Not found": node.value();
		
	}//get 종료
	
}//HashTable 종료

//Hash_Table_01 클래스
public class Hash_Table_01 {
	
	//main 메서드
	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		
		h.put("sung", "She is pretty");
		h.put("jin", "She is a model");
		h.put("hee", "She is an angel");
		h.put("min", "She is cute");
		
		//덮어쓰기 
		h.put("sung", "She is beautiful");
		
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		
		//없는 데이터 호출
		System.out.println(h.get("jae"));
		
	}//main 종료

}//Hash_Table_01 종료
