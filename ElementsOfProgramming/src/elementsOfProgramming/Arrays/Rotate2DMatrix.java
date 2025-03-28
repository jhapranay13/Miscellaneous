package elementsOfProgramming.Arrays;

public class Rotate2DMatrix {

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
		int level = matrix.length / 2;
		
		for( int i = 0; i < level; i++ ) {
			
			for( int j = i; j < matrix.length - 1; j++ ) {
				int currentRow = i;
				int currentCol = j;
				int currentVal = matrix[ currentRow ][ currentCol ];
				
				do {
					int nextRow = currentCol;
					int nextCol = matrix.length - 1 - currentRow;
					int temp = matrix[ nextRow ][ nextCol ];
					matrix[ nextRow ][ nextCol ] = currentVal;
					currentVal = temp;
					currentRow = nextRow;
					currentCol = nextCol;
				} while( currentRow != i | currentCol != j );
				
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
