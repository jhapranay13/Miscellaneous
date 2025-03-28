package elementsOfProgramming.Searching;

public class SearchFirstOccouranceOfK {

	public static void main(String[] args) {
		int[] arr = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };
		int numberToFind = 108;
		int lo = 0;
		int hi = arr.length - 1;
		int firstOccouranceIndex = getFirstOccouranceIndex( arr, numberToFind, lo, hi );
		System.out.println( firstOccouranceIndex );
		System.out.println( arr[ firstOccouranceIndex ] );
	}

	private static int getFirstOccouranceIndex(int[] arr, int numberToFind, int lo, int hi) {
		int indexToReturn = -1;
		int low = lo;
		int high = hi;
		int pivot = low + ( high - low ) / 2;

		if( lo <= hi ) {
			
			if( arr[ pivot ] == numberToFind ) {
				int prevIndex = pivot - 1;

				while( arr[ prevIndex ] == arr[ pivot ] ) {
					prevIndex--;
				}
				indexToReturn = prevIndex + 1;
			} else if( arr[ pivot ] > numberToFind  ) {
				indexToReturn = getFirstOccouranceIndex(arr, numberToFind, 0, pivot - 1 );
			} else {
				indexToReturn = getFirstOccouranceIndex(arr, numberToFind, pivot + 1, high);
			}
		}
		return indexToReturn;
	}

}
