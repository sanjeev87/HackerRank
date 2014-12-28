package LeetCode;

public class SumRootToLeafNumbers {
    
    public int getDepth(TreeNode root){
		
		if(root == null){
			return 0;
		}
		
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
		
	}
	
	public int computeValue(int[] values, int level){
		int sum = 0;
		
		int index = 0;
		
		while(index < values.length && values[index] == 0 ){
		    index++;
		}
		int power = 0;
		for(int i = level ; i >=index ; i--){
			sum += values[i] * Math.pow(10, power++);
		}
		
		return sum;
	}
	
	public int getSum(TreeNode root,int[] values,int level){
		
		if(root == null){
			return 0;
		}
		
		values[level] = root.val;
		
		if(root.left == null && root.right ==  null){
			return computeValue(values, level);
		}
		
		return getSum(root.left,values,level + 1) + getSum(root.right, values, level + 1);
		
	}
    
    public int sumNumbers(TreeNode root) {
	     
		 int depth = getDepth(root);
		 int[] values = new int[depth];
		 
		 return getSum(root, values, 0);
	 }
}
