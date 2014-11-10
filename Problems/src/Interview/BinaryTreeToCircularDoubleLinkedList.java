package Interview;

public class BinaryTreeToCircularDoubleLinkedList {
	
	
	private Node merge(Node leftHead, Node rightHead){
		
		if(leftHead == null)
			return rightHead;
		
		if(rightHead == null)
			return leftHead;
		
		Node leftTail = leftHead.getLeft();
		Node rightTail = rightHead.getLeft();
		
		leftTail.setRight(rightHead);
		rightHead.setLeft(leftTail);
		rightTail.setRight(leftHead);
		leftHead.setLeft(rightTail);
		
		return leftHead;
	}
	
	
	public Node BTToCDDL(Node root){
		
		if(root == null)
			return null;
		
		Node leftList = BTToCDDL(root.getLeft());
		Node rightList = BTToCDDL(root.getRight());
		
		root.setLeft(root);
		root.setRight(root);
		
		Node left = merge(leftList, root);
		Node finalList = merge(left,rightList);
		
		return finalList;
	}

	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		node3.setLeft(node1);
		node1.setRight(node2);
		
		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node6);
		
		BinaryTreeToCircularDoubleLinkedList algo = new BinaryTreeToCircularDoubleLinkedList();
		Node head = algo.BTToCDDL(node3);
		
		int i = 0;
		while(head.getRight() != null && i < 10){
			System.out.println(head.getValue());
			head = head.getRight();
			i++;
		}
		
		System.out.println("Now the other direction");
		
		while(head.getLeft() != null && i >0 ){
			System.out.println(head.getValue());
			head = head.getLeft();
			i--;
		}

	}

}
