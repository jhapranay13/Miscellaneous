package sorting;

import java.util.Arrays;

public class RadixSortUsingBucketSort {

	public static void main(String[] args) {
		int[] arr={245,29,16,1909,3,232,7,5,5};
		int[] sortedArr = new int[ arr.length ];
		System.out.println(Arrays.toString(arr));
		sortedArr = radixSort(arr);
		System.out.println("=====================");
		System.out.println("After Radix Sort : ");
		System.out.println( Arrays.toString( sortedArr ) );
	}

	private static int[] radixSort(int[] arr) {
		int max = findMax( arr );
		int numOfPass = findNoOfPass(max);
		
		for( int i = 0; i < numOfPass; i++ ) {
			int[][] bucket = new int[ 10 ][ 10 ];
			int holder[] = new int[ arr.length ];
			populateHolder( holder, arr, i );
			System.out.println( Arrays.toString(holder) );
			arr = sort( arr, bucket, holder );
		}
		return arr;
	}

	private static int[] sort(int[] arr, int[][] bucket, int[] holder) {
		int[] bucketCounter = new int[ 10 ];
		int[] sortedArray = new int[ arr.length ];
		int size = arr.length;
		
		for( int i = 0; i < size; i++  ) {
			int num = holder[ i ];
			bucket[ num ][ bucketCounter[ num ]++ ] = arr[ i ];
		}
		
		int counter = 0;
		for( int i = 0; i < bucket.length; i++ ) {
			
			for( int j = 0; j < bucket[i].length; j++ ) {
				int num = bucket[i][j];
				
				if( num != 0 ) {
					sortedArray[ counter++ ] = num;
				}
			}
		}
		return sortedArray;
	}

	private static void populateHolder(int[] holder, int[] arr, int pass) {
		int size = arr.length;
		
		for( int i = 0; i < size; i++ ) {
			int num = arr[ i ];
			int dec = 1;
			
			if( pass == 0 ) {
				num = num % 10;
			} else {
				int tempPass = pass;

				while( tempPass >= 1 ) {
					dec *= 10;
					tempPass--;
				}
				num /= dec;
				num %= 10;
			}
			holder[ i ] = num;
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
