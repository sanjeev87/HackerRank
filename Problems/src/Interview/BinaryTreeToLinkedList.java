package Interview;

public class BinaryTreeToLinkedList {
	
	public void flattenRecursively(TreeNode root) {

		if(root == null){
			return;
		}

		TreeNode right = root.right;
		flattenRecursively(root.left);
		root.right = root.left;
		
		TreeNode temp = root;  
		while(temp.right != null){
			temp = temp.right;
		}

		flattenRecursively(right);
		temp.right = right;
		root.left = null;
		
	}

	
	public void flattenIterativley(TreeNode root) {

		if(root == null){
			return;
		}

		while(root != null){
			
			if(root.left != null){
				TreeNode right = root.right;
				root.right = root.left;
				TreeNode temp = root.right;
				while(temp.right != null){
					temp = temp.right;
				}
				temp.right = right;
				root.left = null;
			}
			
			root = root.right;
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
