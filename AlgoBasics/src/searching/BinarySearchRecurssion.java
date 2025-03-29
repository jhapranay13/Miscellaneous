package searching;

public class BinarySearchRecurssion {

	public static void main(String[] args) {
		int [] intList = { 1, 3, 5, 7, 11, 14, 17, 22, 34, 35, 56, 79, 86 };
		int targetElement = 14;
		int hi = intList.length - 1;
		int lo = 0;
		binarySearch( intList, targetElement, lo, hi );
	}

	private static void binarySearch(int[] intList, int targetElement, int lo, int hi) {
		
		if( lo <= hi ) {
			int midPoint = lo + ( hi - lo ) / 2;
			
			if( intList[ midPoint ] > targetElement ) {
				hi = midPoint - 1;
			} else if ( intList[ midPoint ] < targetElement ) {
				lo = midPoint + 1;
			} else if( intList[ midPoint ] == targetElement ) {
				System.out.println( "Found at index : " + midPoint );
				return;
			}
			binarySearch( intList, targetElement, lo, hi );
		} else {
			System.out.println( "Not Found At all" );
			return;
		}
	}

}
