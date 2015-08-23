package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache { 

	Map<Integer,DLLNode> cache;
	
	DLLNode head;
	DLLNode tail;
	int curSize;
	int capacity;

	public class DLLNode{

		int key;
		int value;

		DLLNode prev;
		DLLNode next;
		
	}
	

	public LRUCache(int capacity) {

		this.capacity = capacity;
		curSize = 0;
		
		cache = new HashMap<Integer,DLLNode>();
		
		head = new DLLNode();
		tail = new DLLNode();
		
		head.prev = null;
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
		
	}
	
	/*
	 * new nodes will be added after the head
	 * 
	 * least used nodes will be removed from just before the tail
	 */
	public void addNode(DLLNode node){
		
		DLLNode temp = head.next;
		
		head.next = node;
		node.next = temp;
		node.prev = head;
		temp.prev = node;
		
	}
	
	public void removeNode(DLLNode node){
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		
	}
	
	public DLLNode removeTail(){
		
		DLLNode lru = tail.prev;
		removeNode(lru);
		
		return lru;
	}
	
	public void moveToTop(DLLNode node){
		
		removeNode(node);
		addNode(node);
		
	}
	
	

	public int get(int key) {

		if(cache.containsKey(key)){
			
			DLLNode node = cache.get(key);
			moveToTop(node);
			return node.value;
			
		}
		
		return -1;
	}

	public void set(int key, int value) {
		
		if(cache.containsKey(key)){
			DLLNode node = cache.get(key);
			node.value = value;
			moveToTop(node);
		}else{
			
			DLLNode node = new DLLNode();
			node.key = key;
			node.value = value;
			cache.put(key, node);
			addNode(node);
			curSize++;
			
			if(curSize > capacity){
				
				DLLNode lru = removeTail();
				cache.remove(lru.key);
				curSize--;
				
			}
			
			
			
			
		}
		

	}



}
