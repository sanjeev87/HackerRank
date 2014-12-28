package LeetCode;

public class SwapNodeInPairs {

	public ListNode swapPairs(ListNode head) {
		
		
		if(head == null){
			return null;
		}
		
		if(head.next == null){
			return head;
		}
		
		ListNode fakeHead = new ListNode(0);
		
		fakeHead.next = head;
		
		ListNode prev = fakeHead;
		ListNode curr = head;
		ListNode next = head.next;
		
		while(curr != null && curr.next != null){
			
			prev.next = next;
			curr.next = next.next;
			next.next = curr;
			
			prev = curr;
			curr = prev.next;
			if(curr != null){
				next = curr.next;
			}
			
			
		}
		
		return fakeHead.next;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
