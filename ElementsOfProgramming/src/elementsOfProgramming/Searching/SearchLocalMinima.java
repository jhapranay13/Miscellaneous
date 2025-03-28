package elementsOfProgramming.Searching;

public class SearchLocalMinima {
	//O( log n )

	public static void main(String[] args) {
		int arr[] = {9, 6, 3, 14, 5, 7, 4};
		int start = 0;
		int end = arr.length - 1;
		printLocalMinima( arr, start, end );
	}

	private static void printLocalMinima(int[] arr, int start, int end) {
		
		if( end - start >= 2 ) {
			int pivot = start +  ( end - start ) / 2;
			
			if( arr[ pivot ] < arr[ pivot - 1 ] && arr[ pivot ] < arr[ pivot + 1 ]  ) {
				System.out.println( arr[ pivot ] );
			}
			
			if( arr[ pivot ] > arr[ pivot - 1 ] ) {
				printLocalMinima(arr, start, pivot);
			}
			
			if( arr[ pivot ] > arr[ pivot + 1 ] ) {
				printLocalMinima(arr, pivot, end);
			}
		}
	}
}