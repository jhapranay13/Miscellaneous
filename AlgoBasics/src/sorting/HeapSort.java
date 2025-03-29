package sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] intList = { 98, 34, 55, 67, 78, 88, 24, 21, 8, 1, 6, 9, 9 };
		System.out.println( Arrays.toString(intList) );
		heapSort( intList );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void heapSort(int[] intList) {
		buildHeap( intList );
		System.out.println( "MAX HEAPIFIED >> " + Arrays.toString( intList ) );
		int size = intList.length - 1;
		int lo = 0;
		
		for( int i = size; i >= 0; i-- ) {
			swap( intList, i, lo );
			System.out.println( "BEFORE HIPIFIED >> " + Arrays.toString( intList ) );
			if( (i - 1) >= lo ) {
				heapify( intList, lo, (i - 1) );
				System.out.println( "HIPIFIED >> " + Arrays.toString( intList ) );
			}
		}
	}

	private static void buildHeap(int[] intList) {
		int size = intList.length - 1;
		
		for( int i = ( size - 1 ) / 2; i >=0; i--  ) {
			heapify( intList, i, size );
		}
	}

	private static void heapify(int[] intList, int position, int size) {
		int leftNodePos = 2 * position + 1;
		int rightNodePos = 2 * position + 2;
		int max = position;
		
		if( leftNodePos <= size ) {
			max = intList[ position ] < intList[ leftNodePos ] ? leftNodePos : position;
		}
		
		if( rightNodePos <= size ) {
			max = intList[ max ] < intList[ rightNodePos ] ? rightNodePos : max;
		}
		
		if( max != position ) {
			swap( intList, position, max );
			heapify( intList, max, size );
		}
	}
	
	private static void swap(int[] intList, int j, int i) {
		int temp = intList[ j ];
		intList[ j ] = intList[ i ];
		intList[ i ] = temp;
	}
}
