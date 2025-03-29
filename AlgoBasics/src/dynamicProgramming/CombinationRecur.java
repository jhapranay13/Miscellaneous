package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class CombinationRecur {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8 };
		int k = 3;
		printCombination( arr, new HashSet<Integer>(), k, 0 );
	}

	private static void printCombination( int[] arr, HashSet<Integer> partial, int k,
			int startIndex ) {

		if( k == partial.size() ) {
			System.out.println( Arrays.toString( partial.toArray() ) );
			return;
		}

		if( startIndex == arr.length ) {
			return;
		}

		for( int i = startIndex; i < arr.length; i++ ) {

			if( !partial.contains( arr[ i ] ) ) {
				partial.add( arr[ i ] );
				printCombination( arr, partial, k, i + 1 );
				partial.remove( arr[ i ] );
			}
		}
	}

}
