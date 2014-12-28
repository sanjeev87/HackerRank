package LeetCode;

public class SortList {
	
	public ListNode merge(ListNode head1, ListNode head2){
		
		ListNode fakeHead = new ListNode(0);
		ListNode cur = fakeHead;
		
		while(head1 !=null && head2!= null){
			
			if(head1.val <= head2.val){
				cur.next = head1;
				head1 = head1.next;
			}else{
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		
		if(head1 != null){
			cur.next = head1;
		}
		if(head2 != null){
			cur.next = head2;
		}
		
		return fakeHead.next;
	}

	public ListNode sortList(ListNode head){

		if(head== null){
			return null;
		}

		if(head.next == null){
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode head2 = slow.next;
		slow.next = null;

		head = sortList(head);
		head2 = sortList(head2);
		
		ListNode result = merge(head, head2);

		return result;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
