package elementsOfProgramming.Sorting;

class Event {
	int time;
	boolean startFlag;
	
	public Event(int time, boolean startFlag) {
		super();
		this.time = time;
		this.startFlag = startFlag;
	}
	
}

public class MaximumNumberOfEventsTakingPlaceConcurrently {

	public static void main(String[] args) {
		int[][] timeLine = {
				{ 1, 5 },
				{ 6, 10 },
				{ 11, 13 },
				{ 14, 16 },
				{ 2, 7 },
				{ 8, 9 },
				{ 12, 15 },
				{ 4, 5 },
				{ 12, 15 },
				{ 9, 17 }
		};
		printArray( timeLine );
		int maximumEventsHappeningSimultaneously = getMaximumEvents( timeLine );
		System.out.println( maximumEventsHappeningSimultaneously );
	}

	private static void printArray(int[][] arr) {
		
		for( int i = 0; i < arr.length; i++ ) {
			System.out.println( arr[ i ][ 0 ] + ", " + arr[ i ][ 1 ] );
		}
		System.out.println( "==========================" );
	}

	private static int getMaximumEvents(int[][] timeLine) {
		int maximumEvents = 0;
		Event[] events = new Event[ timeLine.length * 2 ];
		createEvent( timeLine, events );
		sort( events );
		int runningCounter = 0;
		
		for( int i = 0; i < events.length; i++ ) {
			Event temp = events[ i ];
			
			if( temp.startFlag ) {
				runningCounter++;
				maximumEvents = Math.max(runningCounter, maximumEvents);
			} else {
				runningCounter--;
			}
		}
		return maximumEvents;
	}

	private static void createEvent(int[][] timeLine, Event[] events) {
		int counter = 0;
		
		for( int i = 0; i < timeLine.length; i++ ) {
			events[ counter++ ] = new Event( timeLine[ i ][ 0 ], true );
			events[ counter++ ] = new Event( timeLine[ i ][ 1 ], false );
		}
	}

	private static void sort(Event[] events) {
		int lo = 0;
		int hi = events.length - 1;
		mergeSort( events, lo, hi );
	}

	private static void mergeSort(Event[] events, int lo, int hi) {
		
		if( lo < hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			mergeSort(events, lo, pivot);
			mergeSort(events, pivot + 1, hi);
			merge( events, lo, pivot, hi );
		}
	}

	private static void merge(Event[] events, int lo, int pivot, int hi) {
		Event[] helper = new Event[ events.length ];
		int startIndex = lo;
		int start1 = lo;
		int start2 = pivot + 1;
		
		while( start1 <= pivot &&  start2 <= hi ) {
			
			if( events[ start1 ].time < events[ start2 ].time ) {
				helper[ startIndex++ ] = events[ start1++ ];
			}
			
			if( events[ start1 ].time >= events[ start2 ].time ) {
				helper[ startIndex++ ] = events[ start2++ ];
			}
		}
		
		while( start1 <= pivot ) { 
			helper[ startIndex++ ] = events[ start1++ ];
		}
		
		while( start2 <= hi ) {
			helper[ startIndex++ ] = events[ start2++ ];
		}
		
		for( int i = 0; i < helper.length; i++ ) {
			
			if( !( helper[ i ] == null )  ) {
				events[ i ] = helper[ i ];
			}
		}
	}
}
