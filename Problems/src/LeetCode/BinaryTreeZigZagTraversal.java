package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigZagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {



		List<List<Integer>> result = new LinkedList<List<Integer>>();

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		if(root == null){
			return result;
		}

		q1.add(root);
		Stack<Integer> list = new Stack<Integer>();
		while(!q1.isEmpty() || !q2.isEmpty()){


			while(!q1.isEmpty()){
				TreeNode curNode = q1.remove();
				list.push(curNode.val);
				if(curNode.left != null){
					q2.add(curNode.left);
				}
				if(curNode.right != null){
					q2.add(curNode.right);
				}
			}

			if(!list.isEmpty()){

				result.add(list);
			}


			list = new Stack<Integer>();

			while(!q2.isEmpty()){
				TreeNode curNode = q2.remove();
				list.push(curNode.val);
				if(curNode.left != null){
					q1.add(curNode.left);
				}
				if(curNode.right != null){
					q1.add(curNode.right);
				}
			}

			if(!list.isEmpty()){

				List<Integer> l = new LinkedList<Integer>();

				while(!list.isEmpty()){
					l.add(list.pop());
				}

				result.add(l);
			}

			list = new Stack<Integer>();

		}



		return result;



	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
