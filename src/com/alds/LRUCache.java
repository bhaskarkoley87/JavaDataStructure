package com.alds;

import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache<K, V> implements Serializable, Cloneable {

	private static volatile LRUCache _lruCache;

	private final static Object lockObject = new Object();

	private static final long serialVersionUID = 1235345L;

	private Deque<K> _cacheQueue;
	private HashMap<K, V> _hshSet;
	private int _CAPACITY = 0;

	private LRUCache() {

	}

	public static LRUCache getInstance(int capacity) {
		if (_lruCache == null) {
			synchronized (lockObject) {
				_lruCache = new LRUCache();
				_lruCache._CAPACITY = capacity;
				_lruCache._cacheQueue = new LinkedList<>();
				_lruCache._hshSet = new HashMap<>(_lruCache._CAPACITY);
			}
		}
		return _lruCache;
	}

	public void set(K key, V value) {
		if (_lruCache._hshSet.containsKey(key)) {
			_cacheQueue.remove(key);
		} else {
			if (_cacheQueue.size() == _CAPACITY) {
				K k = _cacheQueue.removeLast();
				_hshSet.remove(k);
			}
		}
		_hshSet.put(key, value);
		_cacheQueue.push(key);
	}

	public V get(K key) {
		V value = _hshSet.get(key);
		return value;
	}

	public void display() {
		Iterator<K> itr = _cacheQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next().toString() + " ");
		}
	}

	protected Object readResolve() {
		return _lruCache;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		return new CloneNotSupportedException();
	}

}
