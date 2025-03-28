package crackingTheCodingInterview.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class IntersectingLinkedList {

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

		
		SinglyLinkedListIntVal firstAnother = new SinglyLinkedListIntVal();
		first.setValue( 12 );
		SinglyLinkedListIntVal secondAnother = new SinglyLinkedListIntVal();
		second.setValue( 13 );
		
		firstAnother.setNext( secondAnother );
		secondAnother.setNext( fifth );
		
		first.setNext( second );
		second.setNext( third );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		
		int lengthOfFirst = getLength( first );
		int lengthOfSecond = getLength( firstAnother );
		List< SinglyLinkedListIntVal > fromNodeIntersect = new ArrayList<>();
		boolean intersectFlag = isIntersecting( first, firstAnother, lengthOfFirst, 
				lengthOfSecond, fromNodeIntersect ); 
		System.out.println( intersectFlag );
		System.out.println( fromNodeIntersect.get( 0 ).getValue() );
	}

	private static boolean isIntersecting(SinglyLinkedListIntVal first, SinglyLinkedListIntVal second,
			int lengthOfFirst, int lengthOfSecond, List<SinglyLinkedListIntVal> fromNodeIntersect) {
		boolean intersectFlag = false;
		
		if( first == null && second == null ) {
			return false;
		}
		
		if( lengthOfFirst < lengthOfSecond ) {
			intersectFlag = isIntersecting(first, second.getNext(), 
					lengthOfFirst, ( lengthOfSecond - 1 ), fromNodeIntersect );
		} else if( lengthOfFirst > lengthOfSecond ) {
			intersectFlag = isIntersecting(first.getNext(), second, 
					( lengthOfFirst - 1 ), lengthOfSecond, fromNodeIntersect );
		} else {
			intersectFlag = isIntersecting(first.getNext(), second.getNext(), ( lengthOfFirst - 1 ),
					( lengthOfSecond - 1 ), fromNodeIntersect );
		}
		
		if( first == second && !intersectFlag) {
			intersectFlag = true;
		} else {
			
			if( fromNodeIntersect.isEmpty() && first != second ) {
				fromNodeIntersect.add( first.getNext() );
			}
		}
		
		return intersectFlag;
	}

	private static int getLength( SinglyLinkedListIntVal root ) {
		int returnLength = 0;
		
		while( root != null ) {
			returnLength++;
			root = root.getNext();
		}
		return returnLength;
	}

}
