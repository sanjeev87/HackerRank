package Interview;

import java.util.Stack;

public class PathSum {

	//Stack<Node> stack;
	
	public PathSum(){
		//stack = new Stack<Node>();
		
	
	}
	
	// does root to leaf path have a particular sum
	public boolean hasPathSum(TreeNode root, int sum) {
        
		if(root == null){
			return false;
		}
		
		if(root.left == null && root.right == null){
			if(root.val == sum){
				return true;
			}
			return false;
		}
		
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	public int getDepth(Node root){
		
		if(root == null){
			return 0;
		}
		
		return 1 + Math.max(getDepth(root.getLeft()), getDepth(root.getRight()));
		
	}
	public void printPath(int start, int end, Node[] path){
		String out="";
		for(int i = start; i <= end ; i++){
			out += path[i]+"";
		}
		System.out.println(out);
	}
	
	public void pathSumPrint(Node root, int sum, Node[] path,int level){
		
		if(root== null){
			return;
		}
		
		path[level] = root;
		
		int tempSum = 0;
		for(int i = level ; i >=0 ; i --){
			tempSum += path[i].getValue();
			if(tempSum == sum){
				printPath(i, level, path);
			}
		}
		
		pathSumPrint(root.getLeft(), sum, path, level+1);
		pathSumPrint(root.getRight(), sum, path, level+1);
		
	}
	
	
	public static void main(String[] args) {
		
				Node node1 = new Node(1);
				Node node2 = new Node(2);
				Node node3 = new Node(3);
				Node node4 = new Node(4);
				Node node5 = new Node(5);
				Node node6 = new Node(6);
				Node node7 = new Node(7);
				Node node8 = new Node(8);

				node3.setLeft(node1);
				node1.setRight(node2);

				node3.setRight(node5);
				node5.setLeft(node4);
				node5.setRight(node7);

				node7.setRight(node8);
				node7.setLeft(node6);
				
				PathSum algo = new PathSum();
				int depth = algo.getDepth(node3);
				Node[] path = new Node[depth];
				algo.pathSumPrint(node3, 9, path, 0);

	}

}
