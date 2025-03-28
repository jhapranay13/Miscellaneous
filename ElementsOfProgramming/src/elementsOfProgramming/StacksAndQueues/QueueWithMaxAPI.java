package elementsOfProgramming.StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

class QueueWithMax {
	Deque< Integer > mainQueue = new LinkedList<Integer>();
	Deque< Integer > maxQueue = new LinkedList<Integer>();
	
	public void enQueue( int value ) {
		
		if( mainQueue.isEmpty() ) {
			mainQueue.add( value );
			maxQueue.add( value );
		} else {
			
			if( value >= maxQueue.getLast() ) {
				mainQueue.add( value );
				maxQueue.add( value );
			} else {
				mainQueue.add( value );
			}
		}
	}
	
	public int deQueue(  ) {
		int returnValue = -1;
		
		if( mainQueue.isEmpty() ) {
			returnValue = -1;
		} else {
			
			if( !maxQueue.isEmpty() &&  mainQueue.getFirst() == maxQueue.getFirst() ) {
				maxQueue.removeFirst();
			}
			returnValue = mainQueue.removeFirst();
		}
		return returnValue;
	}
}

public class QueueWithMaxAPI {

	public static void main(String[] args) {
		QueueWithMax que = new QueueWithMax();
		que.enQueue(2);
		que.enQueue(7);
		que.enQueue(8);
		que.enQueue(1);
		que.enQueue(3);
		System.out.println( que.deQueue() );
		System.out.println( que.deQueue() );
		System.out.println( que.deQueue() );
		System.out.println( que.deQueue() );
		System.out.println( que.deQueue() );
		System.out.println( que.deQueue() );
	}
}
