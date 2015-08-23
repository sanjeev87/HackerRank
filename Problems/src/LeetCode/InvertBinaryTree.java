package LeetCode;

public class InvertBinaryTree {


	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */



	public TreeNode invertTree(TreeNode root) {

		if(root == null){
			return null;
		}
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.left = right;
		root.right = left; 
		
		
		return root;
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
