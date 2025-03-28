package elementsOfProgramming.Searching;

import java.util.Arrays;

public class KthElementUsingQuickSelectQuickSortVersion {
	public static void main(String[] args) {
		int arr[] = { 8, 7, 5, 1, 4, 9, 3 };
		System.out.println( Arrays.toString( arr ) );
		System.out.println( "Result >> " + findKthElementByQuickSelect(arr, 0, arr.length - 1, 4) );
	}

	public static int findKthElementByQuickSelect(int[] arr, int lo, int hi, int k) {
		int currentPlacedPosition = partition( arr, lo, hi, k );
		int tempPosition = k;
		
		if( tempPosition == currentPlacedPosition ) {
			return arr[ currentPlacedPosition ];
		}
		
		if( currentPlacedPosition < k ) {
			return findKthElementByQuickSelect(arr, currentPlacedPosition + 1, hi, k);
		}
		return findKthElementByQuickSelect(arr, lo, currentPlacedPosition - 1, k);
	}
	 
	private static int partition(int[] arr, int lo, int hi, int k) {
		int low = lo;
		int high = hi;
		int pivotIndex = lo + ( hi - lo ) / 2;
		int pivot = arr[ hi ];

		
		while( low <= high ) {
			
			while( arr[ low ] < pivot ) {
				low++;
			}
			
			while( arr[ high ] > pivot ) {
				high--;
			}
			
			if( low <= high ) {
				
				if( low == pivotIndex ) {
					pivotIndex = high;
				} else if( high == pivotIndex ) {
					pivotIndex = low;
				}
				swap( arr, high, low );
				high--;
				low++;
			}
		}
		return pivotIndex;
	}

	public static void swap(int[] arr, int n1, int n2) {
	    int temp = arr[n2];
	    arr[n2] = arr[n1];
	    arr[n1] = temp;
	}
}
