package com.netmind.business;

public class Pares {

	public int sumaDePares(int[] intArray) {

	int result = 0;
		
		for (int i=0; i<intArray.length; i+=2) {
	        result += intArray[i];            
		}
		
		return result;
	    
	    

	}

}
