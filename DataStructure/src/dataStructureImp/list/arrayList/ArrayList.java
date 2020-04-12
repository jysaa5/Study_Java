package dataStructureImp.list.arrayList;

//ArrayList: 어레이 리스트 클래스
public class ArrayList {

	//Object 데이터 타입의 배열 생성
	//원래 java의 collection framework의 arraylist의 크기는 고정적이지 않다.
	private Object[] elementData = new Object[100];
	
	//데이터의 개수, 사이즈
	private int size = 0;

	//addLast 메서드: 맨 마지막에 데이터 추가
	public boolean addLast(Object element) {
	
		elementData [size] = element; 
		size++;
		return true; 
	
	}//addLast 종료
	
	
	//add 메서드: 중간에 데이터 추가
	//추가 하고자 하는 인덱스 위치의 부분에 데이터 넣으려면, 그 위치 다음에 있는 데이터들을 모두 뒤로 한 칸씩
	//밀어야 되기 때문에, 일이 많아 진다. -> ArrayList의 단점
	//index: 삽입할 위치, element: 삽입할 데이터
	//Linked List보다 느리다.
	public boolean add(int index, Object element) {
		
		for(int i = size - 1; i >= index; i--) {
			
			elementData[i+1] = elementData[i];
			
		}
		
		//데이터 삽입
		elementData[index] = element;
		//리스트 사이즈 증가
		size ++;
		return true;
	}
	
	//addFirst 메서드: 리스트의 맨 처음에 데이터를 추가하는 메서드
	public boolean addFirst(Object element) {
	
		return add(0, element);
		
	}//addFirst 종료
	
	
	//toString 메서드
	public String toString() {
		
		String str = "[";
		
		for(int i=0; i<size; i++) {
			
			str += elementData[i];
			
			if(i < size-1) {
			str += ",";
			}
		
		}
		
		return str + "]";
	
	}


	//remove 메서드: 데이터 삭제
	//삭제한 값을 반환
	//데이터를 삭제할 때마다 앞으로 당겨야 된다.
	//Linked List보다 느리다.
	public Object remove(int index) {
		
		Object removed = elementData[index];
		
		for(int i= index+1; i <= size-1 ; i++) {
			
			elementData[i-1] = elementData[i];
		
		}
		
		size--;
		elementData[size] = null;
	
		return removed;
	}//remove 종료
	
	
	public Object removeFirst() {
		return remove(0);
	}
	
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	
	//get 메서드: elementData 배열에서 조회
	//ArrayList의 장점: 조회 속도가 빠르다.
	public Object get(int index) {
		return elementData[index];
	}
	
	//외부에서 size값을 변경하지 못하도록 메서드로 만듦.
	//size 메서드: 리스트의 크기를 반환하는 메서드
	public int size() {
		return size;
	}


	//indexOf 메서드: 인자로 들어온 데이터가 어느 위치에 있는지 index를 반환하는 메서드
	public int indexOf(Object o) {
		
		for(int i=0; i<size; i++) {
		
			if(o.equals(elementData[i])) {
				return i;
			}
	
		}
		
		return -1;
	}//indexOf 종료
	
	
	public ListIterator listIterator() {
		
		return new ListIterator();
	}
	
	//ListIterator 클래스
	public class ListIterator{
		
		//next메서드에서 쓰이는 인덱스 값으로 다음에 호출될 데이터의 index값를 갖고 있다.
		private int nextIndex = 0;
		
		//next 메서드
		public Object next() {
//			Object returnData = elementData[nextIndex];
//			nextIndex ++;
//			return returnData;
			
			//현재 nextIndex 값이 반환 되고 나서 증가 한다.
			return elementData[nextIndex++];
		
		}//next 종료
		
		//hasNext 메서드
		public boolean hasNext() {
			
			return nextIndex < size;
		
		}//hasNext 종료
		
	
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
		
		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);
		}
		
		//remove 메서드
		//next() 메서드를 한 번이라도 호출하고 나서야 데이터 삭제가 가능하다.
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex --;
		}
	
	
	}//ListIterator 클래스
	
	
	
}//ArrayList 종료

