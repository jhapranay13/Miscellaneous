package elementsOfProgramming.LinkedLists;

public class RemoveTheKthLastElement {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;

		for( int i = 6; i <= 22; i += 2 ) {
			current.data = i;

			if( i != 22 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		printSinglyLinkedList(listOne);
		int elementFromEndToBeDeleted = 4;
		deleteKthElementFromEnd( listOne, elementFromEndToBeDeleted );
		printSinglyLinkedList( listOne );
	}
	
	private static void deleteKthElementFromEnd(SinglyLinkedListNode list, int elementFromEndToBeDeleted) {
		SinglyLinkedListNode slow = list;
		SinglyLinkedListNode fast = list;
		
		while( elementFromEndToBeDeleted-- != 1 ) {
			fast = fast.next;
		}
		SinglyLinkedListNode previousSlow = null;
		
		while( fast.next != null ) {
			previousSlow = slow;
			slow = slow.next;
			fast = fast.next;
		}
		previousSlow.next = slow.next;
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
