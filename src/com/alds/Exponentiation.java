package com.alds;

import java.util.Date;

public class Exponentiation {

	public static void main(String[] args) {
		
		System.out.println(pow(2, 10));
		
		int x = 2>>1;
		//int y = x*x;
		System.out.println(x);
		

	}

	private static int pow(int x, int y) {
		return exponentiation2(x , y);
	}
	
	private static int exponentiation(int x, int y, int k, int z) {
		if(k >= y) {
			return z;
		}else {
			k += k;
			
			if(k <= y) {
				z *= z;				
			}else {
				
				for(k = (k/2); k < y; k++) {
					z = z * x;
				}
				
			}
		}
		z = exponentiation(x, y, k, z);
		return z;
	}
	
	private static int exponentiation2(int x, int y) {
		if(y == 0) {
			return 1;
		}else if(y % 2 == 0){
			return exponentiation2(x, y/2) * exponentiation2(x, y/2);
		}else {
			return x * exponentiation2(x, y/2) * exponentiation2(x, y/2);
		}
		
	}
}
