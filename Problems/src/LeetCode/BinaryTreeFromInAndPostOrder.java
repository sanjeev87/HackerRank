package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class BinaryTreeFromInAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
    	Map<Integer,Integer> map = new TreeMap<Integer, Integer>();

		for(int i = 0 ; i < inorder.length ; i++){
			map.put(inorder[i], i);
		}
    	
    	return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
    	
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder,
    		int inSt,int inEnd, int pSt, 
    		int pEnd,Map<Integer,Integer> map ){
    	
    	if(postorder == null || inorder == null 
				|| postorder.length == 0 || inorder.length == 0 ||
				pSt > pEnd || inSt > inEnd ||
				pEnd < 0 || pSt < 0){
			return null;
		}
    	
    	TreeNode root = new TreeNode(postorder[pEnd]);
    	
    	int index = map.get(root.val);
    	
    	root.left = buildTree(inorder,postorder,inSt,index - 1, pEnd -1 - (index - inSt) - 1  ,pEnd-1,map);
    	root.right = buildTree(inorder,postorder,index+1,inEnd , pSt, pEnd -1 - (index - inSt) - 1 - 1,map);
    	
    	return root;
    }
	
	public static void main(String[] args) {

	}

}
