package elementsOfProgramming.Heaps;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AlmostSortedWithKPositionOut {

	public static void main(String[] args) {
		List< Integer > sequence = new LinkedList<>();
		sequence.add( 3 );
		sequence.add( -1 );
		sequence.add( 2 );
		sequence.add( 6 );
		sequence.add( 4 );
		sequence.add( 5 );
		sequence.add( 8 );
		
		//every elemnt is atmost k position out of its original position
		int k = 2;
		printSorted( sequence, k );
	}

	private static void printSorted(List<Integer> sequence, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		Iterator< Integer > iterator = sequence.iterator();
		
		for( int i = 0; i < k && iterator.hasNext(); i++ ) {
			heap.add( iterator.next() );
		}
		
		while( iterator.hasNext() ) {
			heap.add( iterator.next() );
			System.out.println( heap.remove() );
		}
		
		while( !heap.isEmpty() ) {
			System.out.println( heap.remove() );
		}
	}
}
