package sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main( String args[] ) {
		int[] arr = { 9, 16, 17, 29, 1, 3, 5 };
		int[] sortedArray = new int[ arr.length ];
		radixSort( arr, sortedArray );
		System.out.println( Arrays.toString( sortedArray ) );
	}

	private static void radixSort(int[] arr, int[] sortedArray) {
		int[] bucket = new int[ arr.length ];
		int max = findMax( arr );
		int numOfPass = findNumOfPass( max );

		for( int i = 0; i <= numOfPass; i++ ) {
			int[] countFrequency = new int[ 10 ];
			populateBucket( bucket, arr, i ); 
			populateCountFrequency( bucket, countFrequency, i );
			System.out.println( Arrays.toString( bucket ) );
			System.out.println( Arrays.toString( countFrequency ) );
			reconstructSortedNumber( countFrequency, sortedArray, i );
		}
	}

	private static void reconstructSortedNumber(int[] countFrequency, int[] sortedArray, int pass ) {
		int radix = 1;

		for( int j = pass ; j >= 1; j--  ) {
			radix *= 10;
		}
		int counter = 0;
		
		for( int i = 0; i < countFrequency.length; i++ ) {
			int noOfPositions = countFrequency[ i ];
			
			for( int j = 0; j < noOfPositions; j++ ) {
				sortedArray[ counter++ ] += radix*i; 
			}
		}
	}

	private static void populateCountFrequency(int[] bucket, int[] countFrequency, int pass) {

		for( int i = 0; i < bucket.length; i++ ) {
			countFrequency[ bucket[ i ] ]++;
		}
	}

	private static void populateBucket(int[] bucket, int[] arr, int pass) {
		int radix = 10;

		for( int i = 0; i < arr.length; i++  ) {

			for( int j = pass ;j > 1; j--  ) {
				radix *= 10;
			}

			if( pass == 0 ) {
				bucket[ i ] = arr[ i ] % radix ;
			} else {
				int temp = arr[ i ] / radix;
				bucket[ i ] = temp % radix;
			}
		}
	}

	private static int findNumOfPass(int max) {
		int returnVal = 0;
		int temp = max;

		while( true ) {
			temp = temp / 10;

			if( temp == 0 ) {
				break;	
			}
			returnVal++;
		}
		return returnVal;
	}

	private static int findMax(int[] arr) {
		int returnVal = arr[0];

		for( int i = 1; i < arr.length; i++ ) {

			if( arr[i] > returnVal ) {
				returnVal = arr[i];
			}
		}
		return returnVal;
	}
}
