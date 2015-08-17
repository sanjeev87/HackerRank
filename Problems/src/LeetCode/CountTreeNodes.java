package LeetCode;

public class CountTreeNodes {
	
	public int countLeftHeight(TreeNode root){
		
		int dep = 0;
		while(root != null){
			root = root.left;
			dep++;
		}
		
		return dep;
	}
	
	
	public int countRightHeight(TreeNode root){
		
		int dep = 0;
		while(root != null){
			root = root.right;
			dep++;
		}
		
		return dep;
	}

	public int countNodes(TreeNode root) {

		if(root == null){
			return 0;
		}
		
		int leftHeight = countLeftHeight(root);
		int rightHeight = countRightHeight(root);
		
		if(leftHeight == rightHeight){
			return (1 << leftHeight) - 1;
		}
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
