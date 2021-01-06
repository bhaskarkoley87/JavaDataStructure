package com.alds;

public class LinkedListProblems {

	public static void main(String[] args) {
		Node<String> node5 = new Node<String>("6", null);
		Node<String> node4 = new Node<String>("5", node5);
		Node<String> node3 = new Node<String>("4", node4);
		Node<String> node2 = new Node<String>("3", node3);
		Node<String> node1 = new Node<String>("2", node2);
		Node<String> rootNode = new Node<String>("1", node1);	
		Node<String> crntNode = rootNode;
		while(crntNode != null) {
			System.out.print(crntNode.data+" ");
			crntNode = crntNode.nextNode;
		}
		System.out.print("\n\n");
		
		Node<String> finalList = reverceNode2(rootNode, 4);
		crntNode = finalList;
		while(crntNode != null) {
			System.out.print(crntNode.data+" ");
			crntNode = crntNode.nextNode;
		}
		
	}
	
	public static Node removeNode(Node rootNode, int n) {
		int size = 0;
		int i = 1;
		Node<String> crntNode = rootNode;
		
		while(crntNode != null) {
			size++;
			crntNode = crntNode.nextNode;
		}
		
		crntNode = rootNode;
		for(; (size - i) > n; i++) {
			
			crntNode = crntNode.nextNode;			
		}
		
		crntNode.nextNode = crntNode.nextNode.nextNode;	
		
		
		return rootNode;
	}
	
	public static Node reverceNode2(Node rootNode, int n) {
		
		int size = 0;
		int i = 1;
		Node<String> crntNode = rootNode;
		
		while(crntNode != null) {
			size++;
			crntNode = crntNode.nextNode;
		}
		
		crntNode = rootNode;
		for(; (size - i) > n; i++) {
			
			crntNode = crntNode.nextNode;			
		}
		
		crntNode.nextNode = reverceNode(crntNode.nextNode);	
		
		
		return rootNode;
	}
	
	public static Node reverceNode(Node rootNode) {
		if(rootNode == null) {
			return rootNode;
		}
		
		if(rootNode.nextNode == null) {
			return rootNode;
		}
		System.out.println("==============");
		System.out.println(rootNode.nextNode.data);
		Node<String> newHeadNode = reverceNode(rootNode.nextNode);
		
		System.out.println(rootNode.nextNode.nextNode.data);
		System.out.println(rootNode.data);
		rootNode.nextNode.nextNode = rootNode;
		rootNode.nextNode = null;
		
		return newHeadNode;
	}
	
	
	
	static class Node<T>{
		T data;
		Node nextNode;
		
		Node addNode(Node node) {
			this.nextNode = node;
			return this;
		}
		
		Node(T data, Node nextNode){
			this.data = data;
			this.nextNode = nextNode;
		}
	}

}
