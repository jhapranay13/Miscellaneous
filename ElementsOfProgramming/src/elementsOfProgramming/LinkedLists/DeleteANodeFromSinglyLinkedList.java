package elementsOfProgramming.LinkedLists;

public class DeleteANodeFromSinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedListNode current = null;
		SinglyLinkedListNode nodeToDelete = null;
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		current = listTwo;

		for( int i = 5; i < 24; i += 2  ) {
			current.data = i;
			
			if( i == 11 ) {
				nodeToDelete = current;
			}

			if( i <= 24 - 2 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			} 
		}
		printSinglyLinkedList( listTwo );
		deleteNode( nodeToDelete );
		printSinglyLinkedList( listTwo );
	}

	private static void deleteNode(SinglyLinkedListNode nodeToDelete) {
		nodeToDelete.data = nodeToDelete.next.data;
		nodeToDelete.next = nodeToDelete.next.next;
	}

	private static void printSinglyLinkedList(SinglyLinkedListNode list) {
		SinglyLinkedListNode current = list;

		while( current != null ) {
			System.out.print( current.data );

			if( current.next != null ) {
				System.out.print( " -> " );
				current = current.next;
			} else {
				break;
			}
		}
		System.out.println();
	}
}
