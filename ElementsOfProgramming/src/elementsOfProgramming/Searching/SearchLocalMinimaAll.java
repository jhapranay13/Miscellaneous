package elementsOfProgramming.Searching;

public class SearchLocalMinimaAll {
	//O( n )
	public static void main(String[] args) {
		int arr[] = {9, 6, 3, 14, 5, 7, 4};
		printLocalMinima( arr );
	}

	private static void printLocalMinima(int[] arr) {
		
		if( arr.length < 3 ) {
			System.out.println( "NO Local Minima Possible" );
		}
		int incrementPosition = 2;
		int start = 0;
		
		while( start + incrementPosition < arr.length ) {
			int end = start + incrementPosition;
			int pivot = start + ( end - start ) / 2;
			
			if( arr[ pivot ] < arr[ start ] ) {
				
				if( arr[ pivot ] < arr[ end ] ) {
					System.out.println( "Local Minima at index " + pivot + " >> " + 
							arr[ pivot ] );
					start = end;
					continue;
				}
			}
			start++;
		}
	}
}
