package elementsOfProgramming.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArraysBinarySearch {

	public static void main(String[] args) {
		int[] arrOne = { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 };
		int[] arrTwo = { 5, 5, 6, 8, 8, 9, 10, 10};
		List< Integer > result = new ArrayList<>();
		findIntersection( arrOne, arrTwo, result );
		
		System.out.println( Arrays.toString( result.toArray() ) );
	}

	private static void findIntersection(int[] arrOne, int[] arrTwo, List<Integer> result) {
		int[] smallerArr = arrOne.length < arrTwo.length ? arrOne : arrTwo;
		int[] largerArr = arrOne.length > arrTwo.length ? arrOne : arrTwo;

		for( int i = 0; i < smallerArr.length - 1; i++ ) {
			
			if( !( smallerArr[ i ] == smallerArr[ i + 1 ] ) ) {
				
				if( binarySearch( largerArr, smallerArr[ i ] ) ) {
					result.add( smallerArr[ i ] );
				}
			}
		}
	}

	private static boolean binarySearch(int[] arr, int num) {
		int hi = arr.length - 1;
		int lo = 0;
		int pivotIndex = lo + ( hi - lo ) / 2;
		int pivotVal = arr[ pivotIndex ];
		
		while( lo <= hi ) {
			
			if( pivotVal == num ) {
				return true;
			}
			
			if( pivotVal < num ) {
				lo = pivotIndex + 1;
				pivotIndex = lo + ( hi - lo ) / 2;
				pivotVal = arr[ pivotIndex ];
				continue;
			}
			
			if( pivotVal > num ) {
				hi = pivotIndex - 1;
				pivotIndex = lo + ( hi - lo ) / 2;
				pivotVal = arr[ pivotIndex ];
				continue;
			}
		}
		return false;
	}

}
