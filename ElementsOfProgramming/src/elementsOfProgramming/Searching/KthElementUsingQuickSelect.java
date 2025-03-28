package elementsOfProgramming.Searching;

import java.util.Arrays;

public class KthElementUsingQuickSelect {

	public static void main(String[] args) {
		Integer arr[] = { new Integer(8), new Integer(7), new Integer(5), 
				new Integer(1), new Integer(4) };
		System.out.println( Arrays.toString( arr ) );
		System.out.println( "Result >> " + findKthElementByQuickSelect(arr, 0, arr.length - 1, 2) );
	}

	public static int findKthElementByQuickSelect(Integer[] arr, int lo, int hi, int k) {
		int currentPlacedPosition = partition( arr, lo, hi );
		
		if( k == currentPlacedPosition ) {
			return arr[ currentPlacedPosition ];
		}
		
		if( currentPlacedPosition < k ) {
			return findKthElementByQuickSelect(arr, currentPlacedPosition + 1, hi, k);
		}
		return findKthElementByQuickSelect(arr, lo, currentPlacedPosition - 1, k);
	}
	 
	//Other way of implementing quickSort by placing the element in correct position
	private static int partition(Integer[] arr, int lo, int hi) {
		int placementPosition = lo;
		int low = lo;
		int high = hi;
		int pivot = arr[ hi ];
		
		for( int j = low; j <= high - 1; j++ ) {
			
			if( arr[ j ] <= pivot ) {
				swap(arr, placementPosition++, j);
			}
		}
		System.out.println( placementPosition );
		swap( arr, placementPosition, high );
		System.out.println( Arrays.toString( arr ) );

		return placementPosition;
	}

	public static void swap(Integer[] arr, int n1, int n2) {
	    int temp = arr[n2];
	    arr[n2] = arr[n1];
	    arr[n1] = temp;
	}
}
