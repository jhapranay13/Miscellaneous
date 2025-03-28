package elementsOfProgramming.LinkedLists;

public class MergeTwoSortedList {

	public static void main(String[] args) {

		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;

		for( int i = 0; i <= 24; i += 3 ) {
			current.data = i;

			if( i != 24 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		current = listTwo;
		printSinglyLinkedList( listOne );

		for( int i = 0; i < 21; i += 5  ) {
			current.data = i;

			if( i != 20 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			} 
		}
		printSinglyLinkedList(listTwo);
		SinglyLinkedListNode mergedList = mergeSortedLists( listOne, listTwo );
		printSinglyLinkedList(mergedList);
	}

	private static SinglyLinkedListNode mergeSortedLists(SinglyLinkedListNode listOne, SinglyLinkedListNode listTwo) {
		SinglyLinkedListNode current  = new SinglyLinkedListNode();
		SinglyLinkedListNode head = null;

		while( listOne != null || listTwo != null ) {

			if( listOne != null && listTwo != null) {

				if( listOne.data > listTwo.data ) {
					current.next = listTwo;
					current = listTwo;
					listTwo = listTwo.next;
				} else if( listOne.data < listTwo.data ) {
					current.next = listOne;
					current = listOne;
					listOne = listOne.next;
				} else {
					current.next = listTwo;
					listTwo = listTwo.next;
				}
				
				if( head == null ) {
					head = current;
				}
				continue;
			}
			
			if( listOne != null ) {
				current.next = listOne;
				listOne = listOne.next;
			}
			
			if( listTwo != null ) {
				current.next = listTwo;
				listTwo = listTwo.next;
			}
		}
		return head;
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
