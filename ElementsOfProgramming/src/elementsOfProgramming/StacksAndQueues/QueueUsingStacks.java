package elementsOfProgramming.StacksAndQueues;

import java.util.Stack;

class QueueUsingStack {
	Stack< Integer > enqueStack = new Stack<Integer>();
	Stack< Integer > dequeStack = new Stack<Integer>();
	
	public void enque( int value ) {
		enqueStack.push( value );
	}
	
	public int dequeue() {
		int returnValue = -1;
		
		if( dequeStack.isEmpty() ) {
			
			while( !enqueStack.isEmpty() ) {
				dequeStack.push( enqueStack.pop() );
			}
		}
		returnValue = dequeStack.pop();
		return returnValue;
	}
}

public class QueueUsingStacks {

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.enque( 1 );
		queue.enque( 2 );
		queue.enque( 3 );
		System.out.println( queue.dequeue() );
	}

}
