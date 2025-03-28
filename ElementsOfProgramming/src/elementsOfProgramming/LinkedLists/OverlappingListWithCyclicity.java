package elementsOfProgramming.LinkedLists;

public class OverlappingListWithCyclicity {

	public static void main(String[] args) {
		SinglyLinkedListNode listOne = new SinglyLinkedListNode();
		SinglyLinkedListNode current = listOne;
		SinglyLinkedListNode tempStop = null;
		SinglyLinkedListNode cycleStart = null;
		
		for( int i = 6; i <= 16; i += 2 ) {
			current.data = i;

			if( i != 16 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			}
		}
		SinglyLinkedListNode listTwo = new SinglyLinkedListNode();
		tempStop = current;
		current = listTwo;

		for( int i = 5; i < 20; i += 2  ) {
			current.data = i;
			
			if( i == 5 ) {
				cycleStart = current;
			}
			if( i == 11 ) {
				tempStop.next = current;
			}
			
			if( i == 19 ) {
				current.next = cycleStart;
				break;
			}
			if( i <= 20 - 2 ) {
				SinglyLinkedListNode temp = new SinglyLinkedListNode();
				current.next = temp;
				current = temp;
			} 
		}
		SinglyLinkedListNode startOfIntersection = getIntersection( listOne, listTwo );
		System.out.println( startOfIntersection.data );
	}

	private static SinglyLinkedListNode getIntersection(SinglyLinkedListNode listOne, 
			SinglyLinkedListNode listTwo) {
		SinglyLinkedListNode listOneCyclicityFlag = getCyclicity( listOne );
		SinglyLinkedListNode listTwoCyclicityFlag = getCyclicity( listTwo );
		
		if( listOneCyclicityFlag == null || listTwoCyclicityFlag == null ) {
			return null;
		}
		
		SinglyLinkedListNode root2 = listTwoCyclicityFlag;
		
		do {
			root2 = root2.next;
		} while( root2.data != listTwoCyclicityFlag.data &&
			root2.data != listOneCyclicityFlag.data );
		
		if( root2.data != listOneCyclicityFlag.data ) {
			return null;
		}
		
		int distanceForListOneToStartOfCycle = getDistance( listOne, listOneCyclicityFlag );
		int distanceForListTwoToStartOfCycle = getDistance( listOne, listOneCyclicityFlag );
		
		if( distanceForListOneToStartOfCycle > distanceForListTwoToStartOfCycle ) {
			int difference = distanceForListOneToStartOfCycle -
					distanceForListTwoToStartOfCycle;
			
			while( difference-- != 0 ) {
				listOne = listOne.next;
			}
		} else if(distanceForListOneToStartOfCycle < distanceForListTwoToStartOfCycle) {
			int difference = distanceForListTwoToStartOfCycle - 
					distanceForListOneToStartOfCycle;
			
			while( difference-- != 0 ) {
				listTwo = listTwo.next;
			}
		}
		
		while( listOne.data != listTwo.data && listOne.data != listOneCyclicityFlag.data &&
				listTwo.data != listTwoCyclicityFlag.data) {
			listOne = listOne.next;
			listTwo = listTwo.next;
		}
		return listOne.data == listTwo.data? listOne : listOneCyclicityFlag;
	}

	private static int getDistance(SinglyLinkedListNode list, 
			SinglyLinkedListNode cyclicityFlag) {
		int distance = 0;
		
		 while( list.data != cyclicityFlag.data ) {
			 distance++;
			 list = list.next;
		 }
		return distance;
	}

	private static SinglyLinkedListNode getCyclicity(SinglyLinkedListNode list) {
		SinglyLinkedListNode slow = list;
		SinglyLinkedListNode fast = list;
		
		do {
			slow = slow.next;
			fast = fast.next.next;
		} while( slow.data != fast.data );
		slow = list;
		
		do {
			slow = slow.next;
			fast = fast.next;
			
			if( slow.data == fast.data ) {
			}
		} while( slow.data != fast.data );
		
		return slow;
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
