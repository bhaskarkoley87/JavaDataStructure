package com.alds;

public class ArraySwap_20200901 {

	public static void main(String[] args) {
		char[] arr = {'B', 'G', 'B', 'R', 'G', 'B', 'R', 'R', 'G', 'B', 'R', 'B', 'G'};
		char[] srtArr = arrangeArray(arr);
		System.out.print('[');
		for(char c : srtArr) {
			System.out.print(c+", ");
		}
		System.out.print(']');
	}
	
	public static char[] arrangeArray(char[] arr) {
		int mid = 0;
		int low = 0;
		int high = arr.length - 1;
		int count = 1;
		while(mid <= high) {
			System.out.println(count);
			if(arr[mid] == 'R') {
				char e = arr[mid];
				arr[mid] = arr[low];
				arr[low] = e;
				++mid;
				++low;
			}else if(arr[mid] == 'B') {
				char e = arr[mid];
				arr[mid] = arr[high];
				arr[high] = e;
				--high;
			}else {
				++mid;
			}
			count = count + 1;
		}
		
		return arr;
	}
}
