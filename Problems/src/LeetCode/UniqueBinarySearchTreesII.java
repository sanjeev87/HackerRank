package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int start, int end) {

		List<TreeNode> result = new ArrayList<TreeNode>();
		
		if(start > end || start < 1){
			result.add(null);
			return result;
		}
		
		
		for(int rootIndex = start ; rootIndex <= end ; rootIndex ++){
			
			List<TreeNode> left = generateTrees(start, rootIndex-1);
			List<TreeNode> right = generateTrees(rootIndex+1,end);
			
			for(TreeNode leftRoot : left ){
				for(TreeNode rightRoot : right ){
					TreeNode root = new TreeNode(rootIndex);
					root.left = leftRoot;
					root.right = rightRoot;
					result.add(root);
				}
			}
			
		}
		
		return result;

	}


	public List<TreeNode> generateTrees(int n) {

		
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(n <= 0 ){
			result.add(null);
			return result;
		}

		return generateTrees(1,n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
