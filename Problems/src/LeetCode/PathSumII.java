package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSumII {

  	public List<List<Integer>> pathSum(TreeNode root, int sum,
			Stack<Integer> stack, List<List<Integer>> result) {

		if(root == null){
			return result;
		}
		
		stack.push(root.val);
		if(root.left == null && root.right == null){
			int add = 0;
			for(int i : stack){
				add += i;
			}
			List<Integer> list = null;
			if(add == sum){
				list = new LinkedList<Integer>(stack);
				result.add(list);
			}
			return result;
			
		}
		if(root.left != null){
			pathSum(root.left, sum , stack,result);
			stack.pop();
		}
		if(root.right != null){
			pathSum(root.right, sum , stack,result);
			stack.pop();
		}
		
		return result;
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> s = new Stack<Integer>();
		
		return pathSum(root, sum, s, result);
	}


	public static void main(String[] args) {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node3.setLeft(node1);
		node1.setRight(node2);
		
		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node6);
		
		PathSumII alg = new PathSumII();
		
		List<List<Integer>> result = alg.pathSum(node3, 12);
		System.out.println(result.toString());
	}

}
