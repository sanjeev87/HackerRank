package LeetCode;

import java.util.Map;
import java.util.TreeMap;


public class BinaryTreeFromInAndPreTraversal {


	public TreeNode buildTree(int[] preorder, int[] inorder) {

		Map<Integer,Integer> map = new TreeMap<Integer, Integer>();

		for(int i = 0 ; i < inorder.length ; i++){
			map.put(inorder[i], i);
		}

		return buildTree(preorder,inorder,0,preorder.length -1,0,inorder.length-1,map);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder, 
			int pSt,int pEnd,int iSt,int iEnd,Map<Integer,Integer> map){

		if(preorder == null || inorder == null 
				|| preorder.length == 0 || inorder.length == 0
				|| pSt > pEnd || iSt > iEnd ){
			return null;
		}


		TreeNode root = new TreeNode(preorder[pSt]);


		int index = map.get(root.val);

		root.left = buildTree(preorder,inorder,pSt+1, (pSt + 1 + index - iSt - 1),iSt , index-1,map);
		root.right = buildTree(preorder,inorder,(pSt + 1 + index - iSt - 1)+1,pEnd,index+1,iEnd,map);


		return root;
	}


}
