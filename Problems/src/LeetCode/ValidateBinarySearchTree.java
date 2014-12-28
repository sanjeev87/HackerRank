package LeetCode;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root, double max , double min){
		
		if(root == null){
			return true;
		}
		
		if((double)root.val < max && ( double) root.val > min){
			boolean left = isValidBST(root.left , root.val , min);
			boolean right = isValidBST(root.right, max, root.val);
			return left && right;
		}
			return false;
		
	}
	
	public boolean isValidBST(TreeNode root) {

		if(root == null){
			return true;
		}
		
		
		return isValidBST(root, Double.MAX_VALUE, -Double.MAX_VALUE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
		TreeNode root = new TreeNode(0);
		
		ValidateBinarySearchTree p = new ValidateBinarySearchTree();
		System.out.println(p.isValidBST(root));
	}

}
