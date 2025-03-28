package crackingTheCodingInterview.SearchingAndSorting;

import java.util.Arrays;

public class SortedMergeFromBack {

	public static void main(String[] args) {
		int[] firstArray = { 12, 16, 27, 31, 44, 0, 0, 0 };
		int[] secondArray = { 13, 15, 34 };
		
		mergeFromBack( firstArray, secondArray );
		System.out.println( Arrays.toString( firstArray ) );
	}

	private static void mergeFromBack(int[] firstArray, int[] secondArray) {
		int lastIndexFirstArr = firstArray.length - 1;
		int lastIndexSecondArr = secondArray.length -1;
		
		for( int i = lastIndexFirstArr; i >= 0; i--  ) {
			
			if( firstArray[ i ] != 0 ) {
				lastIndexFirstArr = i;
				break;
			}
		}
		
		for( int i = firstArray.length - 1; i > lastIndexFirstArr; i-- ) {
			
			firstArray[ i ] = firstArray[ lastIndexFirstArr ] > secondArray[ lastIndexSecondArr ] ?
					firstArray[ lastIndexFirstArr-- ] : secondArray[ lastIndexSecondArr-- ];
		}
	}

}
