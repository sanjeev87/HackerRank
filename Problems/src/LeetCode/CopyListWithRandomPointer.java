package LeetCode;

public class CopyListWithRandomPointer {

	
	public static RandomListNode copyRandomList(RandomListNode head) {

		
		if(head == null){
			return null;
		}
		
		RandomListNode p = head;
		
		while(p != null){
			
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
			
		}
		
		p = head;
		
		while(p != null){
			RandomListNode copy = p.next;
			if(p.random != null){
				copy.random = p.random.next;
			}
			p = copy.next;
		}
		
		p = head;
		RandomListNode newHead = p.next;
		
		while(p != null){
			RandomListNode copy = p.next;
			//RandomListNode temp = 
			p.next = copy.next;
			if(copy.next != null)
				copy.next = copy.next.next;
			
			p = p.next;
		}
		

		return newHead;

	}
	
	
	public static void main(String[] args) {

	}

}
