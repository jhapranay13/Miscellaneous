package crackingTheCodingInterview.StackAndQueues;

class StackSrt {
	private int[] value;
	private int currentIndex = -1;

	public StackSrt( int size ) {
		super();
		this.value = new int[ size ];
	}
	
	public void push( int val ) {
		
		if( value.length - 1 != currentIndex ) {
			value[ ++currentIndex ] = val;
		}
	}
	
	public int pop() {
		int returnVal = Integer.MIN_VALUE;
		
		if( currentIndex >= 0 ) {
			returnVal = value[ currentIndex ];
			value[ currentIndex-- ] = Integer.MIN_VALUE;
		}	
		return returnVal;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
}

public class SortStack {

	public static void main(String[] args) {
		StackSrt stack = new StackSrt( 5 );
		stack.push(2);
		stack.push(1);
		stack.push(4);
		stack.push(5);
		stack.push(3);
		
		sortStack( stack );
		
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
	}

	private static void sortStack(StackSrt stack) {
		StackSrt tempStack = new StackSrt( stack.getCurrentIndex() + 1 );
		int tempIndex = tempStack.getCurrentIndex();
		int counter = 0;
		
		while( stack.getCurrentIndex() != -1 ) {
			
			if( tempIndex == -1 ) {
				tempStack.push( stack.pop() );
				tempIndex = tempStack.getCurrentIndex();
				continue;
			}
			int stackVal = stack.pop();
			
			do {
				int tempVal = tempStack.pop();
				
				if( tempVal > stackVal ) {
					stack.push( tempVal );
					counter++;
				} else if( tempVal < stackVal && tempVal != Integer.MIN_VALUE ) {
					tempStack.push( tempVal );
					tempStack.push( stackVal );
					break;
				} else if( tempVal == Integer.MIN_VALUE ) {
					tempStack.push( stackVal );
					break;
				}
			} while( counter != 0 );
			
			while( counter != 0 ) {
				tempStack.push( stack.pop() );
				counter--;
			}
		}	
		
		while( tempStack.getCurrentIndex() != -1 ) {
			stack.push( tempStack.pop() );
		}
	}
}
