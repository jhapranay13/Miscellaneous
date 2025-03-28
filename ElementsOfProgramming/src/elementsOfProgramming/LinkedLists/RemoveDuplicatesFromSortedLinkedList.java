package elementsOfProgramming.LinkedLists;

public class RemoveDuplicatesFromSortedLinkedList {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;

		for( int i = 6; i <= 22; i += 2 ) {
			current.data = i;
			
			if( i % 5 == 0 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				temp.data = i;
				current.next = temp;
				current = temp;
			}

			if( i != 22 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		printSinglyLinkedList(listOne);
		removeDuplicateElements( listOne );
		printSinglyLinkedList( listOne );
	}
	

	private static void removeDuplicateElements(SinglyLinkedListNode list) {
		
		while( list.next != null ) {
			
			if( list.data == list.next.data ) {
				list.next = list.next.next;
			}
			list = list.next;
		}
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
