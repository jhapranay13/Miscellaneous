package crackingTheCodingInterview.LinkedLists;

public class PalindromeListUsingListReversal {

	public static void main(String[] args) {
		SinglyLinkedListIntVal first = new SinglyLinkedListIntVal();
		first.setValue( 1 );
		SinglyLinkedListIntVal second = new SinglyLinkedListIntVal();
		second.setValue( 4 );
		SinglyLinkedListIntVal third = new SinglyLinkedListIntVal();
		third.setValue( 5 );
		SinglyLinkedListIntVal fourth = new SinglyLinkedListIntVal();
		fourth.setValue( 5 );
		SinglyLinkedListIntVal fifth = new SinglyLinkedListIntVal();
		fifth.setValue( 4 );
		SinglyLinkedListIntVal sixth = new SinglyLinkedListIntVal();
		sixth.setValue( 7 );
		
		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		SinglyLinkedListIntVal reversed = new SinglyLinkedListIntVal();
		reversed.setValue( -1 );
		getReversed( first, reversed );
		reversed = reversed.getNext();
		boolean palindromeFlag = ifEqualThenPalindrome( first, reversed );
		System.out.println( palindromeFlag );
		printLinkedList( reversed );
	}

	private static boolean ifEqualThenPalindrome(SinglyLinkedListIntVal first, SinglyLinkedListIntVal reversed) {
		SinglyLinkedListIntVal originalListVal = first;
		SinglyLinkedListIntVal reversedVal = reversed;
		
		while( originalListVal != null && reversedVal != null ) {
			
			if( originalListVal.getValue() == reversedVal.getValue() ) {
				originalListVal = originalListVal.getNext();
				reversedVal = reversedVal.getNext();
			} else {
				return false;
			}
		}
		
		return true;
	}

	private static void getReversed(SinglyLinkedListIntVal root, SinglyLinkedListIntVal reversed) {
		
		if( root == null ) {
			return;
		}
		getReversed( root.getNext() , reversed);
		SinglyLinkedListIntVal temp = new SinglyLinkedListIntVal();
		temp.setValue( root.getValue() );
		
		if( reversed.getNext() == null ) {
			reversed.setNext( temp );
		} else {
			SinglyLinkedListIntVal current = reversed.getNext();
			
			while( current != null ) {
				
				if( current.getNext() == null ) {
					current.setNext( temp );
					break;
				}
				current = current.getNext();
			}
		}
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
