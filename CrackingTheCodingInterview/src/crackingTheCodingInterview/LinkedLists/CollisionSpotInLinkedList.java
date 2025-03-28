package crackingTheCodingInterview.LinkedLists;

public class CollisionSpotInLinkedList {

	//Number of steps taken by fast / num of steps taken by slow before collision will give
	//you the distance away from start of loop
	public static void main(String[] args) {
		SinglyLinkedListIntVal first = new SinglyLinkedListIntVal();
		first.setValue( 1 );
		SinglyLinkedListIntVal second = new SinglyLinkedListIntVal();
		second.setValue( 4 );
		SinglyLinkedListIntVal third = new SinglyLinkedListIntVal();
		third.setValue( 7 );
		SinglyLinkedListIntVal fourth = new SinglyLinkedListIntVal();
		fourth.setValue( 5 );
		SinglyLinkedListIntVal fifth = new SinglyLinkedListIntVal();
		fifth.setValue( 6 );
		SinglyLinkedListIntVal sixth = new SinglyLinkedListIntVal();
		sixth.setValue( 3 );
		SinglyLinkedListIntVal seventh = new SinglyLinkedListIntVal();
		seventh.setValue( 15 );
		SinglyLinkedListIntVal eighth = new SinglyLinkedListIntVal();
		eighth.setValue( 16 );
		SinglyLinkedListIntVal ninth = new SinglyLinkedListIntVal();
		ninth.setValue( 13 );
		
		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		sixth.setNext( seventh );
		seventh.setNext( eighth );
		eighth.setNext( ninth );
		ninth.setNext( fourth );
		
		SinglyLinkedListIntVal collisionNode = getCollisionNode( first );
		System.out.println( collisionNode.getValue() );
	}

	private static SinglyLinkedListIntVal getCollisionNode(SinglyLinkedListIntVal first) {
		SinglyLinkedListIntVal head = first;
		SinglyLinkedListIntVal slowRunner = first;
		SinglyLinkedListIntVal fastRunner = first;
		
		do {
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext().getNext();
		} while( slowRunner != fastRunner );
		
		slowRunner = head;
		
		while( slowRunner != fastRunner ) {
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext();
		}
		
		return slowRunner;
	}

}
