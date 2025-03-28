package crackingTheCodingInterview.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDupsUsingBuffer {

	public static void main(String[] args) {
		SinglyLikedListNode first = new SinglyLikedListNode();
		first.setValue("A");
		SinglyLikedListNode second = new SinglyLikedListNode();
		second.setValue( "A" );
		SinglyLikedListNode third = new SinglyLikedListNode();
		third.setValue( "C" );
		SinglyLikedListNode fourth = new SinglyLikedListNode();
		fourth.setValue("B");
		SinglyLikedListNode fifth = new SinglyLikedListNode();
		fifth.setValue( "D" );
		SinglyLikedListNode sixth = new SinglyLikedListNode();
		sixth.setValue( "D" );

		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );

		SinglyLikedListNode head = first;
		removeDuplicate( head );
		printLinkedList( first );
	}

	private static void printLinkedList(SinglyLikedListNode first) {
		SinglyLikedListNode currentNode = first;
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

	private static void removeDuplicate(SinglyLikedListNode head) {
		Map< String, SinglyLikedListNode > buffer = new HashMap<>();
		SinglyLikedListNode currentNode = head;

		while( currentNode != null ) {
			SinglyLikedListNode next = currentNode.getNext();

			if( next != null && ( next.getValue().equals( currentNode.getValue() ) || 
					buffer.containsKey( next.getValue() ) ) ) {
				currentNode.setNext( next.getNext() );
				continue;
			}

			if( !buffer.containsKey( currentNode.getValue() ) ) {
				buffer.put(  currentNode.getValue() , currentNode );
			}
			currentNode = next;
		}
	}
}
