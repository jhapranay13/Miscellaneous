package elementsOfProgramming.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestEntriesIn3Arrays {

	public static void main(String[] args) {
		int arr1[] = { 5, 10, 15 };
		int arr2[] = { 3, 6, 9, 12, 15 };
		int arr3[] = { 8, 16, 24 };
		
		ArrayList< Integer > result = new ArrayList<Integer>();
		closestEntries( arr1, arr2, arr3, result );
		System.out.println( Arrays.toString( result.toArray() ) );
	}

	private static void closestEntries(int[] arr1, int[] arr2, int[] arr3, 
			ArrayList<Integer> result) {
		Integer pointer1 = 0, 
				pointer2 = 0, 
				pointer3 = 0;
		int interval = Integer.MAX_VALUE;
		
		while( pointer1 < arr1.length && pointer2 < arr2.length && 
				pointer3 < arr3.length ) {
			int range = Math.max( Math.abs( arr1[ pointer1 ] - arr2[ pointer2 ] ), 
					Math.abs( arr3[ pointer3 ] - arr2[ pointer2 ] ) );
			
			if( range <= interval ) {
				result.clear();
				result.add( arr1[ pointer1 ] );
				result.add( arr2[ pointer2 ] );
				result.add( arr3[ pointer3 ] );
				interval = range;
			}
			
			if( arr1[ pointer1 ] < arr2[ pointer2 ] ) {
				
				if( arr1[ pointer1 ] < arr3[ pointer3 ] ) {
					pointer1++;
				} else {
					pointer3++;
				}
			} else {
				
				if( arr2[ pointer2 ] < arr3[ pointer3 ] ) {
					pointer2++;
				} else {
					pointer3++;
				}
			}
		}
	}
}
