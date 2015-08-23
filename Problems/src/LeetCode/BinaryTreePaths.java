package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public void bst(List<List<Integer>> result, List<Integer> path, TreeNode root){
		if(root== null){
			return;
		}
		path.add(root.val);
		if(root.left == null && root.right == null){
			result.add(new ArrayList<Integer>(path));
		}
		bst(result, path, root.left);
		bst(result, path, root.right);
		path.remove(path.size() - 1);
    }
	
	public List<String> binaryTreePaths(TreeNode root){
		List<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<String> out = new ArrayList<String>();
		if(root == null){
			return out;
		}
		bst(result, path, root);
		for(List<Integer> res : result){
			String outStr = res.get(0) + "";
			for(int i = 1 ; i < res.size() ; i++){
				outStr += "->" + res.get(i);
			}
			out.add(outStr);
		}
		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
