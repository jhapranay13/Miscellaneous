package crackingTheCodingInterview.SearchingAndSorting;

public class SearchInTheRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = { 14, 17, 19, 21, 24, 26, 1, 4, 5, 7 };
		int valueToBeFound = 19;
		int index = findTheValue( arr, valueToBeFound );
		
		if( index != -1 ) {
			System.out.println( "Value Found " + valueToBeFound + " at index " + index );
		} else {
			System.out.println( "No Value Found" );
		}
	}

	private static int findTheValue(int[] arr, int valueToBeFound) {
		int returnVal = -1;
		int hi = arr.length - 1;
		int lo = 0;
		
		int startingIndex = findStartingIndex( arr, lo, hi );
		
		if( valueToBeFound < arr[ hi ] ) {
			returnVal = binarySearch( valueToBeFound , arr, startingIndex, hi );
		} else {
			returnVal = binarySearch( valueToBeFound , arr, lo, startingIndex - 1 );
		}
		return returnVal;
	}

	private static int binarySearch(int valueToBeFound, int[] arr, int lo, int hi) {
		int pivot = lo + ( hi - lo ) / 2;
		
		while( lo != pivot ) {
			
			if( valueToBeFound == arr[ lo ] ) {
				return lo;
			}
			
			if( valueToBeFound == arr[ hi ] ) {
				return hi;
			}
			pivot = lo + ( hi - lo ) / 2;
			
			if( valueToBeFound < arr[ pivot ] ) {
				hi = pivot;
			} else if( valueToBeFound > arr[ pivot ] ) {
				lo = pivot;
			} else {
				return pivot;
			}	
		}
		return -1;
	}

	private static int findStartingIndex(int[] arr, int lo, int hi) {
		
		if( hi - lo == 1 ) {
			return arr[ hi  ] > arr[ lo ] ? lo : hi;
		}
		int pivot = lo + ( hi - lo ) / 2;

		if( arr[ pivot ] > arr[ lo ] ) {
			lo = pivot;
		} else if( arr[ pivot ] < arr[ lo ] ) {
			hi = pivot;
		}
		return findStartingIndex(arr, lo, hi);
	}

}
