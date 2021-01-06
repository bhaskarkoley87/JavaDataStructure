package com.alds;

public class FindMaxSumofSubString {

	public static void main(String[] args) {
		int[] arr = {-32, -56, -42, -14, -86, 1, -15};
		
		System.out.println(getMaxSum(arr));
	}
	
	public static int getMaxSum(int[] arr) {
		int max_sum = 0;
		int max_sum_till = 0;
		
		for(int x = 0; x < arr.length; x++) {
			max_sum_till += arr[x];
			
			if(max_sum <= max_sum_till)
				max_sum = max_sum_till;
			
			if(max_sum_till < 0)
				max_sum_till = 0;
		}
		
		return max_sum;
	}

}
/*
 * 56 + 86 + 4 = 56 + 90 = 146
 * 142
 */
