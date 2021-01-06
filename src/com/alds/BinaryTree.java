package com.alds;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public static Queue<Integer> q = new LinkedList<>(); 
	
	public static void main(String[] arr) {		
		Node<Integer>  lvl2Node3 = new Node<Integer> (15, null, null);
		Node<Integer>  lvl2Node4 = new Node<Integer> (7, null, null);
		
		
		Node<Integer>  lvl1Node1 = new Node<Integer> (9, null, null);
		Node<Integer>  lvl1Node2 = new Node<Integer> (20, lvl2Node3, lvl2Node4);
		
		Node<Integer>  rootNode = new Node<Integer> (3, lvl1Node1, lvl1Node2);
		
		BinaryTree bt = new BinaryTree();
		bt.inOrder(rootNode);
		
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
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
			if(node.leftNode != null) {
				if(node.leftNode.leftNode == null && node.leftNode.rightNode == null) {
					q.add((Integer)node.leftNode.data);
				}
			}
			inOrder(node.leftNode);
			//System.out.println(node.toString());
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