package elementsOfProgramming.Searching;

public class ArrayEntryEqualToIndexInSortedArray {

	public static void main(String[] args) {
		int[] arr = { -2, 1, 2, 3, 6, 7, 9 };
		int lo = 0;
		int hi = arr.length - 1;
		printEntryEqualToIndex( arr, lo, hi );
	}

	private static void printEntryEqualToIndex(int[] arr, int lo, int hi) {
		
		if( lo <= hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			
			if( arr[ pivot ] == pivot ) {
				System.out.println( pivot );
			}
			
			if( arr[ pivot ] >= pivot ) {
				printEntryEqualToIndex(arr, lo, pivot - 1);
			}
			
			if( arr[ pivot ] <= pivot ) {
				printEntryEqualToIndex(arr, pivot + 1, hi );
			}
		}
	}

}
