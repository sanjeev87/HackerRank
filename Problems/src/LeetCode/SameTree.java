package LeetCode;

import java.util.Stack;

public class SameTree {
	
public boolean isSameTree(TreeNode p, TreeNode q) {
        
     
    	
    	if(p == null && q == null){
    		return true;
    	}
    	
    	if( (p != null && q == null )
    	    || (q != null && p == null)){
    	        return false;
    	    }
  
    	
    	Stack<TreeNode> left = new Stack<TreeNode>();
    	left.push(p);
    	
    	Stack<TreeNode> right = new Stack<TreeNode>();
    	right.push(q);
    	
    	while(!left.isEmpty() && !right.isEmpty()){
    		
    		TreeNode curLeft = left.pop();
    		TreeNode curRight = right.pop();
    		
    		if(curLeft.val != curRight.val){
    			return false;
    		}
    		
    		if(curLeft.left != null){
    			left.push(curLeft.left);
    			if(curRight.left == null){
    				return false;
    			}
    		}
    		
    		if(curLeft.right != null){
    			left.push(curLeft.right);
    			if(curRight.right == null){
    				return false;
    			}
    		}

            if(curRight.left != null){
    			right.push(curRight.left);
    			if(curLeft.left == null){
    				return false;
    			}
    		}
    		

    		if(curRight.right != null){
    			right.push(curRight.right);
    			if(curLeft.right == null){
    				return false;
    			}
    		}
    		
    		
    	}
    	
    	if(!left.isEmpty() || !right.isEmpty()){
    		return false;
    	}
    	
    	return true;
    
    }

}
