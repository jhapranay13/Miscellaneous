package crackingTheCodingInterview.LinkedLists;

public class DeleteTheGivenNodeInTheMiddle {

	//cannot happen if the node is the last node
	public static void main(String[] args) {
		SinglyLikedListNode first = new SinglyLikedListNode();
		first.setValue("A");
		SinglyLikedListNode second = new SinglyLikedListNode();
		second.setValue( "B" );
		SinglyLikedListNode third = new SinglyLikedListNode();
		third.setValue( "C" );
		SinglyLikedListNode fourth = new SinglyLikedListNode();
		fourth.setValue("D");
		SinglyLikedListNode fifth = new SinglyLikedListNode();
		fifth.setValue( "E" );
		SinglyLikedListNode sixth = new SinglyLikedListNode();
		sixth.setValue( "F" );

		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );

		SinglyLikedListNode head = first;
		removeTheNode( fourth );
		printLinkedList( head );
	}
	
	private static void removeTheNode(SinglyLikedListNode node) {
		
		if( node.getNext() != null ) {
			node.setValue( node.getNext().getValue() );
			node.setNext( node.getNext().getNext() );
		}
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
}
