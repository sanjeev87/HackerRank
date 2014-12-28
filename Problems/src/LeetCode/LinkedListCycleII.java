package LeetCode;

public class LinkedListCycleII {

	public static ListNode detectCycle(ListNode head) {
        
        ListNode lead = head;
        ListNode trail = head;
        
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        
        while(lead != null && trail != null){
           
                lead = lead.next;
                if(lead != null){
                    lead = lead.next;
                }else{
                    return null;
                }
                
                trail = trail.next;
                
                if(lead == null || trail == null ){
                    return null;
                }
                
                if(lead == trail){
                    break;
                }
            
            
        }
        
        trail = head;
        
        while (trail != lead){
            trail = trail.next;
            lead = lead.next;
        }
        
        return lead;
        
    }


	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		ListNode start = detectCycle(node1);
		
		System.out.println(start.val);
		
		
		

	}

}
