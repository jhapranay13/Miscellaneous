package searching;

public class BinarySearchIteration {

	public static void main(String[] args) {
		int [] intList = { 1, 3, 5, 7, 11, 14, 17, 22, 34, 35, 56, 79, 86 };
		int targetElement = 17;
		binarySearch( intList, targetElement );
	}

	private static void binarySearch(int[] intList, int targetElement) {	
		int lo = 0;
		int hi = intList.length - 1;
		int midPoint = lo + ( hi - lo ) / 2;
		int counter = 0;
		
		while( lo <= hi ) {
			counter++;
			
			if( intList[ midPoint ] < targetElement ) {
				lo = midPoint + 1;
				midPoint = lo + ( hi - lo ) / 2;
			} else if( intList[ midPoint ] > targetElement ) {
				hi = midPoint - 1;
				midPoint = lo + ( hi - lo ) / 2;
			} else if( intList[ midPoint ] == targetElement ) {
				System.out.println( "Target found at index : " + midPoint + " in number of loops " + counter );
				return;
			}
		}
		System.out.println( "Target not found" );
	}

}
