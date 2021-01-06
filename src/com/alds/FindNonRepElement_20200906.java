package com.alds;

public class FindNonRepElement_20200906 {

	public static void main(String[] args) {
		int[] data = {2, 1, 1, 2, 1, 2, 3};
		
		int ans = getSingle(data, 7);
		System.out.println("---------------------");
		System.out.println(ans);

	}
	
	public static int getSingle(int[] data, int n) {
		int ones = 0, twos = 0;
		int common_bit_mask;
		
		for(int i = 0; i < n ; i++) {
			twos = twos | (ones & data[i]);
			//System.out.println(twos);
			
			ones = ones ^ data[i];
			//System.out.println(twos);
			
			common_bit_mask = ~(ones & twos);
			//System.out.println(common_bit_mask);
			
			ones &= common_bit_mask;
			//System.out.println(ones);
			
			twos &= common_bit_mask;
			//System.out.println(twos);
		}
		return ones;
	}

}
