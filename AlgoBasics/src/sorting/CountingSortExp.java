package sorting;

import java.util.Arrays;

public class CountingSortExp {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 6, 7, 8, 3, 6, 7 };
		int sortedArr[] = new int[ arr.length ];
		countingSort( arr, sortedArr );
		System.out.println( Arrays.toString(arr) );

		System.out.println( Arrays.toString(sortedArr) );
	}

	private static void countingSort(int[] arr, int[] sortedArr) {
		int[] holder = new int[ 10 ];
		
		for( int i = 0; i < arr.length; i++ ) {
			holder[ ( arr[ i ] % 10 ) ]++;
		}
		System.out.println( "HOLDER >> " + Arrays.toString(holder) );
		//Adding to the next
		for( int i = 1; i < holder.length; i++ ) {
			holder[ i ] += holder[ i - 1 ];
		}
		System.out.println( "HOLDER >> " + Arrays.toString(holder) );
		//Shifting
		for( int i = holder.length - 1; i > 0; i-- ) {
			holder[ i ] = holder[ i - 1 ];
		}
		System.out.println( "HOLDER >> " + Arrays.toString(holder) );
		//Adding and incrementing
		for( int i = 0; i < arr.length; i++ ) {
			int val = arr[ i ];
			int pos = holder[ val ]++ ;
			sortedArr[ pos ] = val;
			System.out.println( "SORTED ARRAY PASS >> " + Arrays.toString( sortedArr ) );
		}
	}

}
