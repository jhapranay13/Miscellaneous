package elementsOfProgramming.Searching;

public class SearchIn2DSortedArray {

	public static void main(String[] args) {
		int arr[][] = {
				{ -1, 2, 4, 4, 6 },
				{ 1, 5, 5, 9, 21 },
				{ 3, 6, 6, 9, 22 },
				{ 3, 6, 8, 10, 24 },
				{ 6, 8, 9, 12, 25 },
				{ 8, 10, 12, 13, 40 }
		};
		printIndexForKey( arr, 8 );
	}

	private static void printIndexForKey(int[][] arr, int key) {
		int row = 0;
		int col = arr[ row ].length - 1;
		
		while( row < arr.length && col >= 0 ) {
			
			if( arr[ row ][ col ] == key ) {
				System.out.println( row + ", " + col );
				return;
			}
			
			if( arr[ row ][ col ] < key ) {
				row++; //eleminating row as row and column both are sorted
			} else if( arr[ row ][ col ] > key ) {
				col--; //eleminating col as row and column both are sorted
			} else {
				
			}
			
		}
		System.out.println( "Not Found" );
	}
}
