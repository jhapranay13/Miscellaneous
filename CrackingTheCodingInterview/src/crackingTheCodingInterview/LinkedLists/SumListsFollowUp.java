package crackingTheCodingInterview.LinkedLists;

public class SumListsFollowUp {

	//Can also be done using stack
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
		//716 + 592
		first.setNext( second );
		second.setNext( third );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		
		int sizeOne = 0;
		int sizeTwo = 0;
		SinglyLinkedListIntVal next = first;
		
		while( next != null ) {
			next = next.getNext();
			sizeOne++;
		}
		next = fourth;
		
		while( next != null ) {
			next = next.getNext();
			sizeTwo++;
		}
		next = new SinglyLinkedListIntVal();
		next.setValue( -1 );
		int carry = sumList( first, fourth, sizeOne, sizeTwo, next );
		
		if( carry != 0 ) {
			next.setValue( carry );
		}
		printLinkedList( next );
	}
	
	private static int sumList(SinglyLinkedListIntVal first, SinglyLinkedListIntVal second, 
			int sizeOne, int sizeTwo, SinglyLinkedListIntVal next) {
		
		if( first == null && second == null ) {
			return 0;
		}
		int carry = 0;
		
		if( sizeOne > sizeTwo ) {
			carry = sumList(first.getNext(), second, ( sizeOne - 1 ), sizeTwo, next );
		} else if( sizeTwo > sizeOne ) {
			carry = sumList(first, second.getNext(), sizeOne, ( sizeTwo - 1 ), next );
		} else {
			carry = sumList(first.getNext(), second.getNext(), ( sizeOne - 1 ), ( sizeTwo - 1 ), next );
		}
		int sum = 0;
		
		if( sizeOne == sizeTwo ) {
			sum += first.getValue() + second.getValue() + carry;
			carry = sum / 10;
			sum %= 10;
		} else if ( sizeOne < sizeTwo ) {
			sum += second.getValue() + carry;
			carry = sum / 10;
			sum %= 10;
		} else {
			sum += first.getValue() + carry;
			carry = sum / 10;
			sum %= 10;
		}
		SinglyLinkedListIntVal newNode = new SinglyLinkedListIntVal();
		newNode.setValue( sum );

		if( next.getNext() != null ) {
			SinglyLinkedListIntVal temp = next.getNext();
			newNode.setNext( temp );
		} 
		next.setNext( newNode );
		return carry;
	}

	private static void printLinkedList(SinglyLinkedListIntVal first) {
		SinglyLinkedListIntVal currentNode = first;
		
		while( currentNode != null ) {
			System.out.print( currentNode.getValue() );
			currentNode = currentNode.getNext();
		}
	}
}
