package com.bhk.tree;

public class BinaryTree {
	
	public static void main(String[] arr) {
		
		Node<String> leefNode1 = new Node<String>("X", null, null);
		Node<String> leefNode2 = new Node<String>("Y", null, null);
		Node<String> leefNode3 = new Node<String>("Z", null, null);
		Node<String> leefNode4 = new Node<String>("U", null, null);
		Node<String> leefNode5 = new Node<String>("V", null, null);
		Node<String> leefNode6 = new Node<String>("W", null, null);
		Node<String> leefNode7 = new Node<String>("S", null, null);
		Node<String> leefNode8 = new Node<String>("T", null, null);
		
		Node<String> lvl2Node1 = new Node<String>("L", leefNode1, leefNode2);
		Node<String> lvl2Node2 = new Node<String>("M", leefNode3, leefNode4);
		Node<String> lvl2Node3 = new Node<String>("N", leefNode5, leefNode6);
		Node<String> lvl2Node4 = new Node<String>("O", leefNode7, leefNode8);
		
		
		Node<String> lvl1Node1 = new Node<String>("P", lvl2Node1, lvl2Node2);
		Node<String> lvl1Node2 = new Node<String>("Q", lvl2Node3, lvl2Node4);
		
		Node<String> rootNode = new Node<String>("A", lvl1Node1, lvl1Node2);
		
		BinaryTree bt = new BinaryTree();
		bt.postOrder(rootNode);
	}
	
	public void preOrder(Node node) {
		if(node != null) {
			System.out.println(node.toString());
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}
	
	public void inOrder(Node node) {
		if(node != null) {			
			inOrder(node.leftNode);
			System.out.println(node.toString());
			inOrder(node.rightNode);
		}
	}
	
	public void postOrder(Node node) {
		if(node != null) {			
			postOrder(node.leftNode);			
			postOrder(node.rightNode);
			System.out.println(node.toString());
		}
	}

}
