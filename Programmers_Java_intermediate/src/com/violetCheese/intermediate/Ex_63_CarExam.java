package com.violetCheese.intermediate;

import java.util.*;

public class Ex_63_CarExam {
	public static void main(String[] args) {
		// Car객체를 만들어서 cars에 넣습니다.
		List<Ex_62_Car> cars = new ArrayList<>();
		cars.add(new Ex_62_Car("작은차", 2, 800, 3));
		cars.add(new Ex_62_Car("봉고차", 12, 1500, 8));
		cars.add(new Ex_62_Car("중간차", 5, 2200, 0));
		cars.add(new Ex_62_Car("비싼차", 5, 3500, 1));

		printCarCheaperThan(cars, 2000);
	}

	public static void printCarCheaperThan(List<Ex_62_Car> cars, int price) {
		for (Ex_62_Car car : cars) {
			if (car.price < price) {
				System.out.println(car);
			}
		}
	}
}
