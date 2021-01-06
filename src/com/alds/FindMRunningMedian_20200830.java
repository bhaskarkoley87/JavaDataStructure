package com.alds;

public class FindMRunningMedian_20200830 {

	public static void main(String[] args) {
		int[] arr = {5, 15, 10, 20, 3};
		findMedian(arr);		
	}
	
	public static void findMedian(int[] arr) {		
       
		int[] shrtArr = new int[arr.length];
		int i = 0;
		shrtArr[0] = arr[0];
		System.out.println((double)arr[0]);
		for(int x = 1; x < arr.length; x++) {
			
			int z = x;
			while(z > 0 && shrtArr[z - 1] > arr[x]) {
				shrtArr[z] = shrtArr[z - 1];
				z--;
			}
			shrtArr[z] = arr[x];
		
			
			int a = 0;			
			if((x+1)%2 == 1) {
				a = (int)Math.floor(((x + 1) / 2));
				System.out.println((double)shrtArr[a]);
			}else {				
				a = (int)Math.floor((x + 1) / 2);
				int sum = shrtArr[a] + shrtArr[a - 1];				
				Double b =  (double)sum / 2;
				System.out.println(b);
				
			}
			
			
		}
	}

}
