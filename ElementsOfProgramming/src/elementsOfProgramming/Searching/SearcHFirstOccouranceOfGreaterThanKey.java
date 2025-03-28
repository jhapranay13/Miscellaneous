package elementsOfProgramming.Searching;

public class SearcHFirstOccouranceOfGreaterThanKey {

	public static void main(String[] args) {
		int[] arr = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
		int numberToFind = 260;
		int firstOccouranceIndex = getFirstOccouranceGreaterThan( arr, numberToFind );
		System.out.println( firstOccouranceIndex );
		System.out.println( arr[ firstOccouranceIndex ] );
	}

	private static int getFirstOccouranceGreaterThan(int[] arr, int numberToFind) {
		int lo = 0;
		int hi = arr.length - 1;
		
		while( lo <= hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			
			if( hi - lo == 1 ) {
				return hi; 
			}
			
			if( arr[ pivot ] < numberToFind ) {
				lo = pivot;
			} else if( arr[ pivot ] > numberToFind ) {
				hi = pivot;
			}
		}
		return -1;
	}

}
