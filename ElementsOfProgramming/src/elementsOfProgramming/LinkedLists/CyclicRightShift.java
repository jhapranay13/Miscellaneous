package elementsOfProgramming.LinkedLists;

public class CyclicRightShift {

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
		SinglyLinkedListNode cyclicShiftList = shiftList( listOne, 2 ); 
		printSinglyLinkedList( cyclicShiftList );
	}

	private static SinglyLinkedListNode shiftList(SinglyLinkedListNode list, int shiftRight) {
		SinglyLinkedListNode slow = list;
		SinglyLinkedListNode fast = list;
		SinglyLinkedListNode lastNode = getLastNode(list);
		shiftRight %= getSize(list);
		
		while( fast.next != null ) {
			
			if( shiftRight-- > 0 ) {
				fast = fast.next;
				continue;
			}
			fast = fast.next;
			slow = slow.next;
		}
		SinglyLinkedListNode breakingPoint = slow.next;
		slow.next = null;
		lastNode.next = list;
		return breakingPoint;
	}

	private static SinglyLinkedListNode getLastNode(SinglyLinkedListNode list) {
		SinglyLinkedListNode current = list; 

		while( current.next != null ) { 
			current = current.next;
		}
		return current;
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
