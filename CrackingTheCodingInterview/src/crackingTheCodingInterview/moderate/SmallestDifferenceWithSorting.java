package crackingTheCodingInterview.moderate;

import java.util.Arrays;

public class SmallestDifferenceWithSorting {

	public static void main(String[] args) {
		int [] firstArr = { 1, 3, 15, 11, 2 };
		int [] secondArr = {23, 127, 235, 19, 8};
		int [] result = new int[2];
		int minimum = getMinimumDifference( firstArr, secondArr, result );
		System.out.println( minimum + " for values " + result[ 0 ] + ", " + result[ 1 ]  );
	}

	private static int getMinimumDifference(int[] firstArr, int[] secondArr, int[] result) {
		int minimum = Integer.MAX_VALUE;
		heapSort( firstArr );
		heapSort( secondArr );
		System.out.println( Arrays.toString( firstArr ) );
		System.out.println( Arrays.toString( secondArr ) );
		int firstArrCounter = 0;
		int secondArrCounter = 0;
		
		while( firstArrCounter < firstArr.length && secondArrCounter < secondArr.length ) {
			
			if( Math.abs( firstArr[ firstArrCounter ] - secondArr[ secondArrCounter ] ) < minimum ) {
				minimum = Math.abs( firstArr[ firstArrCounter ] - secondArr[ secondArrCounter ] );
				result[0] = firstArr[ firstArrCounter ];
				result[1] = secondArr[ secondArrCounter ];
			}
			
			if( firstArr[ firstArrCounter ] < secondArr[ secondArrCounter ] ) {
				firstArrCounter++;
			} else {
				secondArrCounter++;
			}
		}
		
		return minimum;
	}
	
	public static void heapSort( int[] arr ) {
		buildHeap( arr );
		int size = arr.length - 1;
		int lo = 0;
		
		for( int i = size; i >= 0; i-- ) {
			swap( arr, i, lo );
			if( (i - 1) >= lo ) {
				heapify( arr, lo, (i - 1) );
			}
		}
	}

	private static void buildHeap(int[] arr) {
		
		for( int i = ( arr.length - 1 ) /2 ; i >= 0; i-- ) {
			heapify( arr, i, arr.length - 1 );
		}
	}

	private static void heapify(int[] arr, int pos, int maxIndex) {
		int leftPos = 2 * pos + 1;
		int rightPos = 2 * pos + 2;
		int max = pos;
		
		if( leftPos <= maxIndex ) {
			max = arr[ pos ] < arr[ leftPos ] ? leftPos : pos;
		}
		
		if( rightPos <= maxIndex ) {
			max = arr[ max ] < arr[ rightPos ] ? rightPos : max;
		}
		
		if( max != pos ) {
			swap( arr, pos, max );
			heapify( arr, max, maxIndex );
		}
	}

	private static void swap(int[] arr, int pos, int min) {
		int temp = arr[ pos ];
		arr[ pos ] = arr[ min ];
		arr[ min ] = temp;
	}
}
