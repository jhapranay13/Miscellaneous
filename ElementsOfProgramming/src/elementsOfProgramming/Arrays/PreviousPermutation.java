package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class PreviousPermutation {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 3, 0, 1, 4, 5 }; 
		System.out.println( Arrays.toString( arr ) );
		getPreviousPermutation( arr );
		System.out.println( Arrays.toString( arr ) );
	}

	private static void getPreviousPermutation(int[] arr) {
		int pivot = -1;
		
		for( int i = arr.length - 2; i >= 0; i-- ) {
			
			if( arr[ i ] > arr[ i + 1 ] ) {
				pivot = i;
				break;
			}
		}
		int justLessThanIndex = pivot;
		
		for( int i = justLessThanIndex + 1; i < arr.length; i++ ) {
			
			if( arr[ i ] > arr[ pivot ] ) {
				justLessThanIndex = i - 1 ;
				break;
			}
		}
		swap( arr, justLessThanIndex, pivot );
		
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
