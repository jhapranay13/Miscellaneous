package elementsOfProgramming.Searching;

public class ArrayEntryEqualToIndexInSortedArrayIteration {

	public static void main(String[] args) {
		int[] arr = { -2, 1, 2, 3, 6, 7, 9 };
		int lo = 0;
		int hi = arr.length - 1;
		printEntryEqualToIndex( arr, lo, hi );
	}

	private static void printEntryEqualToIndex(int[] arr, int lo, int hi) {
		
		while( lo <= hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			int difference = arr[ pivot ] - pivot;
			
			if( difference == 0 ) {
				System.out.println( pivot );
				return;
			}
			
			if( difference > 0 ) {
				hi = pivot;
			}
			
			if( difference < 0 ) {
				lo = pivot;
			}
		}
	}

}
