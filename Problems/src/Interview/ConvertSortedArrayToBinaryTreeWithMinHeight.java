package Interview;

public class ConvertSortedArrayToBinaryTreeWithMinHeight {

	public Node convertArrToTree(Node[] inputArray, int start, int end){
		
		
		if(start == end){
			return inputArray[start];
		}
		
		if(end < start){
			return null;
		}
		
		int mid = (start + end)/2 ;
		
		Node root = inputArray[mid];
		root.setLeft(convertArrToTree(inputArray, start, mid-1));
		root.setRight(convertArrToTree(inputArray, mid+1, end));
		
		return root;
	}
	
	public static void traverseInOrder(Node root){
		
		if(root == null)
			return;
		
		traverseInOrder(root.getLeft());
		System.out.println(root.getValue());
		traverseInOrder(root.getRight());
		
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
		Node node9 = new Node(9);

		/*
		node3.setLeft(node1);
		node1.setRight(node2);

		node3.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node7);

		node7.setRight(node8);
		node7.setLeft(node6);
		node7.setLeft(node6);

		node8.setRight(node9);
		*/
		
		Node[] array = new Node[9];
		array[0] = node1;
		array[1] = node2;
		array[2] = node3;
		array[3] = node4;
		array[4] = node5;
		array[5] = node6;
		array[6] = node7;
		array[7] = node8;
		array[8] = node9;
		
		ConvertSortedArrayToBinaryTreeWithMinHeight alg = new ConvertSortedArrayToBinaryTreeWithMinHeight();
		
		Node root = alg.convertArrToTree(array, 0, 8);
		
		traverseInOrder(root);
		
		

	}

}
