package com.alds;

public class Node<T> {
	
	Node<T> leftNode;
	Node<T> rightNode;
	T data;
	
	public Node(T data, Node<T> leftNode, Node<T> rightNode) {
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public String toString() {
		return this.data.toString();
	}
}
