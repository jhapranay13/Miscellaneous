package elementsOfProgramming.StacksAndQueues;

class CircularQueue {
	int[] data;
	int startIndex = 0;
	int nextIndex = -1;
	int numberOfEntries = 0;
	
	public CircularQueue( int size ) {
		super();
		this.data = new int[ size ];
	}
	
	public void enQueue( int value ) {
		
		if( nextIndex < 0 ) {
			nextIndex = 1;
			data[ startIndex ] = value;
			numberOfEntries++;
		} else {
			
			if( nextIndex >= data.length ) {
				nextIndex = 0;
			}
			
			if( nextIndex == startIndex ) {
				int temp[] = new int[ data.length * 2 ];
				
				for( int i = 0; i < numberOfEntries; i++ ) {
					
					if( startIndex > data.length - 1 ) {
						startIndex = 0;
					}
					temp[ i ] = data[ startIndex++ ];
				}
				data = temp;
				startIndex = 0;
				nextIndex = numberOfEntries;
				enQueue( value );
			} else {
				nextIndex %= ( data.length );
				data[ nextIndex++ ] = value;
				numberOfEntries++;
			}
		}
	}
	
	public int deque() {
		int dataToReturn = 0;
		
		if( numberOfEntries <= 0 ) {
			dataToReturn = -1;
		}
		else {
			dataToReturn =  data[ startIndex++ ];
			numberOfEntries--;
			startIndex %= data.length;
		}
		return dataToReturn;
	}
}

public class CicularQueueExp {

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(2);
		queue.enQueue( 1 );
		queue.enQueue( 2 );
		queue.enQueue( 3 );
		System.out.println( queue.deque() );
	}
}
