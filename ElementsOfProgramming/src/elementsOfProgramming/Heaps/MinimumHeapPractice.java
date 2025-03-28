package elementsOfProgramming.Heaps;

import java.util.Arrays;

public class MinimumHeapPractice {

	public static void main(String[] args) {
		int[] intList = { 88, 34, 5, 67, 7, 98, 24, 21, 8, 1, 6, 9, 99 };
		System.out.println( Arrays.toString(intList) );
		int hi = intList.length - 1;
		int lo = 0;
		sort( intList, lo, hi );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void sort(int[] intList, int lo, int hi) {
		buildMinimumHeap( intList );
		System.out.println( "Min Heap : " + Arrays.toString(intList) );
		
		for( int i = intList.length - 1; i >= 0; i-- ) {
			int temp = intList[ i ];
			intList[ i ] = intList[ 0 ];
			intList[ 0 ] = temp;
			
			if( i >= 0 ) {
				heapify( intList, 0, i - 1 );
			}
		}

	}

	private static void buildMinimumHeap(int[] intList) {
		
		for( int i = ( intList.length - 2 ) / 2; i >= 0; i-- ) {
			heapify( intList, i, intList.length - 1 );
		}
	}

	private static void heapify(int[] intList, int start, int end) {
		int leftNode = 2 * start + 1;
		int rightNode = 2 * start + 2;
		int minIndex = start;
		
		if( leftNode <= end ) {
			minIndex = intList[ minIndex ] > intList[ leftNode ] ? leftNode : minIndex ;
		}
		
		if( rightNode <= end ) {
			minIndex = intList[ minIndex ] > intList[ rightNode ] ? rightNode : minIndex ;
		}
		
		if( minIndex != start ) {
			int temp = intList[ minIndex ];
			intList[ minIndex ] = intList[ start ];
			intList[ start ] = temp;
			heapify( intList, minIndex, end);
		}
	}
}
