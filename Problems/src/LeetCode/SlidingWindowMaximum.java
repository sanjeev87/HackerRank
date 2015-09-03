package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	
	
	public int[] maxSlidingWindow(int[] nums, int k) {

		if(nums == null || nums.length == 0){
			return new int[0];
		}
		
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<Integer>();
		
		
		for(int i = 0 ; i < nums.length ; i++){
			if(i > k - 1 &&  deque.getLast() == nums[i-k]) deque.removeLast();
			while(!deque.isEmpty() && deque.getFirst() < nums[i]) deque.removeFirst();
			deque.addFirst(nums[i]);
			if(i > k - 1) res[i-k+1] = deque.getLast();
		}
		
		
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
