package com.violetCheese.programmers;
import java.util.Arrays;

public class Ex_03_Incomplet_Players {
	

	 public static String solution(String[] participant, String[] completion) {
		 
		 String[] p = participant;
	     String[] c = completion;
	     String[] check = Arrays.copyOf(p,c.length);
	     String player = "";
	        
	        for(int i=0; i<c.length; i++){
	            for(int j=0; j<c.length; j++){
	                  
	                if(check[i].equals(c[j])){
	                    check[i] = "0";
                        c[j] ="0";
	                    break;
	                }
	            }
	        }
	            for(int k=0; k<c.length; k++){
	                if(!check[k].equals("0")){
	                    player = check[k];
                        break;
	                }else if(k == c.length-1){
	                	player = p[p.length-1];
                         break;
	                }
	            }
	 
	        return player;
	    }
	
	

}
