package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] intList = { 98, 34, 55, 67, 78, 88, 24, 21, 8, 1, 6, 9 };
		System.out.println( Arrays.toString(intList) );
		selectionSort( intList );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void selectionSort(int[] intList) {
		
		for( int i = 0; i < intList.length - 1; i++ ) {
			int minIndex = i;
			
			for( int j = i + 1; j < intList.length; j++ ) {
				
				if( intList[ minIndex ] > intList[ j ] ) {
					minIndex = j;
				} 
			}
			
			if( i != minIndex ) {
				swap( intList, i , minIndex );
			}
		}
	}
	
	private static void swap(int[] intList, int j, int i) {
		int temp = intList[ j ];
		intList[ j ] = intList[ i ];
		intList[ i ] = temp;
	}
}
