package crackingTheCodingInterview.ArraysAndStrings;

public class ZeroMatrix {

	//can be solved by having two arrays with boolean values representing
	//rows and columns having zero.
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4, 0 },
				{ 0, 2, 3, 4, 5 },
				{ 1, 2, 0, 4, 5 },
				{ 1, 2, 3, 4, 5 },
				{ 1, 2, 3, 4, 5 },
		};
		printMatrix( matrix );
		solve( matrix );
		System.out.println( "====================" );
		printMatrix( matrix );
	}

	private static void solve(int[][] matrix) {
		boolean firstRowContainsZero = false;
		boolean firstColContainsZero = false;

		for( int i = 0; i < matrix.length; i++ ) {

			if( matrix[ 0 ][ i ] == 0 ) {
				firstRowContainsZero = true;
			}
		}

		for( int i = 0; i < matrix.length; i++ ) {

			if( matrix[ i ][ 0 ] == 0 ) {
				firstColContainsZero = true;
			}
		}

		for( int i = 0; i < matrix.length; i++ ) {

			for( int j = 0; j < matrix[ i ].length; j++ ) {

				if( matrix[ i ][ j ] == 0 ) {
					matrix[ i ][ 0 ] = 0;
					matrix[ 0 ][ j ] = 0;

				}
			}
		}

		for( int i = 1; i < matrix.length; i++ ) {

			if( matrix[ i ][ 0 ] == 0 ) {

				for( int j = 0; j < matrix.length; j++ ) {
					matrix[ i ][ j ] = 0;
				}
			}
		}

		for( int i = 1; i < matrix.length; i++ ) {

			if( matrix[ 0 ][ i ] == 0 ) {

				for( int j = 0; j < matrix.length; j++ ) {
					matrix[ j ][ i ] = 0;
				}
			}
		}

		if( firstRowContainsZero ) {

			for( int j = 0; j < matrix.length; j++ ) {
				matrix[ 0 ][ j ] = 0;
			}
		}

		if( firstColContainsZero ) {

			for( int j = 0; j < matrix.length; j++ ) {
				matrix[ j ][ 0 ] = 0;
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
