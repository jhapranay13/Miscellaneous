package crackingTheCodingInterview.ArraysAndStrings;

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
		int size = matrix.length - 1;
		int rowLimit = size / 2;
		
		for( int i = 0; i <= rowLimit; i++ ) {

			for( int j = i; j < ( size - i ); j++ ) {
				int currentRow = i;
				int currentColumn = j;
				int currentValue = matrix[ currentRow ][ currentColumn ];
				
				do{
					int toRow = calculateNextRow(currentColumn, size);
					int toColumn = currentRow;
					int temp = matrix[ toRow ][ toColumn ];
					matrix[ toRow ][ toColumn ] = currentValue;
					currentValue = temp;
					currentColumn = toColumn;
					currentRow = toRow;
				} while( currentColumn != j | currentRow != i );
				
			}
			
		}
	}

	private static int calculateNextRow(int currentColumn, int size) {
		return size - currentColumn;
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
