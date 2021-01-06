package com.alds;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_20200827 {

	public static void main(String[] args) {
		int[] arr = {3,0,1,3,0,5};
		//System.out.println(findWater(arr, arr.length));
		System.out.println(-21 < -11);
	}
	
	public static int calculate(int[] arr) {
		int total = 0;
		Deque<Integer> brkQueqe = new ArrayDeque<>();
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < max) {
				brkQueqe.push(arr[i]);
			}else if(arr[i] >= max){
				while(!brkQueqe.isEmpty()) {
					total += max - (int)brkQueqe.pop();
					//System.out.println(total);
				}
				 max = arr[i];
			}
		}
		return total;
	}
	
	public static int findWater(int[] arr, int n)
    {
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[n];
 
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
 
        // Initialize result
        int water = 0;
 
        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);
 
        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);
 
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];
 
        return water;
    }

}
