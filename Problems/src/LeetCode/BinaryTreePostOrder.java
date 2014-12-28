package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrder {

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null){
		    return result;
		}
		
		stack.push(root);
		
		TreeNode cur = root;
		TreeNode prev = null;
		
		while(!stack.isEmpty()){
			
			cur = stack.peek();
			
			// going down the tree
			if( (prev == null || prev.left == cur || prev.right == cur) ){
				if(cur.left != null){
					stack.push(cur.left);
				}else if(cur.right != null){
					stack.push(cur.right);
				}else{
					cur = stack.pop();
					result.add(cur.val);
				}
				
			}
			// going up on the left
			else if(prev != null && cur.left == prev){
				if(cur.right != null){
					stack.push(cur.right);
				}else{
					cur = stack.pop();
					result.add(cur.val);
				}
			}
			// going up on the right
			else if(prev != null && cur.right == prev){
				cur = stack.pop();
				result.add(cur.val);
			}
			
			prev = cur;
		}
		
		return result;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
