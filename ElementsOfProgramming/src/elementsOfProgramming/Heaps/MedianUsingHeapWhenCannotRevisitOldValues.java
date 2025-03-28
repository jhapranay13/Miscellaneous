package elementsOfProgramming.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianUsingHeapWhenCannotRevisitOldValues {

	public static void main(String[] args) {
		int[] sequence = { 1, 0, 3, 5, 2, 0, 1 };
		int median = getMedian( sequence );
		System.out.println( median );
	}

	private static int getMedian(int[] sequence) {
		PriorityQueue< Integer > maxHeapForMinNumber = new PriorityQueue<>( 
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o2, o1);
					}
		} );
		PriorityQueue< Integer > minHeapForMaxNumber = new PriorityQueue<>();
		
		for( int i = 0; i < sequence.length; i++ ) {
			int number = sequence[ i ];
			
			if( minHeapForMaxNumber.isEmpty() ) {
				minHeapForMaxNumber.add( number );
			} else {
				
				if( minHeapForMaxNumber.peek() > number ) {
					minHeapForMaxNumber.add( number );
				} else {
					maxHeapForMinNumber.add( number );
				}
			}
			
			if( maxHeapForMinNumber.size() + 1 < minHeapForMaxNumber.size() ) {
				maxHeapForMinNumber.add( minHeapForMaxNumber.poll() );
			} 
			
			if( maxHeapForMinNumber.size() > minHeapForMaxNumber.size() ) {
				minHeapForMaxNumber.add( maxHeapForMinNumber.poll() );
			}
		}
		return maxHeapForMinNumber.size() == minHeapForMaxNumber.size() ? 
				( maxHeapForMinNumber.peek() + minHeapForMaxNumber.peek() ) / 2 :
					maxHeapForMinNumber.peek();
	}

}
