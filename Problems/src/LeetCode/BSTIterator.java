package LeetCode;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        this.pushAll(root);
    }
    
    public void pushAll(TreeNode root){
    	TreeNode temp = root;
    	while(temp != null){
    		stack.push(temp);
    		temp = temp.left;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
    	if(hasNext()){
    	
    		TreeNode next = stack.pop();
    		if(next.right != null){
    			this.pushAll(next.right);
    		}
    		return next.val;
    		
    	}
    		return 0;
    	
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
