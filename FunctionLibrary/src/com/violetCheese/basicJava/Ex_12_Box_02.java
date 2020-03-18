package com.violetCheese.basicJava;

//제네릭 설정 방법: 클래스 뒤쪽에 < > 
//<E>가 정해진 것은 아니다.
public class Ex_12_Box_02<E> {
	private E obj;

	// set 메서드
	public void setObj(E obj) {
		this.obj = obj;

	}

	// get 메서드
	public E getObj() {
		return obj;
	}

}
//박스는 가상 클래스 E를 사용하겠다는 의미.
//E는 실제로 존재하는 클래스는 아니다.
//선언할때는 가상으로 만들고 실제 사용할때는 구체적으로 정해서 만든다. 