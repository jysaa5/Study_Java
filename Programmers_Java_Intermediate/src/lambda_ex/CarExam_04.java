package lambda_ex;

import java.util.ArrayList;
import java.util.List;

public class CarExam_04 {
	  public static void main(String[] args){
	        //Car객체를 만들어서 cars에 넣습니다.
	        List<Car> cars = new ArrayList<>();
	        cars.add( new Car("작은차",2,800,3) );
	        cars.add( new Car("봉고차",12,1500,8) );
	        cars.add( new Car("중간차",5,2200,0) );
	        cars.add( new Car("비싼차",5,3500,1) );
	        
	        CarExam_04 carExam = new CarExam_04();
	        carExam.printCar(cars, 
	            //인터페이스 CheckCar의 test메소드에 대응하는 람다를 만듭니다.
	            (Car car) -> { return car.capacity >= 4 && car.price < 2500; }
	        );
	    }
	    
	    public void printCar(List<Car> cars, CheckCar tester){
	        for(Car car : cars){
	            if (tester.test(car)) {
	                System.out.println(car);
	            }
	        }
	    }
	    
	    interface CheckCar{
	        boolean test(Car car);
	    }  
}
