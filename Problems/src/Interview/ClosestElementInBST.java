package Interview;

public class ClosestElementInBST {
	

	public Node getClosestNodeInBST(Node root, double
			queryValue){
		
		if(root == null)
			return null;
		
		
		if(root.getValue() > queryValue){
			Node closest = getClosestNodeInBST(root.getLeft(), queryValue);
			if(closest != null){
				return ( Math.abs(closest.getValue() - queryValue) 
						<=  Math.abs(root.getValue() - queryValue ) ) ? closest : root ;
			}else{
				return root;
			}
				
		}else{
			Node closest = getClosestNodeInBST(root.getRight(), queryValue);
			if(closest != null){
				return ( Math.abs(closest.getValue() - queryValue) 
						<= Math.abs(root.getValue() - queryValue) ) ? closest : root ;
			}else{
				return root;
			}
		}
		
	}
	
	
	public static void main(String[] args) {	// TODO Auto-generated method stub
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
		
		ClosestElementInBST alg = new ClosestElementInBST();
		
		Node head = alg.getClosestNodeInBST(node3, 6.8);
		
		System.out.println("closest elemnt  is " + head.getValue());
		
		}

}
