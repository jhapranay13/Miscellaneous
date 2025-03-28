package elementsOfProgramming.LinkedLists;

public class EvenAndOddMerge {

	public static void main(String[] args) {

		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;

		for( int i = 1; i <= 22; i += 3 ) {
			current.data = i;

			if( i != 22 ) {
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
		SinglyLinkedListNode mergedList = evenOddMerge( listOne, listTwo );
		printSinglyLinkedList(mergedList);
	}

	private static SinglyLinkedListNode evenOddMerge(SinglyLinkedListNode listOne, SinglyLinkedListNode listTwo) {
		SinglyLinkedListNode mergedList = null;
		SinglyLinkedListNode tempEvenHead = null;
		SinglyLinkedListNode tempEvenRunner = null;
		SinglyLinkedListNode tempOddHead = null;
		SinglyLinkedListNode tempOddRunner = null;
		int evenCounter = 0;
		int oddCounter = 0;

		while( listOne != null ) {

			if( listOne.data % 2 == 0 ) {
				SinglyLinkedListNode temp = listOne;
				listOne = listOne.next;
				tempEvenHead = tempEvenHead == null ? temp : tempEvenHead;
				tempEvenRunner = tempEvenRunner == null ? tempEvenHead : tempEvenRunner;
				
				if( evenCounter++ > 0 ) {
					tempEvenRunner.next = temp;
					tempEvenRunner = temp;
				}	
				temp.next = null;
			} else {
				SinglyLinkedListNode temp = listOne;
				listOne = listOne.next;
				tempOddHead = tempOddHead == null ? temp : tempOddHead;
				tempOddRunner = tempOddRunner == null ? tempOddHead : tempOddRunner;
				
				if( oddCounter++ > 0 ) {
					tempOddRunner.next = temp;
					tempOddRunner = temp;
				}	
				temp.next = null;
			}
		}
		
		while( listTwo != null ) {
			
			if( listTwo.data % 2 == 0 ) {
				SinglyLinkedListNode temp = listTwo;
				listTwo = listTwo.next;
				tempEvenHead = tempEvenHead == null ? temp : tempEvenHead;
				tempEvenRunner = tempEvenRunner == null ? tempEvenHead : tempEvenRunner;
				
				if( evenCounter++ > 0 ) {
					tempEvenRunner.next = temp;
					tempEvenRunner = temp;
				}	
				temp.next = null;
			} else {
				SinglyLinkedListNode temp = listTwo;
				listTwo = listTwo.next;
				tempOddHead = tempOddHead == null ? temp : tempOddHead;
				tempOddRunner = tempOddRunner == null ? tempOddHead : tempOddRunner;
				
				if( oddCounter++ > 0 ) {
					tempOddRunner.next = temp;
					tempOddRunner = temp;
				}	
				temp.next = null;
			}
		}
		mergedList = tempEvenHead;
		tempEvenRunner.next = tempOddHead;
		return mergedList;
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
