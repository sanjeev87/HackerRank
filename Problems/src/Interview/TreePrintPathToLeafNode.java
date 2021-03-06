package Interview;

import java.util.Stack;

public class TreePrintPathToLeafNode {
	
	public static Stack<Node> stack = new Stack<Node>();
	
	public static void printPathToLeaf(Node root){
		
		if(root == null){
			return;
		}
		
		stack.push(root);
		if(root.getLeft() == null && root.getRight() == null){
			System.out.println(stack);
			//stack.pop();
		}
			printPathToLeaf(root.getLeft());
			printPathToLeaf(root.getRight());
		stack.pop();
	}
	
	
	
	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setRight(node4);
		node3.setLeft(node6);
		
		node4.setLeft(node5);
	
		printPathToLeaf(node1);
		
	
	}

}
