package LeetCode;

public class DeleteNodeInLinkedList {


	public void deleteNode(ListNode node) {

		ListNode nextNode = node.next;
		
		if(nextNode != null){
			node.val = nextNode.val;
			node.next = nextNode.next;
		}else{
			node = null;
		}
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
