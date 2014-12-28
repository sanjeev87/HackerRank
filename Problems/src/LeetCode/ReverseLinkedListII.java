package LeetCode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if(head == null){
			return null;
		}
		
		if(head.next == null || m==n){
			return head;
		}
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode prev = fakeHead;
		ListNode cur = head;
		
		int count = 1;
		
		while(count < m){
			prev = cur;
			cur = cur.next;
			count++;
		}
		
		prev.next = null;
		ListNode firstTail = prev;
		prev = null;
		ListNode secondHead = cur;
		
		while(count < n+1){
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
			count++;
		}
		
		firstTail.next = prev;
		secondHead.next = cur;
		
		while(cur != null){
		    prev = cur;
			cur = cur.next;
		}
		
	    return fakeHead.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
