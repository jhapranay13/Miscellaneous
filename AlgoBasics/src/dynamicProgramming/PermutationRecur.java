package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationRecur {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		boolean []used = new boolean[ arr.length ];
		printPermuteRecur( arr, used, new ArrayList< Integer >() );
	}

	private static void printPermuteRecur( int[] arr, boolean[] used, 
			ArrayList<Integer> partial ) {

		if( partial.size() == arr.length ) {
			System.out.println( Arrays.toString( partial.toArray() ) );
			return;
		}
		
		for( int i = 0; i < arr.length; i++ ) {
			
			if( !used[ i ] ) {
				used[ i ] = true;
				partial.add( arr[ i ] );
				printPermuteRecur(arr, used, partial);
				partial.remove( partial.size() - 1 );
				used[ i ] = false;
			}
		}
	}
}
