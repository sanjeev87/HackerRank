package LeetCode;

public class ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {
		
		if(root == null){
			return Integer.MAX_VALUE;
		}
		
		double rootDiff = (double) (Math.abs((double)root.val - target));
		if(root.val > target && root.left != null){
			int left = closestValue(root.left, target);
			double leftDiff = (double) (Math.abs(target - (double)left));
			return (rootDiff <= leftDiff) ? root.val : left;
		}else if(root.val < target && root.right != null){
			int right = closestValue(root.right, target);
			double rightDiff = (double) (Math.abs(target - (double)right));
			return (rootDiff <= rightDiff) ? root.val : right;
		}else{
			return root.val;
		}
		
	}

}
