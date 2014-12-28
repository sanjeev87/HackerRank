package LeetCode;

public class IntersectionOfLinkedLIsts {


	public int getLength(ListNode head){

		int len = 0;

		if(head == null){
			return 0;
		}

		ListNode temp = head;
		while(temp != null){
			temp = temp.next;
			len++;
		}

		return len;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		int lenA = getLength(headA);
		int lenB = getLength(headB);

		ListNode tempA = headA;
		ListNode tempB = headB;

		if(tempA == null || tempB == null){
			return null;
		}

		int diff = Math.abs(lenA-lenB);


		if(lenA > lenB){
			while(diff != 0){
				if(tempA == null){
					return null;
				}
				tempA = tempA.next;
				diff--;
			}
		}else if(lenB > lenA){

			while(diff != 0){
				if(tempB == null){
					return null;
				}
				tempB = tempB.next;
				diff--;
			}
		}

		while(tempA != null && tempB != null){

			if(tempA == tempB){
				return tempA;
			}

			tempA = tempA.next;
			tempB = tempB.next;

		}


		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
