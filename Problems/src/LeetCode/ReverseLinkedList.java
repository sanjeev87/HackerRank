package LeetCode;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {

		if(head == null || head.next == null){
			return head;
		}
		
		ListNode prev = null;
		ListNode cur = head;
		ListNode temp = cur;
		
		while(cur != null){
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		
		
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
