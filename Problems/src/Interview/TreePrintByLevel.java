package Interview;


import java.util.LinkedList;
import java.util.Queue;


public class TreePrintByLevel {

	
	
	public static void PrintByLevel(Node root){
		
		if(root == null){
			return;
		}
		
		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();
		StringBuffer out = new StringBuffer(); 
		
		queue1.add(root);
		int level = 0;
		
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			
			while(!queue1.isEmpty()){
				Node aNode = queue1.remove();
				out.append(aNode.getValue());
				
				if(aNode.getLeft() != null)
					queue2.add(aNode.getLeft());
				if(aNode.getRight() != null)
					queue2.add(aNode.getRight());
				
			}
			if(out.toString().length() != 0)
				System.out.println("Level :" + level + ":" + out);
			level++;
			out = new StringBuffer();
			while(!queue2.isEmpty()){
				Node aNode = queue2.remove();
				out.append(aNode.getValue());
				
				if(aNode.getLeft() != null)
					queue1.add(aNode.getLeft());
				if(aNode.getRight() != null)
					queue1.add(aNode.getRight());
				
			}
			if(out.toString().length() != 0)
				System.out.println("Level :" + level + ":" + out);
			level++;
			out = new StringBuffer();
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
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setRight(node4);
		node3.setLeft(node6);
		
		
		PrintByLevel(node1);
		

	}

}
