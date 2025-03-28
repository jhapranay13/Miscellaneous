package elementsOfProgramming.LinkedLists;

public class AddIntegerRepresentedAsListHeadLeastSignificant {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		SinglyLinkedListNode two = new SinglyLinkedListNode();
		SinglyLinkedListNode three = new SinglyLinkedListNode();
		SinglyLinkedListNode four = new SinglyLinkedListNode();
		SinglyLinkedListNode five = new SinglyLinkedListNode();
		SinglyLinkedListNode six = new SinglyLinkedListNode();
		SinglyLinkedListNode seven = new SinglyLinkedListNode();
		SinglyLinkedListNode eight = new SinglyLinkedListNode();

		listOne.data = 4;
		listTwo.data = 4;
		two.data = 5;
		three.data = 2;
		four.data = 9;
		five.data = 6;
		six.data = 3;
		seven.data = 8;
		eight.data = 1;

		listTwo.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		listOne.next = six;
		six.next = seven;
		seven.next = eight;
		printSinglyLinkedList(listTwo);
		printSinglyLinkedList(listOne);
		printSinglyLinkedList( addListIntegers( listTwo, listOne ) );
	}


	private static SinglyLinkedListNode addListIntegers(SinglyLinkedListNode listTwo, 
			SinglyLinkedListNode listOne) {
		SinglyLinkedListNode returnListHead = null;
		SinglyLinkedListNode runner = null;
		int carry = 0;

		do {
			int addition = listTwo.data + listOne.data + carry;
			carry = addition / 10;
			addition = addition % 10;

			if( returnListHead == null ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				returnListHead = temp;
				temp.data = addition;
				listOne = listOne.next;
				listTwo = listTwo.next;
				continue;
			}

			if( runner == null ) {
				runner = new SinglyLinkedListNode();
				runner.data = addition;
				returnListHead.next = runner;
			} else {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				temp.data = addition;
				runner.next = temp;
				runner = temp;
			}
			listOne = listOne.next;
			listTwo = listTwo.next;
		} while( listTwo != null && listOne != null );
		SinglyLinkedListNode nodeLeftToAdd = listOne != null ? listOne : listTwo;

		while( nodeLeftToAdd != null ) {
			SinglyLinkedListNode temp = new SinglyLinkedListNode();
			int addition = ( carry + nodeLeftToAdd.data ) % 10;
			carry = ( carry + nodeLeftToAdd.data ) / 10;
			temp.data = addition;
			runner.next = temp;
			runner = temp;
			nodeLeftToAdd = nodeLeftToAdd.next;
		}
		
		if( runner.data > 10 ) {
			SinglyLinkedListNode temp = new SinglyLinkedListNode();
			temp.data = runner.data % 10;
			runner.data /= 10;
			runner.next = temp;
		}
		return returnListHead;
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
