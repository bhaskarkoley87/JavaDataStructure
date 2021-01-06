package com.alds;

public class LockingBInaryTree_20200821 {

	public static void main(String[] args) {
		Node<String> lvl5Node1 = new Node<String>("L", null, null, false);

		Node<String> leefNode1 = new Node<String>("Z", null, null, false);
		Node<String> leefNode2 = new Node<String>("U", null, lvl5Node1, false);
		Node<String> leefNode3 = new Node<String>("V", null, null, false);
		Node<String> leefNode4 = new Node<String>("Z", null, null, false);
		Node<String> leefNode5 = new Node<String>("V", null, null, false);
		Node<String> leefNode6 = new Node<String>("W", null, null, false);
		Node<String> leefNode7 = new Node<String>("S", null, null, false);
		Node<String> leefNode8 = new Node<String>("T", null, null, false);

		Node<String> lvl2Node1 = new Node<String>("G", null, null, false);
		Node<String> lvl2Node2 = new Node<String>("H", null, null, false);
		Node<String> lvl2Node3 = new Node<String>("Q", null, null, false);
		Node<String> lvl2Node4 = new Node<String>("V", leefNode1, leefNode2, false);

		Node<String> lvl1Node1 = new Node<String>("D", lvl2Node1, lvl2Node2, false);
		Node<String> lvl1Node2 = new Node<String>("I", lvl2Node3, lvl2Node4, false);

		Node<String> rootNode = new Node<String>("A", lvl1Node1, lvl1Node2, false);

		
		Thread th1 = new Thread(() -> {
			inOrder(rootNode, "D", "Thread-1");
		});

		Thread th2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inOrder(rootNode, "D", "Thread-2");
		});

		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void inOrder(Node node, String valueToAccess, String strThrwadName) {
		if (node != null && !node.isLocked) {
			if (node.toString().equals(valueToAccess)) {
				System.out.println(strThrwadName + "--> " + node.setLocked());
			}
			inOrder(node.leftNode, valueToAccess, strThrwadName);
			System.out.println(strThrwadName + "--> " + node.toString());
			inOrder(node.rightNode, valueToAccess, strThrwadName);
		}
	}

	static class Node<T> {

		Node<T> leftNode;
		Node<T> rightNode;
		T data;
		boolean isLocked;

		public Node(T data, Node<T> leftNode, Node<T> rightNode, boolean isLocked) {
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.isLocked = isLocked;
		}

		public boolean isLocked() {
			return isLocked;
		}

		public boolean setLocked() {
			if (!isLocked()) {
				return this.isLocked = true;
			} else {
				return false;
			}
		}

		public boolean setUnLocked() {
			if (isLocked()) {
				this.isLocked = false;
				return true;
			} else {
				return false;
			}
		}

		public String toString() {
			return this.data.toString();
		}
	}
}