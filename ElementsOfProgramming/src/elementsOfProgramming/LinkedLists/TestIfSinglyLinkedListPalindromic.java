package elementsOfProgramming.LinkedLists;

public class TestIfSinglyLinkedListPalindromic {

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
		printSinglyLinkedList( listOne );
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		SinglyLinkedListNode two = new SinglyLinkedListNode();
		SinglyLinkedListNode three = new SinglyLinkedListNode();
		SinglyLinkedListNode four = new SinglyLinkedListNode();
		SinglyLinkedListNode five = new SinglyLinkedListNode();
		//SinglyLinkedListNode six = new SinglyLinkedListNode();
		
		listTwo.data = 1;
		two.data =2;
		three.data = 4;
		four.data = 2;
		five.data = 1;
		
		listTwo.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		printSinglyLinkedList(listTwo);
		
		boolean palindromicListFlag = isListPalindromic( listOne );
		System.out.println( palindromicListFlag );
	}

	private static boolean isListPalindromic(SinglyLinkedListNode list) {
		int size = getSize( list );
		SinglyLinkedListNode fast = list.next;
		SinglyLinkedListNode slow = list;
		
		while( fast.next != null ) {
			slow = slow.next;
			fast = fast.next;

			if( fast.next != null ) {
				fast = fast.next;
			} else {
				break;
			}
		}
		SinglyLinkedListNode reversedPartial = reverseList( slow.next );
		
		if( size % 2 == 0 ) {
			
			while( list != null ) {
				
				if( list.data != reversedPartial.data ) {
					return false;
				}
				list = list.next;
				reversedPartial = reversedPartial.next;
			}
		} 
		int reversedSize = getSize( reversedPartial );
		
		if( reversedSize * 2 + 1 == size  ) {
			
			while( reversedPartial != null ) {
				
				if( reversedPartial.data != list.data ) {
					return false;
				}
				reversedPartial = reversedPartial.next;
				list = list.next;
			}
		}	
		return true;
	}

	private static SinglyLinkedListNode reverseList(SinglyLinkedListNode partailList) {
		SinglyLinkedListNode reversedList = null;
		int size = getSize( partailList );
		
		if( size > 1 ) {
			SinglyLinkedListNode previous = partailList;
			SinglyLinkedListNode current = previous.next;
			previous.next = null;
			
			while( current != null ) {
				SinglyLinkedListNode temp = current.next;
				current.next = previous;
				previous = current;
				current = temp;
			}
			reversedList = previous;
		} else {
			reversedList = partailList;
		}
		
		return reversedList;
	}

	private static int getSize(SinglyLinkedListNode list) {
		int size = 0;
		
		while( list != null ) {
			size++;
			list = list.next;
		}
		return size;
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
