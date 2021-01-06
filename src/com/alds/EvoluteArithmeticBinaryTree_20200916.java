package com.alds;

public class EvoluteArithmeticBinaryTree_20200916 {

	public static void main(String[] args) {
		Node<String>  lvl3Node1 = new Node<String> ("4", null, null);
		Node<String>  lvl3Node2 = new Node<String> ("5", null, null);
		
		
		Node<String>  lvl2Node1 = new Node<String> ("*", lvl3Node1, lvl3Node2);
		Node<String>  lvl2Node2 = new Node<String> ("2", null, null);
		
		
		Node<String>  lvl2Node3 = new Node<String> ("4", null, null);
		Node<String>  lvl2Node4 = new Node<String> ("5", null, null);
		
		Node<String>  node1 = new Node<String> ("+", lvl2Node1, lvl2Node2);
		Node<String>  node2 = new Node<String> ("+", lvl2Node3, lvl2Node4);
		
		
		Node<String>  rootNode = new Node<String> ("*", node1, node2);
		
		System.out.println(inOrderOperation(rootNode, 0));

	}
	
	public static int inOrderOperation(Node node, int result) {
		
		if(node != null) {
			int left = inOrderOperation(node.leftNode, result);
			
			int right = inOrderOperation(node.rightNode, result);
			
			System.out.println("left ::: "+left);
			System.out.println("right ::: "+right);
			
			if(node.data.toString().equals("-")) {
				return (left - right);
			}else if(node.data.toString().equals("+")) {
				return (left + right);
			}else if(node.data.toString().equals("/")) {
				return (left / right);
			}else if(node.data.toString().equals("*")) {
				return (left * right);
			}else {
				return Integer.valueOf(node.data.toString());
			}
		}else {
			return 0;
		}
	}

}
