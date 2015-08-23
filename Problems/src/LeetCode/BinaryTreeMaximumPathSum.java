package LeetCode;


public class BinaryTreeMaximumPathSum {

	int maxValue = Integer.MIN_VALUE;

	public int pSum(TreeNode root){

		if(root == null){
			return Integer.MIN_VALUE;
		}

		int left = pSum(root.left);
		maxValue = (int) Math.max(maxValue, left);
		int right = pSum(root.right);
		maxValue = (int) Math.max(maxValue, right);
		
		if(left < 0 && right < 0){
			return root.val;
		}else if(left < 0){
			return root.val + right;
		}else if(right < 0){
			return root.val + left;
		}else{
			maxValue = Math.max(maxValue, root.val + left + right);
		}

		return Math.max(root.val + left, root.val+right);

	}



	public int maxPathSum(TreeNode root) {
		int rootSum = pSum(root);
		return Math.max(maxValue,rootSum );
	}


	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
