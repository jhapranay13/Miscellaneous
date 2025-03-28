package elementsOfProgramming.LinkedLists;

public class OverlappingListsWithoutCyclicity {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;
		SinglyLinkedListNode lastNode = null;

		for( int i = 6; i <= 14; i += 2 ) {
			current.data = i;

			if( i == 14 ) {
				lastNode = current;
			}
			if( i != 14 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		current = listTwo;

		for( int i = 5; i < 24; i += 2  ) {
			current.data = i;
			
			if( i == 11 ) {
				lastNode.next = current;
			}

			if( i <= 24 - 2 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			} 
		}
		printSinglyLinkedList( listOne );
		printSinglyLinkedList( listTwo );
		SinglyLinkedListNode startOfIntersection = getIntersection( listOne, listTwo );
		System.out.println( startOfIntersection.data );
	}

	private static SinglyLinkedListNode getIntersection(SinglyLinkedListNode listOne, 
			SinglyLinkedListNode listTwo) {
		SinglyLinkedListNode onePointer = listOne;
		SinglyLinkedListNode twoPointer = listTwo;
		int oneLength = 0;
		int twoLength = 0;
		int listFlag = -1;
		
		while( onePointer != null ) {
			oneLength++;
			onePointer = onePointer.next;
		}
		
		while( twoPointer != null ) {
			twoLength++;
			twoPointer = twoPointer.next;
		}
		int difference = -1;
		
		if( oneLength < twoLength ) {
			difference = twoLength - oneLength;
			listFlag = 2;
		} else {
			difference = oneLength - twoLength;
			listFlag = 1;
		}
		onePointer = listOne;
		twoPointer = listTwo;
		
		if( listFlag == 1 ) {
			
			while( difference-- != 0 ) {
				onePointer = onePointer.next;
			}
		} else {
			while( difference-- != 0 ) {
				twoPointer = twoPointer.next;
			}
		}
		
		while( onePointer.data != twoPointer.data ) {
			onePointer = onePointer.next;
			twoPointer = twoPointer.next;
		}
		return onePointer;
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
