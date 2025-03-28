package elementsOfProgramming.LinkedLists;

public class ListPivoting {

	public static void main(String[] args) {
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		SinglyLinkedListNode two = new SinglyLinkedListNode();
		SinglyLinkedListNode three = new SinglyLinkedListNode();
		SinglyLinkedListNode four = new SinglyLinkedListNode();
		SinglyLinkedListNode five = new SinglyLinkedListNode();
		SinglyLinkedListNode six = new SinglyLinkedListNode();
		SinglyLinkedListNode seven = new SinglyLinkedListNode();
		SinglyLinkedListNode eight = new SinglyLinkedListNode();

		listTwo.data = 11;
		two.data =2;
		three.data = 14;
		four.data = 7;
		five.data = 8;
		six.data = 2;
		seven.data = 1;
		eight.data = 4;

		listTwo.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		printSinglyLinkedList(listTwo);
		printSinglyLinkedList( listPivoting( listTwo, 8 ) );
	}

	private static SinglyLinkedListNode listPivoting(SinglyLinkedListNode list, int pivotPoint) {
		int pivotPointExistFlag = pivotPointExist( list, pivotPoint );
		SinglyLinkedListNode headRunner = list;
		SinglyLinkedListNode greaterThanHead = null;
		SinglyLinkedListNode greaterThanRunner = null;
		SinglyLinkedListNode lessThanHead = null;
		SinglyLinkedListNode lessThanRunner = null;
		SinglyLinkedListNode pivotNode = null;

		if( pivotPointExistFlag != -1 ) {

			while( headRunner != null ) {
				SinglyLinkedListNode nextHolder = headRunner.next;
				
				if( headRunner.data > pivotPoint ) {
					SinglyLinkedListNode temp = headRunner;
					temp.next = null;

					if( greaterThanHead == null ) {
						greaterThanHead = greaterThanRunner = temp;
					} else {
						greaterThanRunner.next = temp;
						greaterThanRunner = temp;
					}
				} else if( headRunner.data < pivotPoint ) {
					SinglyLinkedListNode temp = headRunner;
					temp.next = null;

					if( lessThanHead == null ) {
						lessThanHead = lessThanRunner = temp;
					} else {
						lessThanRunner.next = temp;
						lessThanRunner = temp;
					}
				} else {
					pivotNode = headRunner;
					headRunner.next = null;
				}
				headRunner = nextHolder;
			}
		}
		lessThanRunner.next = pivotNode;
		pivotNode.next = greaterThanHead;
		return lessThanHead;
	}

	private static int pivotPointExist(SinglyLinkedListNode list, int pivotPoint) {
		boolean returnFlag = false;
		int counter = -1;

		while( list != null ) {
			counter++;

			if( list.data == pivotPoint ) {
				returnFlag = true;
				break;
			}
			list = list.next;
		}
		return returnFlag ? counter + 1 : -1;
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
