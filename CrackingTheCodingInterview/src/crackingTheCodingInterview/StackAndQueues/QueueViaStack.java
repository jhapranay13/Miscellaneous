package crackingTheCodingInterview.StackAndQueues;

class StackQ {
	private int[] value;
	private int currentIndex = -1;

	public StackQ( int size ) {
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

class StackQueue {
	private StackQ firstStack;
	private StackQ secondStack;
	private int size;
	
	public StackQueue( int size ) {
		super();
		this.firstStack = new StackQ( size );
		this.secondStack = new StackQ( size );
		this.size = size;
	}
	
	public void enQueue( int val ) {
		
		if( firstStack.getCurrentIndex() < size - 1 ) {
			firstStack.push(val);
		}
	}
	
	public int deQueue() {
		int returnVal = Integer.MIN_VALUE;
		
		if( secondStack.getCurrentIndex() == -1 ) {
			
			for( int i = firstStack.getCurrentIndex(); i >= 0; i-- ) {
				secondStack.push( firstStack.pop() );
			}
		}
		returnVal = secondStack.pop();
		return returnVal;
	}
}

public class QueueViaStack {

	public static void main(String[] args) {
		StackQueue queue = new StackQueue( 5 );
		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println( queue.deQueue() );
		queue.enQueue(5);
		System.out.println( queue.deQueue() );
		queue.enQueue(6);
		System.out.println( queue.deQueue() );
		queue.enQueue(7);
		
		System.out.println( queue.deQueue() );
		System.out.println( queue.deQueue() );
	}
}
