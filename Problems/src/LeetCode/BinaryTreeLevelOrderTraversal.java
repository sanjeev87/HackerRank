package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


	public List<List<Integer>> levelOrder(TreeNode root) {
        
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		
		if(root == null){
			return result;
		}
		
		q1.add(root);
		List<Integer> list = new LinkedList<Integer>();
		while(!q1.isEmpty() || !q2.isEmpty()){
			
			
			while(!q1.isEmpty()){
				TreeNode curNode = q1.remove();
				list.add(curNode.val);
				if(curNode.left != null){
					q2.add(curNode.left);
				}
				if(curNode.right != null){
					q2.add(curNode.right);
				}
			}
			
			if(!list.isEmpty())
			    result.add(list);
			    
			list = new LinkedList<Integer>();
			
			while(!q2.isEmpty()){
				TreeNode curNode = q2.remove();
				list.add(curNode.val);
				if(curNode.left != null){
					q1.add(curNode.left);
				}
				if(curNode.right != null){
					q1.add(curNode.right);
				}
			}
			
			if(!list.isEmpty())
			    result.add(list);
			    
			list = new LinkedList<Integer>();
			
		}
		
		
		
		return result;
	
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> result = bt.levelOrder(root);
		System.out.println(result);
	}

}
