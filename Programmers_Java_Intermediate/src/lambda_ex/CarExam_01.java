package lambda_ex;

import java.util.*;

public class CarExam_01 {
	public static void main(String[] args) {
		// Car객체를 만들어서 cars에 넣습니다.
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("작은차", 2, 800, 3));
		cars.add(new Car("봉고차", 12, 1500, 8));
		cars.add(new Car("중간차", 5, 2200, 0));
		cars.add(new Car("비싼차", 5, 3500, 1));

		printCarCheaperThan(cars, 2000);
	}

	public static void printCarCheaperThan(List<Car> cars, int price) {
		for (Car car : cars) {
			if (car.price < price) {
				System.out.println(car);
			}
		}
	}
}
