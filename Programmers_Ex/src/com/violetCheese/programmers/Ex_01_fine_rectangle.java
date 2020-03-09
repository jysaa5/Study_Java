package com.violetCheese.programmers;

public class Ex_01_fine_rectangle {

    public static long solution(long w, long h){
        long width = w; 
        long height = h;
        long num_small = 0;
        long i = 0;
        long gcd = 0;
        long answer;
        
        if(width>height){
            num_small = height;
        }else{
            num_small = width;
        }
        
        for(i = num_small; i>0 ; i--){
            if((width%i==0)&&(height%i==0)){
                gcd = i;
                break;
            }
        }
        
     answer = (width*height) - (width+height-gcd); 
        
        return answer;
       
    }
    
    //test
    public static void main(String[] args) {
    	System.out.print(solution(8, 12));
    }
	
}
