package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		
		Stack<Integer> smaller = new Stack<Integer>();
		Stack<Integer> greater = new Stack<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		inorder(root, target, smaller, true);
		inorder(root, target, greater, false);
		
		while(k-- > 0){
			
			if(smaller.isEmpty()){
				result.add(greater.pop());
			}else if(greater.isEmpty()){
				result.add(smaller.pop());
			}else{
				if(Math.abs(smaller.peek() - target) <= Math.abs(greater.peek() - target)){
					result.add(smaller.pop());
				}else{
					result.add(greater.pop());
				}
			}
			
		}
	
		
		return result;
	}
	
	
	public void inorder(TreeNode root, double target, Stack<Integer> stack, boolean smaller){
		
		if(root == null){
			return;
		}
		
		if(smaller){
			inorder(root.left,target,stack,smaller);
		}else{
			inorder(root.right,target,stack,smaller);
		}
		
		if( (smaller && root.val >= target) || (!smaller && root.val < target) ){
			return;
		}
		
		stack.push(root.val);
		
		if(smaller){
			inorder(root.right,target,stack,smaller);
		}else{
			inorder(root.left,target,stack,smaller);
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
