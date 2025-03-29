package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] intList = { 98, 34, 55, 67, 78, 88, 24, 21, 8, 1, 6, 9 };
		System.out.println( Arrays.toString(intList) );
		insertionSort( intList );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void insertionSort(int[] intList) {
		
		for( int i = 0; i < intList.length - 1; i++ ) {
			
			for( int j = i + 1; j > 0; j-- ) {
				
				if( intList[ j ] < intList[ j - 1 ] ) {
					swap( intList, j, j -1 );
				} 
			}
		}
	}
	
	private static void swap(int[] intList, int j, int i) {
		int temp = intList[ j ];
		intList[ j ] = intList[ i ];
		intList[ i ] = temp;
	}

}
