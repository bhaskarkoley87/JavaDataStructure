package com.alds;

public class RemoveElementFromLinkedList_20200823 {
	static ListNode<String> head;

	public static void main(String[] args) {
		RemoveElementFromLinkedList_20200823 obj = new RemoveElementFromLinkedList_20200823();
		obj.push("A");
		obj.push("B");
		obj.push("C");
		obj.push("D");
		
		removeElement(2);
	}
	
	public static void removeElement(int k) {
		int totalElement = 0;
		ListNode<String> temp = head;
		while(temp != null) {
			temp = temp.next;
			totalElement++;
		}
		
		if(totalElement < k)
			return;
		
		for(int x = 0; x < totalElement - k; x++)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}

	public void push(String data) {
		ListNode<String> node = new ListNode<String>(data);

		node.next = head;

		head = node;

	}

	class ListNode<T> {
		T data;
		ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

}
