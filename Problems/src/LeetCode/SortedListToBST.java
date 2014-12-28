package LeetCode;


public class SortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
		
		if(head == null){
			return null;
		}
		
		ListNode temp = head;
		int num = 1;
		while(temp.next != null){
			temp = temp.next;
			num++;
		}
		
		return sortedListToBST(head,num);

	}
	
	public TreeNode sortedListToBST(ListNode head,int num) {
		
		if(head == null || num < 1){
			return null;
		}
		
		if(num == 1){
			return new TreeNode(head.val);
		}
		
		int mid = num/2;
		
		ListNode temp = head;
		int count = 1;
		
		while(count <= mid){
			temp = temp.next;
			count++;
		}
		
		TreeNode root = new TreeNode(temp.val);
		
		root.left = sortedListToBST(head, count - 1);
		root.right = sortedListToBST(temp.next, num - count);
		
		
		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
