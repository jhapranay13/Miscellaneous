package elementsOfProgramming.Heaps;

import java.util.Arrays;

public class MaximumHeapPractise {

	public static void main(String[] args) {
		int[] intList = { 88, 34, 55, 67, 78, 98, 24, 21, 8, 1, 6, 9, 9 };
		System.out.println( Arrays.toString(intList) );
		int hi = intList.length - 1;
		int lo = 0;
		sort( intList, lo, hi );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void sort(int[] intList, int lo, int hi) {
		buildMaxHeap( intList );
		System.out.println( "MAX HEAP >> " + Arrays.toString( intList ) );
		
		for( int i = intList.length - 1; i >= 0; i--  ) {
			int temp = intList[ i ];
			intList[ i ] = intList[ 0 ];
			intList[ 0 ] = temp;
			
			if( i - 1 >= 0 ) {
				heapify(intList, 0, i - 1 );
			}	
			System.out.println( "MAX HEAP Again >> " + Arrays.toString( intList ) );
		}
	}

	private static void buildMaxHeap(int[] intList) {
		
		for( int i = (intList.length - 1) / 2; i >= 0; i-- ) {
			heapify( intList, i, intList.length - 1 );
		}
	}

	private static void heapify(int[] intList, int start, int end) {
		int leftNodeIndex = 2 * start + 1;
		int rightNodeIndex = 2 * start + 2;
		int maxIndex = start;
		
		if( leftNodeIndex <= end ) {
			maxIndex = intList[ start ] < intList[ leftNodeIndex ] ? leftNodeIndex : start;
		}
		
		if( rightNodeIndex <= end ) {
			maxIndex = intList[ maxIndex ] < intList[ rightNodeIndex ] ? rightNodeIndex : maxIndex;
		}
		
		if( maxIndex != start ) {
			int temp = intList[ maxIndex ];
			intList[ maxIndex ] = intList[ start ];
			intList[ start ] = temp;
			heapify( intList, maxIndex, end );
		}
	}

}
