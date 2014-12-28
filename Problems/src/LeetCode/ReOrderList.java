package LeetCode;

public class ReOrderList {
	
	public void reorderList(ListNode head) {

		if(head == null || head.next == null){
			return;
		}
		
		// split into two lists
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode head2 = slow.next;
		slow.next = null;
		
		// reverse second list
		ListNode cur = head2;
		ListNode prev = null;
		ListNode next;
		
		while(cur.next != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
		cur.next = prev;
		head2 = cur;
		
		//merge the two lists
		ListNode l1 = head;
		ListNode l2 = head2;
		
		while(l1 != null && l2 != null){
			
			ListNode l1Next = l1.next;
			ListNode l2Next = l2.next;
			l1.next = l2;
			l2.next = l1Next;
			l1 = l1Next;
			l2 = l2Next;
			
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
