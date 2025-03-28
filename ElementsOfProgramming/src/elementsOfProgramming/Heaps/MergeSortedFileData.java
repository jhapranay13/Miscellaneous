package elementsOfProgramming.Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Can be used to solve following too.
 * 
 * SORT AN INCREASING-DECREASING ARRAY
An array is said to be fc-increasing-decreasing if elements repeatedly increase up to a
certain index after which they decrease, then again increase, a total of k times. This is
illustrated in Figure

57 131 493 294 221 339 418 452 442 190
 * 
 * 
 * 
 */
public class MergeSortedFileData {

	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList<>();
		list1.add( 3 );
		list1.add( 5 );
		list1.add( 7 );
		
		List<Integer> list2 = new LinkedList<>();
		list2.add( 6 );
		list2.add( 9 );
		
		List<Integer> list3 = new LinkedList<>();
		list3.add( 0 );
		list3.add( 1 );
		list3.add( 4 );
		
		List< List< Integer > > collection = new LinkedList<>();
		collection.add(list1);
		collection.add(list2);
		collection.add(list3);
		List< Integer > result = new ArrayList<>();
		mergeSorted( collection, result );
		
		for( Integer num : result )
			System.out.println( num );
	}

	private static void mergeSorted(List<List<Integer>> collection, List<Integer> result) {
		List< Iterator<Integer> > iterators = new LinkedList<>();
		
		for( int i = 0; i < collection.size(); i++ ) {
			iterators.add(  collection.get( i ).iterator() );
		}
		
		PriorityQueue< Integer > heap = new PriorityQueue<>( new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		} );
		boolean processFlag = false;
		
		for( int i = 0; i < iterators.size(); i++ ) {
			Iterator< Integer > iter = iterators.get( i );
			
			if( iter.hasNext() ) {
				heap.add( iter.next() );
				processFlag = true;
			}
			
			if( i == iterators.size() - 1 && processFlag ) {
				i = 0;
				processFlag = false;
			}
		}
		
		while( !heap.isEmpty() ) {
			result.add( heap.poll() );
		}
	}
}
