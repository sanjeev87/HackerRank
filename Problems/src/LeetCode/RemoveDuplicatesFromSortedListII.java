package LeetCode;

public class RemoveDuplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode prev = fakeHead;
		ListNode cur = head;
		ListNode next = head.next;

		while(cur != null){
			
			while(next != null && cur.val == next.val){
				cur = cur.next;
				next = next.next;
			}
			
			if(prev.next != cur){
				prev.next = next;
				cur = next;
				if(next != null){
					next = next.next;
				}
			}else{
				prev = prev.next;
				cur = cur.next;
				if(next != null){
					next = next.next;
				}
			}
			
		}

		return fakeHead.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
