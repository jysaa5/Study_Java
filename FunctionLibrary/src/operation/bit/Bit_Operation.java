package operation.bit;
/*
1. 비트 연산(Bit Operation)
1) Digital Storage
- 어떤 데이터든 컴퓨터에 저장될 때는 전부 다 0과 1로 저장된다.
- HDD, CD

2) Integer(정수)
- 4bytes = 32 bits
- int i = 8
|0|0|0|0|0|0|0|0|0|...0|0|0|0|0|1|0|0|0|
- 4bytes = 32 bits = 2^32 개
- 최대값= (2^32) -1 = unsigned
- signed = -(2^31) ~ (2^31) -1

3) logical right shift: >>>
- 부호와 상관없이 모든 비트를 right shift하고 앞 부분을 0으로 세팅

4) arithmetic right shift: >>
- 부호에 상관있게 모든 비트를 right shift하고 앞 부분을 1로 세팅

5) clear Left Bits
1 0 0 0 = 1 << 3
0 1 1 1 = 1 0 0 0 - 1 
-> not을 하면 앞에 있는 비트들도 다 변하므로 1을 빼는 것이다.

6) clear Right Bits
1111...1111 = -1
1111...0000 = -1 << (3+1) 
-> i번째부터 오른쪽에 있는 비트를 0으로 세팅해야 하므로 i+1 만큼 시프트 해야 된다.

7) update Bit (비트를 업데이트)
int num = 169;
int i = 3;
boolean val = true;

  x x x x x x x
& 1 1 1 0 1 1 1
---------------------
  x x x 0 x x x
| 0 0 0 y 0 0 0 
----------------------
  x x x y x x x
 
*/
public class Bit_Operation {
	
	// i번째 자리가 1인지 0인지 판별
	static boolean getBit(int num, int i) {
		
		return (num&(1<<i)) != 0;
	
	}
	
	
	// i번째 자리를 1로 세팅
	static int setBit(int num, int i) {
		return num | (1<<i);
	}
	
	
	// i번째 자리를 0으로 세팅
	static int clearBit(int num, int i) {
		return num & ~(1<<i);
	}
	
	
	// i번째의 왼쪽에 있는 비트들을 0으로 세팅
	static int clearLeftBits(int num, int i) {
		return num & ((1<<i)-1);
	}
	
	
	// i번째의 오른쪽에 있는 비트들을 0으로 세팅
	static int clearRightBits(int num, int i) {
		return num & (-1<<(i+1));
	}
	
	
	// num: 숫자
	// i: 인덱스
	// val: 어떤 값으로 세팅할지
	static int updateBit(int num, int i, boolean val) {
		
		return((num & ~(1<<i)) | ((val? 1:0)<<i));
		
	}
	
	
	public static void main(String[] args) {
		// 1 0 0 1
		System.out.println(getBit(9,3));
		
		// 0 1 0 1
		System.out.println(getBit(5,3));
		
		// 0 1 0 1 -> 1 1 0 1
		System.out.println(setBit(5,3));
		
		// 1 0 0 1 -> 0 0 0 1
		System.out.println(clearBit(9,3));
		
		// 10101001 -> 00000001
		System.out.println(clearLeftBits(169,3));
		
		// 10101001 -> 10100000
		System.out.println(clearRightBits(169,3));
		
		// 10101001 -> 10100001
		System.out.println(updateBit(169,3,false));
		
	}

}
