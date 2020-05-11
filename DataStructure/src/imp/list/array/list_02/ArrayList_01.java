package imp.list.array.list_02;

// Array (배열)
// PHP -> Dynamic
// Java -> fixed

// ArrayList: 검색 시간 = O(1)
// 배열방이 다 차면 배열 방의 2배 큰 크기로 늘린다. 
// 이전에 있던 데이터를 다시 복사하는 작업 = Doubling, 복사 시간 = O(n)
// 입력 시간 = O(1)

class ArrayList{
	// 배열에 들어갈 데이터
	private Object[] data;
	// 배열의 크기
	private int size;
	// 다음 데이터를 추가할 위치를 기억하는 변수
	private int index;
	
	// 생성자
	public ArrayList() {
		this.size = 1;
		this.data = new Object[this.size];
		this.index = 0;
	}
	
	// add 메서드 
	public void add(Object obj) {
		
		System.out.println("index: "+this.index+", size: "+ this.size +", data size:"+this.data.length);
		
		// 배열방이 다 찼을 때
		if(this.index == this.size -1) {
			doubling();
		}
		
		// 공간이 있을 때
		data[this.index] = obj;
		this.index++;
		
	}// add 메서드 종료
	
	
	// doubling 메서드
	private void doubling() {
		// 사이즈 2배로 늘리기
		this.size = this.size*2;
		
		Object[] newData = new Object[this.size];
		
		// 현재 배열방을 돌면서 복사 붙이기
		for(int i = 0; i<data.length; i++) {
			
			newData[i] = data[i];
		
		}
		
		this.data = newData;
		System.out.println("*** index: "+this.index+", size: "+ this.size +", data size:"+this.data.length);
	}// doubling 메서드 종료
	
	
	// get 메서드: 인덱스 번호를 가지고 데이터를 가져오는 메서드 
	public Object get(int i) throws Exception{
		
		// 인덱스가 배열방의 범위 밖일 때
		if(i > this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i < 0) {
			throw new Exception("Negative Value");
		}
		
		return this.data[i];
		
	}// get 메서드 종료
	
	
	public void remove(int i) throws Exception{
		
		if(i>this.index-1) {
			throw new Exception("ArrayIndexOutOfBound");
		}else if(i<0) {
			throw new Exception("Negative Value");
		}
		
		System.out.println("data removed: "+ this.data[i]);
		// 뒤에 있는 데이터를 앞으로 시프트
		for(int x = i; x <this.data.length-1; x++) {
			data[x] = data[x+1];
		}
		this.index --;
	}
	
}// ArrayList 클래스 


// ArrayList_01 클래스
public class ArrayList_01 {
	
	// main 메서드
	public static void main(String[] args) throws Exception{
		ArrayList al = new ArrayList();
		al.add("0");
		al.add("1");
		al.add("2");
		al.add("3");
		al.add("4");
		al.add("5");
		al.add("6");
		al.add("7");
		al.add("8");
		al.add("9");
		System.out.println(al.get(5));
		al.remove(5);
		System.out.println(al.get(5));
	}// ArrayList_01 메서드 종료

}// ArrayList_01 클래스 종료