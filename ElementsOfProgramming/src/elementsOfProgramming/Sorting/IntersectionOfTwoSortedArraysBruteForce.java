package elementsOfProgramming.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArraysBruteForce {

	public static void main(String[] args) {
		int[] arrOne = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		int[] arrTwo = { 5, 5, 6, 8, 8, 9, 10, 10};
		List< Integer > result = new ArrayList<>();
		findIntersection( arrOne, arrTwo, result );
		
		System.out.println( Arrays.toString( result.toArray() ) );
	}

	private static void findIntersection(int[] arrOne, int[] arrTwo, List<Integer> result) {
		
		for( int i = 0; i < arrOne.length - 1; i++ ) {
			
			if( !(arrOne[ i ] == arrOne[ i + 1 ] ) ) {
				
				for( int j = 0; j < arrTwo.length; j++ ) {
					
					if( arrOne[ i ] == arrTwo[ j ] ) {
						result.add( arrTwo[ j ] );
						break;
					}
				}
			}
		}
	}

}
