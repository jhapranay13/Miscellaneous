package elementsOfProgramming.DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NonDEcreasingSequence {

	public static void main(String[] args) {
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		int result = calculateLengthOfSubSequenceDP( arr );
		System.out.println( result );

		result = calculateLengthOfSubSequenceRecursion( arr, 1, 0 );
		System.out.println( result );
	}

	private static int calculateLengthOfSubSequenceRecursion(int[] arr, int length, int index) {

		if( index >= arr.length ) {
			return length;
		}
		int includeValue = 0;

		if( index < arr.length - 1 && arr[ index ] < arr[ index + 1 ] ) {
			includeValue = calculateLengthOfSubSequenceRecursion(arr, length + 1, index + 1 );
		}
		int excludeValue = 0;
		excludeValue = calculateLengthOfSubSequenceRecursion( arr, length, index + 1 );
		return Math.max( includeValue , excludeValue);
	}

	private static int calculateLengthOfSubSequenceDP(int[] arr) {
		int[] memo = new int[ arr.length ];
		Arrays.fill(memo, 1);

		for( int i = 1; i < arr.length; i++ ) {

			for( int j = 0; j < i; j++ ) {

				if( arr[ i ] >= arr[ j ] ) {
					memo[ i ] = Math.max( memo[ i ] , memo[ j ] + 1 ); 
				}
			}
		}
		//normally find the maximum in the array
		return memo[ memo.length - 1 ];
	}

}
