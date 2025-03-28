package crackingTheCodingInterview.StackAndQueues;

import java.util.Arrays;

class StackWithMinimum {
	int[] value;
	int[] minimum;
	int sizeOfStack = 0;
	int sizeOfMinimum = 0;
	
	public StackWithMinimum( int size ) {
		super();
		this.value = new int[ size ];
		this.minimum = new int[ size ];
		
		for( int i = 0; i < minimum.length; i++ ) {
			minimum[ i ] = Integer.MAX_VALUE;
		}
	}
	
	public void push( int val ) {
		
		value[ sizeOfStack++ ] = val;
		int tempSize = sizeOfMinimum - 1 >= 0 ? sizeOfMinimum - 1 : 0;
		
		if( val < minimum[ tempSize ] ) {
			minimum[ sizeOfMinimum ] = val;
			sizeOfMinimum++;
		}
		System.out.println( Arrays.toString( minimum ) );
		System.out.println( Arrays.toString( value ) );
	}
	
	public int pop() {
		int returnVal = 0;
		returnVal = value[ --sizeOfStack ];
		
		if( returnVal == minimum[ sizeOfMinimum - 1 ] ) {
			sizeOfMinimum--;
		}
		return returnVal;
	}
}
public class StackWithMinimumUsingAnotherStack {

	public static void main(String[] args) {
		StackWithMinimum stack = new StackWithMinimum( 4 );
		stack.push( 23 );
		stack.push( 32 );
		stack.push( 29 );
		stack.push( 13 );
		
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
	}

}
