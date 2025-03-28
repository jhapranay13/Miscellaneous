package datstructureAndAlorithm.Queue;

import datstructureAndAlorithm.LinkedList.SingleNode;

class SinglyLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;
	
	public SingleNode getHead() {
		return head;
	}
	
	public void setHead(SingleNode head) {
		this.head = head;
	}
	
	public SingleNode getTail() {
		return tail;
	}
	
	public void setTail(SingleNode tail) {
		this.tail = tail;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public SingleNode createSingleLinkedList( int nodeValue ) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue( nodeValue );
		node.setNext( null );
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		
		if (!existsLinkedList()) { // Linked List does not exists
			System.out.println("The linked list does not exist!!");
			return; 
		} else if ( location == 0 ) {// insert at first position
			node.setNext(head);
			head = node;
		} else if (location >= size) {// insert at last position
			node.setNext(null);
			tail.setNext(node);
			tail = node; 
		} else {// insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node
			SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node
			tempNode.setNext(node);//update reference of tempNode to reference to new node
			node.setNext(nextNode);//update newly added nodes' next.
		}
		setSize( getSize() + 1 );
	}
	
	public void traverseLinkedList() {
		
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			
			for (int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getValue());
				
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}
	
	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
	
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	}
	
	public boolean searchNode(int nodeValue) {
		
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			
			for (int i = 0; i < getSize(); i++) {
				
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: "+i+"\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! \n");
		return false;
	}
	
	public void deletionOfNode(int location) {
		
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			head = head.getNext();
			setSize(getSize()-1);
			
			if(getSize() == 0) { // if there are no more nodes in this list
				tail = null;
			}	
		}else if (location >= getSize()){ //If location is not in range or equal, then delete last node
			SingleNode tempNode = head;
			
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); //temp node points to 2nd last node
			}
			
			if (tempNode == head) { //if this is the only element in the list
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null); 
			tail= tempNode;
			setSize(getSize()-1);
			
		}else { //if any inside node is to be deleted
			SingleNode tempNode = head;
			
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}	
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize()-1);
		}
	}
}

class QueueByLinkedList {
	SinglyLinkedList list;
	
	public QueueByLinkedList() {
		list = new SinglyLinkedList();
	}
	
	public void enQueue(int value) {
		
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			// push a value on last of queue, update list tail too
			list.insertInLinkedList(value, list.getSize());
		}
	}
	
	public int deQueue() {
		int value = -1;
		
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			value = list.getHead().getValue();
			list.deletionOfNode(0);
		}
		return value;
	}
	
	public int peek() {
		
		if (!isQueueEmpty())
			return list.getHead().getValue();
		else {
			System.out.println("The queue is empty!!");
			return -1;
		}
	}

	public boolean isQueueEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}
	
	public void deleteStack() {
		list.setHead(null);
	}
}

public class QueueByLinkedListOperation {

	public static void main(String[] args) {
		System.out.println("Creating a queue");
		QueueByLinkedList queue = new QueueByLinkedList();
		System.out.println("Enqueueing 6 values into queue");
		
		for(int i=1 ; i<=6; i++) {
			queue.enQueue(i*10);
		}
		System.out.println();
		System.out.println("Peeking value");
		System.out.println(queue.peek());
		System.out.println();
		System.out.println("Dequeueing 6 values into queue");
		
		for(int i=0; i<6; i++) {
			System.out.println(queue.deQueue());
		}
	}
}
