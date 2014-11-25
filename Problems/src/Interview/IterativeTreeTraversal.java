package Interview;

import java.util.Stack;

public class IterativeTreeTraversal {

	Stack<Node> stack;

	public IterativeTreeTraversal(){
		stack = new Stack<Node>();
	}

	public void iterativePreorderTraversal(Node root){

		if(root == null)
			return;

		stack.push(root);

		while(!stack.isEmpty()){

			Node curNode = stack.pop();
			System.out.println(curNode.getValue());
			if(curNode.getRight() != null){
				stack.push(curNode.getRight());
			}
			if(curNode.getLeft() !=null){
				stack.push(curNode.getLeft());
			}
		}

	}

	public void iterativeInorderTraversal(Node root){

		if(root == null)
			return;

		stack.push(root);

		Node curNode = root;

		while(!stack.isEmpty()){

			if(curNode.getLeft() != null){
				stack.push(curNode.getLeft());
				curNode = curNode.getLeft();
			}else{
				curNode = stack.pop();
				System.out.println(curNode.getValue());
				if(curNode.getRight() != null){
					stack.push(curNode.getRight());
					curNode = curNode.getRight();
				}
			}

		}


	}

	public void iterativePostorderTraversal(Node root){
		
		if(root == null){
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node prev = null;
		
		while(!stack.isEmpty()){
			Node curr = stack.peek();
			
			// traversing the tree downwards
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr ){
				if(curr.getLeft() != null){
					stack.push(curr.getLeft());
				}else if(curr.getRight() != null){
					stack.push(curr.getRight());
				}else{
					System.out.println(curr.getValue());
					stack.pop();
				}
			}
			// traversing the tree upwards from the left
			else if(curr.getLeft() ==  prev){
				if(curr.getRight() != null){
					stack.push(curr.getRight());
				}else{
					System.out.println(curr.getValue());
					stack.pop();
				}
			}
			// traversing a tree upwards from right
			else{
				System.out.println(curr.getValue());
				stack.pop();
			}
			
			prev = curr;
		}
		
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
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


		IterativeTreeTraversal algo = new IterativeTreeTraversal();
		//		algo.iterativePreorderTraversal(node3);
		algo.iterativePostorderTraversal(node3);


	}

}
