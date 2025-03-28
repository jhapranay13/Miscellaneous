package elementsOfProgramming.Recursion;

import java.util.Arrays;

public class GeneratePermutation {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 7 };
		permutation( arr, 0, arr.length - 1 );
	}

	private static void permutation(int[] arr, int startIndex, int endIndex ) {
		
		if( startIndex == endIndex ) {
			System.out.println( Arrays.toString( arr ) );
			return;
		}
		//Since To fix a variable at a particulat position in case of In Place we require two Swaps
		// In Case Of string where we get a new object everytime we dont require two swaps.
		// In case of duplicates don't swap if two elemts are duplicated.
		for( int i = startIndex; i <= endIndex; i++ ) {
			swap( arr, startIndex, i );
			permutation(arr, startIndex + 1, endIndex);
			swap(arr, startIndex, i);
		}
	}

	private static void swap(int[] arr, int fromIndex, int toIndex) {
		int temp = arr[ fromIndex ];
		arr[ fromIndex ] = arr[ toIndex ];
		arr[ toIndex ] = temp;
	}
}
