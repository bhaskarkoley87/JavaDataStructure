package com.alds;

public class FindTheIntrestingNodes_20200817 {

	public static void main(String[] args) {
		int arr1[] = {3,7,8,10};
		int arr2[] = {99,1,8,10};
		//System.out.println(findIntrestingElemetWithArray(arr1, arr2));
		
		
		Nodes node1 = new Nodes(3, new Nodes(7, new Nodes(8, new Nodes(10, null))));
		Nodes node2 = new Nodes(99, new Nodes(1, new Nodes(8, new Nodes(10, null))));
		
		System.out.println(findIntrestingElemet(node1, node2));
	}

	public static int findIntrestingElemetWithArray(int arr1[], int arr2[]) {
		int intrestingValue = 0;
		if (arr1 == null || arr2 == null || arr1.length <= 0 || arr2.length <= 0) {
			return 0;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				intrestingValue = arr1[i];
				break;
			}
		}
		return intrestingValue;
	}
	
	public static int findIntrestingElemet(Nodes node1, Nodes node2) {
		int intrestingValue = 0;
		
		if(node1 != null && node2 != null) {
			if((int)node1.data == (int)node2.data) {
				return (int)node1.data;
			}else if(node1.addNode() != null && node2.addNode() != null) {
				return findIntrestingElemet(node1.addNode(), node2.addNode());				
			}
		}
		
		return intrestingValue;
	}

}

class Nodes{
	int data;
	Nodes next;
	
	public Nodes(int data, Nodes next) {
		this.data = data;
		this.next = next;
	}
	
	public boolean addNode(Nodes next) {
		this.next = next;
		return true;
	}
	
	public Nodes addNode() {
		return this.next;	
	}
	
	public String toString() {
		return String.valueOf(data);
	}
}
