package elementsOfProgramming.StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

class MaxAPIStack {
	private Deque< Integer > mainStack = new LinkedList<Integer>();
	private Deque< Integer > auxStack = new LinkedList<Integer>();
	
	public void push( Integer value ) {
		int valueToBePushedInAux = Integer.MIN_VALUE;
		
		if( !auxStack.isEmpty() ) {
			valueToBePushedInAux = Math.max( auxStack.peek() , value);
		} else {
			valueToBePushedInAux = value;
		}
		auxStack.push(valueToBePushedInAux);
		mainStack.push(value);
	}
	
	public Integer pop() {
		
		if( mainStack.isEmpty() ) {
			throw new IllegalStateException( "Stack Empty" );
		}
		auxStack.pop();
		return mainStack.pop();
	}
	
	public Integer currentMaxValue() {
		return auxStack.peek();
	}
}

public class StackWithMaxAPI {

	public static void main(String[] args) {
		MaxAPIStackV2 maxStack = new MaxAPIStackV2();
		maxStack.push(12);
		maxStack.push(2);
		maxStack.push(5);
		maxStack.push(14);
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
