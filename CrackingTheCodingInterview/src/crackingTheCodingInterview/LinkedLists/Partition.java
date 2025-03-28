package crackingTheCodingInterview.LinkedLists;

public class Partition {

	public static void main(String[] args) {
		SinglyLinkedListIntVal first = new SinglyLinkedListIntVal();
		first.setValue( 1 );
		SinglyLinkedListIntVal second = new SinglyLinkedListIntVal();
		second.setValue( 4 );
		SinglyLinkedListIntVal third = new SinglyLinkedListIntVal();
		third.setValue( 7 );
		SinglyLinkedListIntVal fourth = new SinglyLinkedListIntVal();
		fourth.setValue( 5 );
		SinglyLinkedListIntVal fifth = new SinglyLinkedListIntVal();
		fifth.setValue( 6 );
		SinglyLinkedListIntVal sixth = new SinglyLinkedListIntVal();
		sixth.setValue( 3 );

		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );

		SinglyLinkedListIntVal head = first;
		head = partition( head, 5 );
		printLinkedList( head );
	}

	private static SinglyLinkedListIntVal partition(SinglyLinkedListIntVal head, int value) {
		SinglyLinkedListIntVal lowVal = null;
		SinglyLinkedListIntVal lowValLast = null;
		SinglyLinkedListIntVal highVal = null;
		SinglyLinkedListIntVal currentNode = head;
		
		while( currentNode != null ) {
			SinglyLinkedListIntVal next = currentNode.getNext();
			
			if( currentNode.getValue() < value ) {
				
				if( lowVal == null ) {
					currentNode.setNext( null );
					lowVal = currentNode;
					lowValLast = currentNode;
					currentNode = next;
				} else {
					currentNode.setNext( lowVal );
					lowVal = currentNode;
				}
			} else {
				
				if( highVal == null ) {
					currentNode.setNext( null );
					highVal = currentNode;
					currentNode = next;
				} else {
					currentNode.setNext( highVal );
					highVal = currentNode;
				}
			}
			currentNode = next;
		}
		
		lowValLast.setNext( highVal );
		
		return lowVal;
	}

	private static void printLinkedList(SinglyLinkedListIntVal first) {
		SinglyLinkedListIntVal currentNode = first;
		int counter = 0;

		while( currentNode != null ) {

			if( counter > 0 ) {
				System.out.print(  ",  " );
			}
			System.out.print( currentNode.getValue() );
			currentNode = currentNode.getNext();
			counter++;
		}
	}
}
