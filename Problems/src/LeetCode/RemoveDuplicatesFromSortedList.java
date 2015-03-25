package LeetCode;

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null){
            return null;
        }

		ListNode temp = head;
		
		while(temp != null){
			
			ListNode next = temp.next;
			while(next != null && temp.val == next.val){
				temp.next = next.next;
				next = temp.next;
			}
			
			
			temp = temp.next;
			
		}
		
		return head;
	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
