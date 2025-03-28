package elementsOfProgramming.StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

class MaxAPIStackV2 {
	private Deque< Integer > mainStack = new LinkedList<Integer>();
	private Deque< int[] > auxStack = new LinkedList<int[]>();
	
	public void push( Integer value ) {
		int[] tempVal = null;
		
		if( !auxStack.isEmpty() ) {
			tempVal = auxStack.peek();
			
			if( tempVal[ 0 ] == value ) {
				tempVal[ 1 ]++;
			} else if( tempVal[ 0 ] < value ){
				tempVal = new int[ 2 ];
				tempVal[ 0 ] = value;
				tempVal[ 1 ] = 1;
				auxStack.push(tempVal);
			}
		} else {
			tempVal = new int[ 2 ];
			tempVal[ 0 ] = value;
			tempVal[ 1 ] = 1;
			auxStack.push( tempVal );
		}
		mainStack.push(value);
	}
	
	public Integer pop() {
		
		if( mainStack.isEmpty() ) {
			throw new IllegalStateException( "Stack Empty" );
		}
		int[] tempVal = auxStack.peek();
		
		if( tempVal[ 0 ] == mainStack.peek() ) {
			tempVal[ 1 ]--;
		}
		
		if( tempVal[ 1 ] == 0 ) {
			auxStack.pop();
		}
		return mainStack.pop();
	}
	
	public Integer currentMaxValue() {
		return auxStack.peek()[ 0 ];
	}
}

public class StackWithMaxAPIV2 {

	public static void main(String[] args) {
		MaxAPIStack maxStack = new MaxAPIStack();
		maxStack.push(12);
		maxStack.push(2);
		maxStack.push(2);
		maxStack.push(12);
		maxStack.push(8);
		maxStack.push(11);
		
		System.out.println( maxStack.currentMaxValue() );
		maxStack.pop();
		maxStack.pop();
		System.out.println( maxStack.currentMaxValue() );
		maxStack.pop();
		maxStack.pop();
		System.out.println( maxStack.currentMaxValue() );
	}
}	
