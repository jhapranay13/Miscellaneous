package sorting;

import java.util.Arrays;

public class RadixSortUsingCountingSort {

	public static void main(String[] args) {
		int[] arr={245,29,16,1909,1,3,3,5};
		int[] sortedArr = new int[ arr.length ];
		System.out.println(Arrays.toString(arr));
		sortedArr = radixSort(arr);
		System.out.println("=====================");
		System.out.println("After Radix Sort : ");
		System.out.println( Arrays.toString( sortedArr ) );
	}

	private static int[] radixSort(int[] arr) {
		int max = findMax( arr );
		System.out.println( "MAX >> " + max );
		int numOfPass = findNoOfPass( max );
		System.out.println( "Number Of Passes" + numOfPass );
		int size = arr.length;
		
		for( int i = 0; i < numOfPass; i++ ) {
			int[] bucket = new int[ size ];
			populateBucket( arr, bucket, size, i );
			System.out.println( " BUCKET >> " + Arrays.toString( bucket ) );
			int[] countFrequency = new int[ 10 ];
			populateCountFrequency( countFrequency, bucket, size );
			arr = sort( arr, bucket, countFrequency );
			System.out.println( "SORTED ARRAY >> " + Arrays.toString( arr ) );
		}
		return arr;
	}

	private static int[] sort(int[] arr, int[] bucket, int[] countFrequency) {
		int size = arr.length;
		int[] tempHolder = new int[ size ]; 
		
		for( int i = 0; i < size; i++ ) {
			int var = bucket[ i ] ;
			int pos = countFrequency[ var ]++;
			tempHolder[ pos ] = arr[ i ];
		}
		return tempHolder;
		
	}

	private static void populateCountFrequency(int[] countFrequency, int[] bucket, int size) {
		
		for( int i = 0; i < size; i++ ) {
			int temp = bucket[ i ];
			countFrequency[ temp ]++;
		}
		System.out.println( "After counting Freqency >> " + Arrays.toString( countFrequency ) );
		//adding
		for( int i = 1; i < 10; i++ ) {
			countFrequency[ i ] += countFrequency[ i - 1 ];
		}
		System.out.println( "After Adding counting Freqency >> " + Arrays.toString( countFrequency ) );
		//shifting
		for( int i = 9; i > 0; i-- ) {
			countFrequency[ i ] = countFrequency[ i - 1 ];
			
			if( i == 1 ) {
				countFrequency[ 0 ] = 0;
			}
		}
		System.out.println( "After shifting counting Freqency >> " + Arrays.toString( countFrequency ) );
	}

	private static void populateBucket(int[] arr, int[] bucket, int size2, int pass) {

		for( int i = 0; i < arr.length; i++ ) {
			int dec = 1;
			int num = arr[ i ];
			
			if( pass == 0 ) {
				num %= 10;
			} else {
				int tempPass = pass;
				
				while( tempPass > 0 ) {
					dec *= 10;
					tempPass--;
				}
				num /= dec;
				num %= 10;
			}
			bucket[ i ] = num;
		}
	}

	private static int findNoOfPass(int max) {
		int returnVal = 0;
		
		while ( max > 0 ) {
			max = max / 10;
			returnVal++;
		}
		return returnVal;
	}

	private static int findMax(int[] arr) {
		int returnVal = arr[ 0 ];
		int size = arr.length;
		
		for( int i = 1; i < size; i++ ) {
			
			if( arr[ i ] > returnVal ) {
				returnVal = arr[ i ];
			}
		}
		return returnVal;
	}
}
