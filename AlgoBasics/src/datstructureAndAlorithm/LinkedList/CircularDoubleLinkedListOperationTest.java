package datstructureAndAlorithm.LinkedList;

class DoubleCircularLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	private int size;
	
	public DoubleNode getHead() {
		return head;
	}
	
	public void setHead(DoubleNode head) {
		this.head = head;
	}
	
	public DoubleNode getTail() {
		return tail;
	}
	
	public void setTail(DoubleNode tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public DoubleNode createDoubleLinkedList(int nodeValue) {
		head = new DoubleNode();
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setNext(node);
		node.setPrevious(node);
		head = node;
		tail = node;
		size = 1;// size =1
		return head;
	}
	
	void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			node.setPrevious(tail);
			head.setPrevious(node);
			tail.setNext(node);
			head = node;
		} else if (location >= size) { // insert at last position
			node.setNext(head);
			node.setPrevious(tail);
			head.setPrevious(node);
			tail.setNext(node);
			tail = node; // to keep track of last node
		} else {// insert at specified location
			DoubleNode tempNode = head;
			int index = 0;
			
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrevious(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrevious(node);
		}
		size++;// one node added so size increments
	}
	
	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
	
	public void traverseLinkedList() {
		
		if (existsLinkedList()) {
			DoubleNode tempNode = head;
			
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				
				if (i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();
	}
	
	public void traverseLinkedListInReverseOrder() {
		
		if (existsLinkedList()) {
			DoubleNode tempNode = tail;
			System.out.println("\nPrinting Linked list in reverse order...");
			
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				
				if (i != size-1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrevious();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
	}
	
	public void printHeadUsingTail() {
		
		if (existsLinkedList()) {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(tail.getValue());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}
	
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
	
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		}else {
			head.setPrevious(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}
	
	public boolean searchNode(int nodeValue) {
		
		if (existsLinkedList()) {
			DoubleNode tempNode = head;
			traverseLinkedList();
			
			for (int i = 0; i < size; i++) {
				
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");
		return false;
	}
	
	public void deletionOfNode(int location) {
		
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			
			if (getSize() == 1) { // if this is the only node in this list
				head.setNext(null);
				head.setPrevious(null);
				head = tail = null;
				setSize(getSize() - 1);
				return;
			}else {
				head = head.getNext();
				head.setPrevious(null);
				tail.setNext(head);
				setSize(getSize() - 1);
			}
		} else if (location >= getSize()) { // If location is not in range or equal, then delete last node
			
			if (getSize() == 1) { // if this is the only element in the list
				head.setNext(null);
				head.setPrevious(null);
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrevious();
			tail.setNext(head);
			head.setPrevious(tail);
			setSize(getSize() - 1);
		} else { // if any inside node is to be deleted
			DoubleNode tempNode = head;
			
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrevious(tempNode);
			setSize(getSize() - 1);
		} // end of else

	}
}

public class CircularDoubleLinkedListOperationTest {

	public static void main(String[] args) {
		DoubleCircularLinkedList list = new DoubleCircularLinkedList();
		list.createDoubleLinkedList(5);
		list.insertInLinkedList(10, 1);
		list.insertInLinkedList(20, 2);
		list.insertInLinkedList(30, 2);
		list.insertInLinkedList(40, 1);
		
		System.out.println("List Now: ");
		list.traverseLinkedList();
		
		list.traverseLinkedListInReverseOrder();
		list.printHeadUsingTail();
		
		
		System.out.println("\nSearching the node having value 40: ");
		list.searchNode(40);
		
		System.out.println("\nSearching the node having value 200: ");
		list.searchNode(200);
		
		
		System.out.println("\n\nDeleting the node having location = 0: ");
		System.out.println("Before Deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(0);
		System.out.println("After Deletion...");
		list.traverseLinkedList();
		
		System.out.println("\n\nDeleting the node having location = 3: ");
		System.out.println("Before Deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(3);
		System.out.println("After Deletion...");
		list.traverseLinkedList();

		System.out.println("\n\nDeleting the node having location = 20: ");
		System.out.println("Before Deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(20);
		System.out.println("After Deletion...");
		list.traverseLinkedList();
		
				
		list.deleteLinkedList();
		list.traverseLinkedList();
	}

}
