package crackingTheCodingInterview.LinkedLists;

class StackPalindrome {
	SinglyLinkedListIntVal root;

	public StackPalindrome() {
		super();
		this.root = new SinglyLinkedListIntVal();
		this.root.setValue( Integer.MIN_VALUE );
	}

	public void push( SinglyLinkedListIntVal node ) {
		SinglyLinkedListIntVal temp = new SinglyLinkedListIntVal();

		temp.setValue( node.getValue() );
		temp.setNext( root.getNext() );
		root.setNext( temp );
	}
	
	public SinglyLinkedListIntVal pop() {
		SinglyLinkedListIntVal temp = root.getNext();
		
		if( temp != null ) {
			root.setNext( temp.getNext() );
		}	
		return temp;
	}
}

public class PalindromeListUsingStack {

	public static void main(String[] args) {
		SinglyLinkedListIntVal first = new SinglyLinkedListIntVal();
		first.setValue( 1 );
		SinglyLinkedListIntVal second = new SinglyLinkedListIntVal();
		second.setValue( 4 );
		SinglyLinkedListIntVal third = new SinglyLinkedListIntVal();
		third.setValue( 5 );
		SinglyLinkedListIntVal fourth = new SinglyLinkedListIntVal();
		fourth.setValue( 5 );
		SinglyLinkedListIntVal fifth = new SinglyLinkedListIntVal();
		fifth.setValue( 4 );
		SinglyLinkedListIntVal sixth = new SinglyLinkedListIntVal();
		sixth.setValue( 7 );
		
		first.setNext( second );
		second.setNext( third );
		//third.setNext( fifth );
		third.setNext( fourth );
		fourth.setNext( fifth );
		fifth.setNext( sixth );
		printLinkedList(first);
		System.out.println();
		boolean palindromeFlag = isPalindrome( first );
		System.out.println( palindromeFlag );
	}

	private static void printLinkedList(SinglyLinkedListIntVal first) {
		SinglyLinkedListIntVal currentNode = first;
		int counter = 0;

		while( currentNode != null ) {

			if( counter > 0 ) {
				System.out.print(  ",  " );
			}
			System.out.print( currentNode.getValue() );
			currentNode = currentNode.getNext();
			counter++;
		}
	}
	
	private static boolean isPalindrome(SinglyLinkedListIntVal first) {
		StackPalindrome stack = new StackPalindrome();
		SinglyLinkedListIntVal slowRunner = first;
		SinglyLinkedListIntVal fastRunner = first;
		int midCounter = populateStack( slowRunner, fastRunner, stack );
		
		SinglyLinkedListIntVal origTemp = first;
		
		for( int i = 0; i <= midCounter; i++ ) {
			SinglyLinkedListIntVal stackTemp = stack.pop();
			
			if( stackTemp == null ) {
				
				if( i == midCounter ) {
					return true;
				} else {
					return false;
				}
			}
			
			if( origTemp.getValue() != stackTemp.getValue() ) {
				return false;
			}
			origTemp = origTemp.getNext();
		}
		
		return true;
	}

	private static int populateStack(SinglyLinkedListIntVal slowRunner, SinglyLinkedListIntVal fastRunner,
			StackPalindrome stack) {
		int midCounter = 0;
		
		while( fastRunner != null ) {
			fastRunner = fastRunner.getNext();
			
			if( fastRunner != null ) {
				fastRunner = fastRunner.getNext();
			}
			slowRunner = slowRunner.getNext();
			midCounter++;
		}
		
		while( slowRunner != null ) {
			stack.push( slowRunner );
			slowRunner = slowRunner.getNext();
		}
		return midCounter - 1;
	}
}
