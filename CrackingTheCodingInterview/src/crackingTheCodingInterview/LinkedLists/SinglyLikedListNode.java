package crackingTheCodingInterview.LinkedLists;

public class SinglyLikedListNode {
	private SinglyLikedListNode next;
	private String value;
	
	public SinglyLikedListNode() {
		super();
	}

	public SinglyLikedListNode getNext() {
		return next;
	}
	
	public void setNext(SinglyLikedListNode next) {
		this.next = next;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
