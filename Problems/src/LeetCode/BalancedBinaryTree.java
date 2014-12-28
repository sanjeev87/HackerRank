package LeetCode;

public class BalancedBinaryTree {


	public int getDepth(TreeNode root){

		if(root == null){
			return 0;
		}

		int left = getDepth(root.left);
		if(left == -1){
			return -1;
		}

		int right = getDepth(root.right);
		if(right == -1){
			return -1;
		}

		if(Math.abs(right - left) > 1){
			return -1;
		}

		return 1 + Math.max(left, right);
	}

	public boolean isBalanced(TreeNode root) {

		return getDepth(root) != -1;   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
