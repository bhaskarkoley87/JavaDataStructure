package com.alds;

import java.util.ArrayDeque;
import java.util.Deque;

public class eCommerceLog {
	
	static Deque<Long> log = new ArrayDeque<>();
	
	
	public static void main(String[] args) {
		order(23234l);
		System.out.println(get_last());
		order(23434l);
		order(11234l);
		order(245634l);
		order(2894l);
		System.out.println(get_last());
		System.out.println(get());
		order(98434l);
		order(76234l);
		order(5555634l);
		order(9994l);
		System.out.println(get_last());
		System.out.println(get());
		
		System.out.println(log);

	}
	
	private static void order(long order_id) {
		if(log.size() < 5) {
			log.add(order_id);
		}else {
			log.poll();
			log.add(order_id);
		}
		
	}
	
	private static long get_last() {
		return log.getLast();
	}
	
	private static long get() {
		return log.peek();
	}

}
