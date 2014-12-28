package LeetCode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		
		
		if(head == null){
			return null;
		}
		
		if(head.next == null){
		    return head;
		}
		
		ListNode tail = head;
		ListNode prev = head;
		
		while(tail.next != null){
			prev = tail;
			tail = tail.next;
		}
		
		while(n > 0){
			
			tail.next = head;
			head = tail;
			tail = prev;
			tail.next = null;
			
			ListNode temp = head;
			while(temp.next != tail){
				temp = temp.next;
			}
			prev = temp;
			n--;
		
			
		}
		
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
