package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetSumRecur {

	public static void main(String[] args) {
		int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		Arrays.sort( arr );
		printTargetCombination( arr, target, 0, 0, new ArrayList< Integer >() );
	}

	private static void printTargetCombination(int[] arr, int target, 
			int start, int partialSum, ArrayList<Integer> partial) {
		
		if( target == partialSum ) {
			System.out.println( Arrays.toString( partial.toArray() ) );
		}
		
		if( start >= arr.length ) {
			return;
		}
		
		for( int i = start; i < arr.length; i++ ) {
			
			if( arr[ i ] + partialSum > target || ( i > start &&
					arr[ i ] == arr[ i - 1 ] ) ) {
				continue;
			}
			partialSum += arr[ i ];
			partial.add( arr[ i ] );
			printTargetCombination(arr, target, start + 1, partialSum, partial);
			partial.remove( partial.size() - 1 );
			partialSum -= arr[ i ];
		}
	}
}
