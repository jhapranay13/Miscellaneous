package elementsOfProgramming.Searching;

import java.util.Arrays;

public class QuickSortPartitionVersionForQuickSelect {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, 1, 4 };
		System.out.println( Arrays.toString(arr) );
		startSort( arr );
		System.out.println( Arrays.toString(arr) );

	}

	private static void startSort(int[] arr) {
		int hi = arr.length - 1;
		int lo = 0;
		quickSort( arr, lo, hi );
	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if( lo < hi ) {
			int position = partition( arr, lo, hi );
			
			quickSort(arr, lo, position - 1);
			quickSort(arr, position + 1, hi);
		}
	}
	
	/*private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[ hi ];
		int position = hi - 1;

		for( int j = position; j >= lo; j-- ) {

			if( arr[ j ] > pivot ) {
				swap( arr, position--, j );
			}
		}
		swap( arr, position + 1, hi );
		return position + 1;
	}*/

	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[ hi ];
		int position = lo;

		for( int j = lo; j <= hi - 1; j++ ) {

			if( arr[ j ] <= pivot ) {
				swap( arr, position++, j );
			}
		}
		swap( arr, position, hi );
		return position;
	}

	public static void swap(int[] arr, int n1, int n2) {
		int temp = arr[n2];
		arr[n2] = arr[n1];
		arr[n1] = temp;
	}
}
