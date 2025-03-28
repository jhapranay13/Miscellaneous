package elementsOfProgramming.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArraysLinearCompare {

	public static void main(String[] args) {
		int[] arrOne = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		int[] arrTwo = { 5, 5, 6, 8, 8, 9, 10, 10};
		List< Integer > result = new ArrayList<>();
		findIntersection( arrOne, arrTwo, result );
		
		System.out.println( Arrays.toString( result.toArray() ) );
	}

	private static void findIntersection(int[] arrOne, int[] arrTwo, List<Integer> result) {
		int counter1 = 0;
		int counter2 = 0;
		
		while( counter1 < arrOne.length && counter2 < arrTwo.length ) {
			
			if( counter1 > arrOne.length - 1 || counter2 > arrTwo.length - 1  ) {
				break;
			}
			
			while( counter1 < arrOne.length - 2 && arrOne[ counter1 ] == arrOne[ counter1 + 1 ] ) {
				counter1++;
			}
			
			if( arrOne[ counter1 ] == arrTwo[ counter2 ] ) {
				result.add( arrOne[ counter1 ] );
				counter1++;

				while( arrTwo[ counter2 ] == arrTwo[ counter2 + 1 ] ) {
					counter2++;
				}
				counter2++;
				continue;
			}
			
			if( arrOne[ counter1 ] < arrTwo[ counter2 ] ) {
				counter1++;
				continue;
			}
			
			if( arrOne[ counter1 ] > arrTwo[ counter2 ] ) {
				
				while( counter2 < arrTwo.length - 2 && arrTwo[ counter2 ] == arrTwo[ counter2 + 1 ] ) {
					counter2++;
				}
				counter2++;
			}
			
			
		}
	}

}
