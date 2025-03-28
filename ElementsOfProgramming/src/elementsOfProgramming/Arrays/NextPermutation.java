package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 1, 5, 4, 3, 0 };
		System.out.println( Arrays.toString( arr ) );
		getNextPermutationNumber( arr );
		System.out.println( Arrays.toString( arr ) );
	}

	private static void getNextPermutationNumber(int[] arr) {
		int pivot = -1;
		
		for( int i = arr.length - 2; i >= 0; i-- ) {
			
			if( arr[ i ] < arr[ i + 1 ] ) {
				pivot = i;
				break;
			}
		}
		int minimumDifferenceIndex = 0;
		int minimumDifference = Integer.MAX_VALUE;
		
		for( int i = pivot + 1; i < arr.length; i++ ) {
			
			if( arr[ i ] > arr[ pivot ] ) {
				minimumDifference = Math.min( minimumDifference , arr[ i ] - arr[ pivot ] );
				minimumDifferenceIndex = i;
			} else {
				break;
			}
		}
		swap( arr, pivot, minimumDifferenceIndex );
		
		for( int i = pivot + 1, j = arr.length - 1; i < j; i++, j-- ) {
			swap( arr, i, j );
		}
	}
	
	private static void swap(int[] arr, int firstIndex, int lastIndex) {
		int temp = arr[ firstIndex ];
		arr[ firstIndex ] = arr[ lastIndex ];
		arr[ lastIndex ] = temp;
	}
}
