package com.violetCheese.intermediate;

import java.util.ArrayList;
import java.util.List;

public class Ex_66_CarExam {
	  public static void main(String[] args){
	        //Car객체를 만들어서 cars에 넣습니다.
	        List<Ex_62_Car> cars = new ArrayList<>();
	        cars.add( new Ex_62_Car("작은차",2,800,3) );
	        cars.add( new Ex_62_Car("봉고차",12,1500,8) );
	        cars.add( new Ex_62_Car("중간차",5,2200,0) );
	        cars.add( new Ex_62_Car("비싼차",5,3500,1) );
	        
	        Ex_66_CarExam carExam = new Ex_66_CarExam();
	        carExam.printCar(cars, 
	            //인터페이스 CheckCar의 test메소드에 대응하는 람다를 만듭니다.
	            (Ex_62_Car car) -> { return car.capacity >= 4 && car.price < 2500; }
	        );
	    }
	    
	    public void printCar(List<Ex_62_Car> cars, CheckCar tester){
	        for(Ex_62_Car car : cars){
	            if (tester.test(car)) {
	                System.out.println(car);
	            }
	        }
	    }
	    
	    interface CheckCar{
	        boolean test(Ex_62_Car car);
	    }  
}
