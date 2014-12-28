package LeetCode;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	

	public void push(int x) {
		
		stack.push(x);
		
		if(minStack.isEmpty() || minStack.peek() >= x){
			minStack.push(x);
		}
		
	}

	public void pop() {
		
		if(!stack.isEmpty()){
			int top = stack.pop();
			if(minStack.peek() == top){
				minStack.pop();
			}
			
		}
	
		
	}

	public int top() {
		
		return stack.peek();
	}

	public int getMin() {
		
		return minStack.peek();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
