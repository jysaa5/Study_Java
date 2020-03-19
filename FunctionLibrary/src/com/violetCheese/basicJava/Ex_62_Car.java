package com.violetCheese.basicJava;

public class Ex_62_Car {
	// 이어지는 예제에서 사용할 Car클래스입니다.
	// 이름, 탑승인원, 가격, 사용년수를 필드로 가집니다.
	public String name;
	public int capacity;
	public int price;
	public int age;

	// 각각의 필드를 생성자에서 받아서 초기화합니다.
	public Ex_62_Car(String name, int capacity, int price, int age){
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.age = age;
    }

	// Car 객체를 문자열로 출력하면 이름을 출력합니다.
	public String toString() {
		return name;
	}

	public static void main(String args[]) {
		Ex_62_Car car = new Ex_62_Car("new model", 4, 3000, 0);
	}
}
