package LeetCode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		
		ListNode fakeHeadSmall = new ListNode(0);
		ListNode fakeHeadLarge = new ListNode(0);
		
		fakeHeadSmall.next = head;
		
		ListNode trav = head;
		ListNode prev = fakeHeadSmall;
		ListNode greaterListTail = fakeHeadLarge;
		
		while(trav != null){
			
			if(trav.val < x){
				prev = trav;
				trav = trav.next;
			}else{
				
				prev.next = trav.next;
				greaterListTail.next = trav;
				greaterListTail = trav;
				trav = trav.next;
				
			}
			
		}
		
		greaterListTail.next = null;
		
		prev.next = fakeHeadLarge.next;
		
		
		return fakeHeadSmall.next;
	}

	public static void main(String[] args) {

		String s = "Hi";
		
		//System.out.println(s.substring(0, 1));
		//System.out.println(s.substring(0, 0));
		//System.out.println(s.substring(1, 1));
		System.out.println(s.substring(1, 2));
		System.out.println(s.substring(2, 2));
		
		
	}

}
