package LeetCode;

import java.util.Stack;

public class SymmetricTree {
	
	
    public boolean isSymmetric(TreeNode root) {
     
    	if(root == null){
    		return true;
    	}
    	
    	if(root.left != null){
    		if(root.right == null){
    			return false;
    		}
    	}
    	if(root.right != null){
    		if(root.left == null){
    			return false;
    		}
    	}
    	
    	if(root.left == null && root.right == null){
    		return true;
    	}
  
    	
    	Stack<TreeNode> left = new Stack<TreeNode>();
    	left.push(root.left);
    	
    	Stack<TreeNode> right = new Stack<TreeNode>();
    	right.push(root.right);
    	
    	while(!left.isEmpty() && !right.isEmpty()){
    		
    		TreeNode curLeft = left.pop();
    		TreeNode curRight = right.pop();
    		
    		if(curLeft.val != curRight.val){
    			return false;
    		}
    		
    		if(curLeft.left != null){
    			left.push(curLeft.left);
    			if(curRight.right == null){
    				return false;
    			}
    		}
    		
    		if(curLeft.right != null){
    			left.push(curLeft.right);
    			if(curRight.left == null){
    				return false;
    			}
    		}
    		
    		if(curRight.right != null){
    			right.push(curRight.right);
    			if(curLeft.left == null){
    				return false;
    			}
    		}
    		
    		if(curRight.left != null){
    			right.push(curRight.left);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
