package Chapter03;

public class Array {
	
	// ¹è¿­
	
	int getMaxNum(int[] array) {
		int ret = array[0];
		
		for(int i=1; i<array.length; i++) {
			
			if(ret<array[i]) {
				ret = array[i];
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};
		
		Array ar = new Array();
		
		System.out.println(ar.getMaxNum(array));
		
	}

}
