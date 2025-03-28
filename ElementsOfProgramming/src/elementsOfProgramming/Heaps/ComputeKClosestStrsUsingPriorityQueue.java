package elementsOfProgramming.Heaps;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ComputeKClosestStrsUsingPriorityQueue {

	public static void main(String[] args) {
		List< Integer > distance = new LinkedList<>();
		distance.add( 45 );
		distance.add( 55 );
		distance.add( 32 );
		distance.add( 12 );
		distance.add( 65 );
		distance.add( 31 );
		distance.add( 27 );
		distance.add( 17 );
		distance.add( 11 );
		distance.add( 3 );	
		int k = 4;

		printClosestStars( distance, k );
	}

	private static void printClosestStars(List<Integer> distance, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>( new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		int index = 0;
		
		for( ; index < distance.size() && k <= distance.size() && 
				index < k; index++ ) {
			heap.add( distance.get(index) );
		}
		
		for( ; index < distance.size(); index++ ) {
			heap.add( distance.get( index ) );
			heap.poll();
		}
		
		while( !heap.isEmpty() ) {
			System.out.print( heap.poll() + " " );
		}
	}
}
