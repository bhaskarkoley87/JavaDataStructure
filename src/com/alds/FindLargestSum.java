package com.alds;

public class FindLargestSum {

	public static void main(String[] args) {
		int[] data = { 2, 4, 1, 2, 9, 3 };
		// 0 , 2 , 4 , 3 , 2 , 2 , 3
		/*
		 * 0,2 - 0,4 ex = 4 2,1 - 4,2 ex = 6 4,3,3 - 4,9 ex = 9
		 */
		System.out.println(FindMaxSum(data, data.length));
		// System.out.println(findSum(data));
	}

	public static int findSum(int[] data) {
		int val = 0;
		int totalCount = 0;

		for (int x = 0; x < data.length; x++) {
			int nextInterval = 2;
			int currentVal = data[x];
			int y = x + nextInterval;
			while (y < data.length) {
				// System.out.print("currentVal ("+currentVal+" + "+data[y]+") : ");
				currentVal += data[y];
				// System.out.print(currentVal+"\n");
				if (val < currentVal) {
					val = currentVal;
				}
				totalCount++;
				// System.out.println(y + " | " + (data.length - 1));
				if (y + nextInterval > data.length - 1) {
					nextInterval++;
					y = x + nextInterval;
					currentVal = data[x];
				} else {
					y = y + nextInterval;
				}
			}
		}

		System.out.println("totalCount : " + totalCount);

		return val;
	}

	/*
	 * Algorithm: 
	 * -------------
	 * Loop for all elements in arr[] and maintain two sums incl and excl
	 * where incl = Max sum including the previous element and excl = Max sum
	 * excluding the previous element.
	 *
	 * Max sum excluding the current element will be max(incl, excl) and max sum
	 * including the current element will be excl + current element (Note that only
	 * excl is considered because elements cannot be adjacent).
	 *
	 * At the end of the loop return max of incl and excl.
	 */

	// geeksforgeeks.org Solution
	public static int FindMaxSum(int arr[], int n) {
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			System.out.println("i : " + i + " | incl : " + incl + " | excl : " + excl);
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			System.out.println("excl : " + excl + " | arr[i] : " + arr[i]);
			incl = excl + arr[i];
			System.out.println("incl : " + incl);
			excl = excl_new;
		}
		System.out.println(i);
		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}
}
