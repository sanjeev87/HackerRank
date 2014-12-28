package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, 1, result);
		
		return result;

	}
	
	public void helper(TreeNode root, int depth ,List<List<Integer>> result){
		
		if(root == null){
			return;
		}
		
		List<Integer> list = null;
		
		if(result.size() < depth){
			list = new LinkedList<Integer>();
			result.add(0,list);
		}else{
			list = result.get(result.size() - depth);
		}
		list.add(root.val);
		
		helper(root.left, depth+1, result);
		helper(root.right, depth+1, result);
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
