package com.alds;

public class SquareRootOfNumber {

	public static void main(String[] args) {
		System.out.println(floorSqrt(2147395600));		
	}
	
	public static int floorSqrt(long x) 
    { 
		//System.out.println(x);
        // Base cases 
        if (x == 0 || x == 1) 
            return (int)x; 
  
        // Staring from 1, try all numbers until 
        // i*i is greater than or equal to x. 
        long i = 1, result = 1; 
          
        while (result <= x) {        	
        	
            i = i + 1; 
            result = i * i; 
        } 
        return (int)i - 1; 
    }  

}
