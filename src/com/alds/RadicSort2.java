package com.alds;

public class RadicSort2 {

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;

		// Function Call
		radixsort(arr, n);
		print(arr, n);

	}
	
	private static void radixsort(int[] arr, int n) {
		int max = max(arr, n);
		
		for(int ext = 1; max / ext > 0; ext *= 10) {
			sort(arr, ext*10, ext);
		}
	}
	
	private static int max(int[] arr, int n) {
		int max = 0;
		for(int x = 0; x < n; x++) {
			if(arr[x] > max)
				max = arr[x];
		}
		
		return max;
	}
	
	private static void sort(int[] arr, int ext, int n) {
		//System.out.println("ext :: "+ext+"  ||  n :: "+n);
		 
		Object[] count = new Object[10];
		
		int[] result = new int[arr.length];
		
		for(int x = 0; x < arr.length; x++) {
			int crnt = (arr[x] % ext) / n;
			//System.out.println("crnt :: "+crnt);
			Object elem = count[crnt];
			Node nd = new Node(arr[x], null);
			if(elem == null)
				count[crnt] = nd;
			else {
				Node root = (Node)elem;
				//System.out.println("Elemnt :: "+root.value);
				while(root.next != null) {
					root = (Node)root.next;
					//System.out.println("Elemnt :: "+root.value);
				}
				root.next = nd;
			}
		}
		
		int y = 0;
		for(int i = 0; i < 10; i++) {
			Object elem = count[i];
			if(elem != null) {
				Node root = (Node)elem;				
				result[y] = root.value;
				y++;
				while(root.next != null) {
					root = (Node)root.next;
					result[y] = root.value;
					y++;
				}

				
				
			}
		}
		
		
		
		for(int x = 0; x < arr.length; x++) {
			arr[x] = result[x];
		}
	}
	
	static class Node{
		int value;
		Object next;
		
		public Node(int value, Object next) {
			this.value = value;
			this.next = next;
		}
	}
	
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
