package elementsOfProgramming.LinkedLists;

public class TestForCyclicity {

	public static void main(String[] args) {
		SinglyLinkedListNode list = new SinglyLinkedListNode();
		SinglyLinkedListNode current = list;
		SinglyLinkedListNode cycleStart = null;

		for( int i = 6; i <= 28; i += 2 ) {
			current.data = i;
			
			if( i == 16 ) {
				cycleStart = current;
			}
			
			if( i == 28 ) {
				current.next = cycleStart;
			}

			if( i != 28 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		SinglyLinkedListNode startOfCycle = detectCyclicity( list );
		System.out.println( startOfCycle.data );
	}
	
	private static SinglyLinkedListNode detectCyclicity(SinglyLinkedListNode list) {
		SinglyLinkedListNode slow = list;
		SinglyLinkedListNode fast = list;
		
		do {
			slow = slow.next;
			fast = fast.next.next;
		} while( slow.data != fast.data );
		slow = list;
		
		while( slow.data != fast.data ) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	//Another way by detecting length of cycle
	/*private static SinglyLinkedListNode detectCyclicity(SinglyLinkedListNode list) {
		SinglyLinkedListNode slow = list;
		SinglyLinkedListNode fast = list;
		int steps = 0;
		
		do {
			slow = slow.next;
			fast = fast.next.next;
			steps++;
		} while( slow.data != fast.data );
		int cycleLength = 1;
		fast = fast.next;
		
		while( slow.data != fast.data ) {
			cycleLength++;
			fast = fast.next;
		}
		fast = list;
		slow = list;
		
		while( cycleLength != 0 ) {
			fast = fast.next;
			cycleLength--;
		}
		
		while( slow.data != fast.data ) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}*/
}
