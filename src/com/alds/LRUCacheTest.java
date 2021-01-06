package com.alds;

public class LRUCacheTest {

	public static void main(String[] args) {
		LRUCache<Integer, String> cache = LRUCache.getInstance(4);
		cache.set(1, "A");
		cache.set(2, "B");
		cache.set(3, "C");
		cache.set(1, "A");
		cache.set(4, "D");
		cache.set(5, "E");
		cache.set(2, "B");
		cache.set(2, "B");
		cache.set(1, "A");
		cache.display();
	}

}


/// 2,5,4,1