package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] intList = { 98, 34, 55, 67, 78, 88, 24, 21, 8, 1, 6, 9, 9 };
		System.out.println( Arrays.toString(intList) );
		int hi = intList.length - 1;
		int lo = 0;
		quickSort( intList, lo, hi );
		System.out.println( "Sorted : " + Arrays.toString(intList) );
	}

	private static void quickSort(int[] intList, int lo, int hi) {
		int midPoint = lo + ( hi - lo ) / 2;
		int low = lo;
		int high = hi;
		int pivot = intList[ midPoint ];
		int pivotIndex = midPoint;
		
		while( low <= high ) {
			
			while( intList[ low ] < pivot ) {
				low++;
			}
			
			while( intList[ high ] > pivot ) {
				high--;
			}
			
			if( low <= high ) {
				if( low == pivotIndex ) {
					pivotIndex = high;
				} else {
					pivotIndex = low;
				}
				swap( intList, low, high );
				low++;
				high--;
			}
			
		}
		System.out.println( Arrays.toString( intList ) );
		System.out.println(  pivotIndex );
		if( low < hi ) {
			quickSort(intList, low, hi);	
		}
		
		if( lo < high ) {
			quickSort( intList, lo, high );
		}

	}

	private static void swap(int[] intList, int j, int i) {
		int temp = intList[ j ];
		intList[ j ] = intList[ i ];
		intList[ i ] = temp;
	}
}
