package LeetCode;

import java.util.List;

public class MergeKSortedLists {

	
	public ListNode mergeLists(ListNode l1, ListNode l2){
		
		ListNode fakeHead = new ListNode(0);
		ListNode cur = fakeHead;
		
		while(l1 != null && l2!= null){
			
			ListNode temp = null;
			if(l1.val < l2.val){
				temp = l1;
				l1 = l1.next;
			}else{
				temp = l2;
				l2 = l2.next;
			}
			
			cur.next = temp;
			temp.next = null;
			cur = cur.next;
			
		}
		
		if(l1 != null){
			cur.next = l1;
		}
		
		if(l2 != null){
			cur.next = l2;
		}
		
		
		return fakeHead.next;
	}
	
	
	
	public ListNode mergeKLists(List<ListNode> lists) {
		
		
		int length = lists.size();
		
		if(length == 0){
			return null;
		}
		
		if(length == 1){
			return lists.get(0);
		}
		
		
		int mid = length/2;
		
		ListNode left = mergeKLists(lists.subList(0, mid));
		ListNode right = mergeKLists(lists.subList(mid, length));
		
		return mergeLists(left, right);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
