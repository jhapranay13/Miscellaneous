package crackingTheCodingInterview.ArraysAndStrings;

public class MatrixRotation {

	public static void main(String[] args) {
		int matrix[][] = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16}
		};
		printMatrix( matrix );
		System.out.println( "=================" );
		rotateMatrixCounterClockWise( matrix );
		printMatrix( matrix );
	}

	private static void rotateMatrixCounterClockWise(int[][] matrix) {
		int numberOfElements = matrix.length - 1;
		int numberOfPass = matrix.length / 2;

		for( int i = 0; i <= numberOfPass; i++ ) {
			int startingIndexRow = 0 + i;
			int startingIndexCol = startingIndexRow;
			int endingIndexRow = matrix.length - 1 - i;

			int startIndRow = startingIndexRow;
			int startIndCol = startingIndexCol;
			int temp = 0;

			for( int j = startingIndexRow; j < endingIndexRow; j++ ) {
				startIndCol = j;
				int val = matrix[ startIndRow ][ startIndCol ];
				
				do {
					int nextRow = numberOfElements - startIndCol;
					temp = matrix[ nextRow ][ startIndRow ];
					matrix[ nextRow ][ startIndRow ] = val;
					startIndCol = startIndRow;
					startIndRow = nextRow;
					val = temp;
				} while ( startIndRow != i | startIndCol != j );
			}
		}	
	}

	private static void printMatrix(int[][] matrix) {

		for( int i = 0; i < matrix.length; i++ ) {

			for( int j = 0; j < matrix[ i ].length; j++ ) {

				if( j > 0 ) {
					System.out.print( ", " );
				}
				System.out.print( matrix[ i ][ j ] );
			}
			System.out.println("");
		}
	}
}
