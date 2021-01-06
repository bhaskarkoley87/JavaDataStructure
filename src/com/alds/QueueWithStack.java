package com.alds;

import java.util.Stack;

public class QueueWithStack {
	
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		enqueue(6);
		
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
	
	public static void enqueue(Integer val) {
		while (!stack1.isEmpty()) 
        {  
			stack2.push(stack1.pop());  
            //s1.pop();  
        }  
  
        // Push item into s1  
		stack1.push(val);  
  
        // Push everything back to s1  
        while (!stack2.isEmpty())  
        {  
        	stack1.push(stack2.pop());  
            //s2.pop();  
        }  
	}
	
	public static Integer dequeue() {
		if (stack1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);  
        }  
  
        // Return top of s1  
        Integer x = stack1.pop();  
       
        return x;  
	}

}
