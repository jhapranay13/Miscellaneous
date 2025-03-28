package elementsOfProgramming.LinkedLists;

public class ReverseASingleSublist {

	public static void main(String[] args) {

		SinglyLinkedListNode list = new SinglyLinkedListNode();
		SinglyLinkedListNode current = list;

		for( int i = 6; i <= 28; i += 2 ) {
			current.data = i;

			if( i != 28 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		printSinglyLinkedList(list);
		reverseSubList( list, 3, 7 );
		printSinglyLinkedList(list);
	}

	private static void reverseSubList(SinglyLinkedListNode list, int startIndex, int endIndex) {
		SinglyLinkedListNode startMark = null;
		SinglyLinkedListNode endMark = null;
		SinglyLinkedListNode current = list;
		SinglyLinkedListNode previous = null;
		SinglyLinkedListNode start = null;

		
		for( int i = 0; i <= endIndex; i++ ) {
			
			if( i < startIndex ) {
				
				if( i == startIndex - 1 ) {
					startMark = current;
				}
				start = current = current.next;
				continue;
			}
			
			if( i == endIndex ) {
				endMark = current.next;
				start.next = endMark;
				startMark.next = current;
			}
			
			if( previous == null ) {
				previous = current;
				current = current.next;
				i++;
			}
			SinglyLinkedListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
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
