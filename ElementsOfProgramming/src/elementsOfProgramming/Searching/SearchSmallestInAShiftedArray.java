package elementsOfProgramming.Searching;

public class SearchSmallestInAShiftedArray {

	public static void main(String[] args) {
		int[] arr = { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 };
		int minimumIndex = searchMinimum( arr );
		System.out.println( "Minimum at index " + minimumIndex + " value >> " + 
				arr[ minimumIndex ] );
	}

	private static int searchMinimum(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		
		while( lo < hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			
			if( arr[ pivot ] < arr[ lo ] ) {
				hi = pivot;
			} else {
				lo = pivot + 1;
			}
		}
		return hi;
	}

}
