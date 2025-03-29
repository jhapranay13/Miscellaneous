package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] intList = { 98, 34, 55, 67, 78, 88, 24, 21, 8, 1, 6, 9, 9 };
		System.out.println( Arrays.toString(intList) );
		int hi = intList.length - 1;
		int lo = 0;
		sort( intList, lo, hi );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void sort(int[] intList, int lo, int hi) {
		int[] helper = new int[ intList.length ];
		mergeSort( intList, helper, lo, hi );
	}

	private static void mergeSort(int[] intList, int[] helper, int lo, int hi) {
		
		if( lo < hi ) {
			int mid = lo + ( hi - lo ) / 2;
			mergeSort( intList, helper, lo, mid );
			mergeSort( intList, helper, mid + 1, hi );
			merge( intList, helper, lo, mid, hi );
		}
	}

	private static void merge(int[] intList, int[] helper, int lo, int mid, int hi) {
		int counter = lo;
		int i = lo; 
		int j= mid + 1;
		
		for( ; i <= mid && j <= hi;  ) {
			
			if( intList[ i ] < intList[ j ] ) {
				helper[ counter++ ] = intList[ i++ ];
			} else {
				helper[ counter++ ] = intList[ j++ ];
			}
		}
		
		while( i <= mid ) {
			helper[ counter++ ] = intList[ i++ ];
		}
		
		while( j <= hi ) {
			helper[ counter++ ] = intList[ j++ ];
		}
		
		for( int k = lo; k <= hi; k++ ) {
			intList[ k ] = helper[ k ];
		}
		
	}

}
