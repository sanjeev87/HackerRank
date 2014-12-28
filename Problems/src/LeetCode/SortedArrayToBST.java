package LeetCode;

public class SortedArrayToBST {
	
	
	public TreeNode sortedArrayToBST(int[] num) {
        
		
		
		return sortedArrayToBST(num, 0, num.length-1);
    }
	
	public TreeNode sortedArrayToBST(int[] num, int start, int end){
		
		if(num == null || num.length == 0 || start > end){
			return null;
		}
		
		int mid = (start+end)/2;
		
		TreeNode root = new TreeNode(num[mid]);
		
		root.left = sortedArrayToBST(num,start,mid-1);
		root.right = sortedArrayToBST(num,mid+1,end);
		
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
