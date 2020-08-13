package chapter12.enumEx;
// p.700

enum Transportation_01{
	BUS(100){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	TRAIN(150){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	SHIP(100){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	},
	
	AIRPLANE(300){
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
	};
	
	//protected로 해야 각 상수에서 접근가능
	protected final int BASIC_FARE;
	
	// private Transportation(int basicFare)
	Transportation_01 (int basicFare){
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() {
		return BASIC_FARE;
	}
	
	// 거리에 따른 요금 계산
	abstract int fare(int distance);
}



abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T>{
	static int id = 0;
	int ordinal;
	String name = "";
	
	public int ordinal() {
		return ordinal;
	}
	
	MyEnum(String name){
		this.name = name;
		ordinal = id++;
	}
	
	public int compareTo(T t) {
		return ordinal - t.ordinal();
	}
}


abstract class MyTransportation_01 extends MyEnum{
	static final MyTransportation_01 BUS = new MyTransportation_01("BUS", 100) {
		
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
		
	};
	
	static final MyTransportation_01 TRAIN = new MyTransportation_01("TRAIN", 150) {
		
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
		
	};
	
	static final MyTransportation_01 SHIP = new MyTransportation_01("SHIP", 100) {
		
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
		
	};
	
	static final MyTransportation_01 AIRPLANE = new MyTransportation_01("AIRPLANE", 300) {
		
		int fare(int distance) {
			return distance*BASIC_FARE;
		}
		
	};
	
	// 추상 메서드
	abstract int fare(int distance);
	
	
	protected final int BASIC_FARE;
	
	private MyTransportation_01(String name, int basicFare) {
		super(name);
		BASIC_FARE = basicFare;
	}
	
	public String name() {return name;}
	public String toString() {return name;}
}


public class Enum_04 {
	
	public static void main(String[] args) {
		MyTransportation_01 t1 = MyTransportation_01.BUS;
		MyTransportation_01 t2 = MyTransportation_01.BUS;
		MyTransportation_01 t3 = MyTransportation_01.TRAIN;
		MyTransportation_01 t4 = MyTransportation_01.SHIP;
		MyTransportation_01 t5 = MyTransportation_01.AIRPLANE;
		
		System.out.printf("t1=%s, %d%n", t1.name(), t1.ordinal());
		System.out.printf("t1=%s, %d%n", t2.name(), t2.ordinal());
		System.out.printf("t1=%s, %d%n", t3.name(), t3.ordinal());
		System.out.printf("t1=%s, %d%n", t4.name(), t4.ordinal());
		System.out.printf("t1=%s, %d%n", t5.name(), t5.ordinal());
		System.out.println("t1==t2?"+(t1==t2));
		System.out.println("t1.comparTo(t3)="+t1.compareTo(t3));
	}

}
