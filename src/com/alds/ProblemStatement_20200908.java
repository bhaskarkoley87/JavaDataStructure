package com.alds;

import java.util.ArrayList;
import java.util.List;

public class ProblemStatement_20200908 {

	public static void main(String[] args) {
		int[] S = {12, 1, 61, 5, 9, 2};
		int K = 24;
		getSet(S, S.length, K);

	}
	
	public static void getSet(int[] set, int size, int k) {
		long powSetSize = (long) Math.pow(2, size);
		int count, j, total = 0;
		List<Integer> list = new ArrayList<>();
		
		for(count = 0; count < powSetSize; count++) {
			list = new ArrayList<>();
			total = 0;
			for(j = 0; j < size; j++) {					
				if((count & (1 << j)) > 0) {					
					list.add(set[j]);
					total += set[j];
				}
			}	
			
			if(total == k) {
				System.out.println(list);
				break;
			}
		}
	}

}
