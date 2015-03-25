package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		stack.add(root);
		
		TreeNode cur = root;
		TreeNode prev = null;
		
		while(!stack.isEmpty()){
			
			cur = stack.peek();
			// going down the tree
			if(prev == null || prev.left == cur || prev.right == cur){
				if(cur.left != null){
					stack.push(cur.left);
				}else{
					cur = stack.pop();
					result.add(cur.val);
					if(cur.right!= null){
						stack.push(cur.right);
					}
				}
			}// going up
			else{
				cur = stack.pop();
				result.add(cur.val);
				if(cur.right!= null){
					stack.push(cur.right);
				}
			}
			
			prev = cur;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
