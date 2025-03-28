package elementsOfProgramming.LinkedLists;

public class RemoveGivenNumberOfDuplicates {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;

		for( int i = 6; i <= 22; i += 2 ) {
			current.data = i;

			if( i == 6 || i == 8 || i == 20 ) {
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
		printSinglyLinkedList( removeDuplicateElements( listOne, 2) );
	}


	private static SinglyLinkedListNode removeDuplicateElements(SinglyLinkedListNode list, 
			int limitToRemove) {
		int size = getSize( list );

		if( size == 1 && limitToRemove >= 1 ) {
			list.data = -1;
			return null;
		}

		if( size > 1 ) {
			SinglyLinkedListNode marker = list;
			SinglyLinkedListNode current = list;
			int counter = 1;

			while( current != null ) {
				SinglyLinkedListNode next = current.next;
				
				if( next == null ) {
					
					if( counter >= 2 ) {
						marker.next = null;
					}
					current = next;
					continue;
				}

				if( next.data == current.data ) {
					current = current.next;
					counter++;
				} else {

					if( counter >= limitToRemove ) {

						if( marker.data == current.data ) {
							marker = next;
							current.next = null;
							current = next;
							list = current;
						} else {
							marker.next = next;
							current = next;
						}
						counter = 1;
						continue;
					}
					marker = current;
					current = next;
				}
			}	
		}
		return list;
	}

	private static int getSize(SinglyLinkedListNode list) {
		SinglyLinkedListNode current = list; 
		int counter = 0;

		do {

			if( current!= null ) {
				counter++;
			}
			current = current.next;

		} while( current != null );
		return counter;
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
