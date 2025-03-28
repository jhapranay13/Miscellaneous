package crackingTheCodingInterview.LinkedLists;

public class KthToTheLast {

	public static void main(String[] args) {
		SinglyLikedListNode first = new SinglyLikedListNode();
		first.setValue("A");
		SinglyLikedListNode second = new SinglyLikedListNode();
		second.setValue( "B" );
		SinglyLikedListNode third = new SinglyLikedListNode();
		third.setValue( "C" );
		SinglyLikedListNode fourth = new SinglyLikedListNode();
		fourth.setValue("D");
		SinglyLikedListNode fifth = new SinglyLikedListNode();
		fifth.setValue( "E" );
		SinglyLikedListNode sixth = new SinglyLikedListNode();
		sixth.setValue( "F" );
		SinglyLikedListNode seventh = new SinglyLikedListNode();
		seventh.setValue( "G" );

		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		sixth.setNext( seventh );

		SinglyLikedListNode head = first;
		printKthToTheLast( head, 2 );
	}

	private static void printKthToTheLast(SinglyLikedListNode head, int k) {
		SinglyLikedListNode runner = head.getNext();
		SinglyLikedListNode pointer = head;
		int counter = 1;

		while( pointer != null ) {

			for( ;counter <= k; counter++ ) {
				runner = runner.getNext();
			}
			pointer = pointer.getNext();
			runner  = runner.getNext();
			
			if( runner == null ) {
				System.out.println( pointer.getValue() );
				break;
			}
		}
	}
}
