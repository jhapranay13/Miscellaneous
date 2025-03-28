package crackingTheCodingInterview.LinkedLists;

public class SumLists {

	public static void main(String[] args) {
		SinglyLinkedListIntVal first = new SinglyLinkedListIntVal();
		first.setValue( 7 );
		SinglyLinkedListIntVal second = new SinglyLinkedListIntVal();
		second.setValue( 1 );
		SinglyLinkedListIntVal third = new SinglyLinkedListIntVal();
		third.setValue( 6 );
		SinglyLinkedListIntVal fourth = new SinglyLinkedListIntVal();
		fourth.setValue( 5 );
		SinglyLinkedListIntVal fifth = new SinglyLinkedListIntVal();
		fifth.setValue( 9 );
		SinglyLinkedListIntVal sixth = new SinglyLinkedListIntVal();
		sixth.setValue( 2 );
		//617 + 295
		first.setNext( second );
		second.setNext( third );
		fourth.setNext( fifth );
		fifth.setNext( sixth );

		SinglyLinkedListIntVal head = sumList( first, fourth );
		printLinkedList( head );
	}

	private static SinglyLinkedListIntVal sumList(SinglyLinkedListIntVal first, SinglyLinkedListIntVal second) {
		SinglyLinkedListIntVal head = null;
		SinglyLinkedListIntVal tail = null;
		int carry = 0;

		while( first != null || second != null ) {
			int sum = 0;
			sum += first != null ? first.getValue() : 0;
			sum += second != null ? second.getValue() : 0;
			sum += carry;
			carry = sum / 10;
			sum = sum % 10;
			SinglyLinkedListIntVal newNode = new SinglyLinkedListIntVal();
			newNode.setValue( sum );
			
			if( head == null ) {
				head = tail = newNode;
			} else {
				tail.setNext( newNode );
				tail = newNode;
			}
			
			if( first != null ) {
				first = first.getNext();
			}	
			
			if( second != null ) {
				second = second.getNext();
			}	
		}
		return head;
	}

	private static void printLinkedList(SinglyLinkedListIntVal first) {
		SinglyLinkedListIntVal currentNode = first;
		
		if( currentNode != null ) {
			printLinkedList( first.getNext() );
			System.out.print( first.getValue() );
		}
	}
}
