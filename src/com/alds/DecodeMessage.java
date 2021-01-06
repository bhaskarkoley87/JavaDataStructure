package com.alds;

import java.util.Arrays;

public class DecodeMessage {

	public static void main(String[] args) {
		String data = "12";
		System.out.println(num_ways_dp(data.toCharArray()));
	}
	
	public static int num_ways_dp(char[] data) {
		int counter = 0;
		
		return helper_do(data, data.length, new int[data.length+1]);
		
	}

	private static int helper_do(char[] data, int length, int[] memo) {
		if(length == 0)
			return 1;
		int s = data.length - length;
		
		if(data[s] == '0')
			return 0;	
		
		if(memo[length] != 0)
			return memo[length];
		
		int result = helper_do(data, length - 1, memo);
		
		if(length >= 2 && Integer.valueOf(data[s]+""+data[s+1]) <= 26 ) {
			result += helper_do(data, length - 2, memo);			
		}
		
		memo[length] = result;
		return result;
	}
	
	// Given a digit sequence of length n, 
	// returns count of possible decodings by 
	// replacing 1 with A, 2 woth B, ... 26 with Z 
	/*static int countDecoding(char[] digits, int n, int counter)  
	{ 
		//System.out.println("Run-"+counter + ": "+Arrays.toString(digits) + " | "+n);
	    // base cases 
	    if (n == 0 || n == 1) 
	       return 1; 
	  
	    // for base condition "01123" should return 0    
	    if (digits[0]=='0')    
	         return 0; 
	  
	    // Initialize count 
	    int count = 0;  
	  
	    // If the last digit is not 0, then  
	    // last digit must add to 
	    // the number of words 
	    if (digits[n - 1] > '0') 
	    count = countDecoding(digits, n - 1, counter+1); 
	  
	    // If the last two digits form a number 
	    // smaller than or equal to 26, 
	    // then consider last two digits and recur 
	    //System.out.println("Runs-"+counter + ": "+Arrays.toString(digits) + " | "+n+ " | count: "+count);
	    if (digits[n - 2] == '1' ||  
	       (digits[n - 2] == '2' && digits[n - 1] < '7')) 
	    count += countDecoding(digits, n - 2, counter+1); 
	  
	    return count; 
	} */
	
	

}
