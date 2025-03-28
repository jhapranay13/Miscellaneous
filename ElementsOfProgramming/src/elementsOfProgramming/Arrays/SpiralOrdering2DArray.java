package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class SpiralOrdering2DArray {

	public static void main(String[] args) {

		
		/*
		 * int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15
		 * }, { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		 */
		 
		
		 int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; 
		 
		
		/*
		 * int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
		 * 15, 16} };
		 */
		 
		int[] result = getSpiralOrdering( arr );
		System.out.println( Arrays.toString( result ) );
	}

	private static int[] getSpiralOrdering(int[][] arr) {
		int[] spiralOrder = new int[ arr.length * arr[ 0 ].length ];
		int counter = 0;
		int startIndex = 0;
		int endIndex = arr.length - 2;
		int startRow = 0;
		int startCol = 0;

		while( startIndex <= endIndex ) {
			int col = startIndex;
			int row = startIndex;

			for( ; col <= endIndex; col++ ) {
				spiralOrder[ counter++ ] = arr[ startRow ][ col ]; 
			}

			for( ; row <= endIndex; row++ ) {
				spiralOrder[ counter++ ] = arr[ row ][ col ];
			}
			
			for( ; col > startIndex; col-- ) {
				spiralOrder[ counter++ ] = arr[ row ][ col ];
			}
			
			for( ; row > startIndex; row-- ) {
				spiralOrder[ counter++ ] = arr[ row ][ col ];
			}
			startIndex++;
			endIndex--;
			startRow++;
			startCol++;
		}
		
		if( spiralOrder.length % 2 != 0 ) {
			spiralOrder[ counter ] = arr[ startIndex ][ endIndex + 1 ];
		}
		return spiralOrder;
	}

}
