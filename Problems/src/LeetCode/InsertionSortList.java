package LeetCode;

public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		
		if(head == null){
			return null;
		}
		
		if(head.next == null){
			return head;
		}
		
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		
		ListNode prevCur = fakeHead;
		ListNode cur = head;
		while(cur != null){
			ListNode prevTemp = fakeHead;
			ListNode temp = fakeHead.next;
			boolean swapped = false;
			while(temp != cur){
				if(temp.val > cur.val){
					ListNode next = cur.next;
					prevTemp.next = cur;
					cur.next = temp;
					prevCur.next = next;
					cur = next;
					swapped = true;
					break;
				}
				prevTemp = temp;
				temp = temp.next;
			}
			
			if(!swapped){
				prevCur = cur;
				cur = cur.next;
			}

		}
		
		return fakeHead.next;
	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
