package Interview;

public class LinkListNode {
	
	private LinkListNode next;
	private LinkListNode prev;
	private int value;
	
	public LinkListNode(int value){
		this.value = value;
		next = null;
		prev = null;
	}
	
	public LinkListNode(LinkListNode node){
		this.value = node.value;
		this.next = node.next;
		this.prev = node.prev;
	}

	public LinkListNode getNext() {
		return next;
	}

	public void setNext(LinkListNode next) {
		this.next = next;
	}

	public LinkListNode getPrev() {
		return prev;
	}

	public void setPrev(LinkListNode prev) {
		this.prev = prev;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	

}
