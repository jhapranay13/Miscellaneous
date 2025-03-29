package datstructureAndAlorithm.Arrays;

class TwoDimensionArray {
	int[][] arr = null;

	public TwoDimensionArray( int row, int col ) {
		arr = new int[ row ][ col ];

		for( int i = 0; i < arr.length; i++ ) {

			for( int j = 0; j < arr[ i ].length; j++ ) {
				arr[ i ][ j ] = Integer.MIN_VALUE;
			}
		}
	}

	public void traverseArray() {

		try {

			for( int i = 0; i < arr.length; i++ ) {

				for( int j = 0; j < arr[ i ].length; j++ ) {
					System.out.print( arr[ i ][ j ] + " " );
				}	
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}

	public void insertToLocation( int row, int col, int value ) {

		try {

			arr[ row ][ col ] = value;
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}

	public void accessSingleValue( int row, int col ) {

		try {

			System.out.println( arr[ row ][ col ] );
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}

	public void searchArray( int value ) {

		for( int i = 0; i < arr.length; i++ ) {

			for( int j = 0; j < arr[ i ].length; j++ ) {
				
				if( arr[ i ][ j ] == value ) {
					System.out.println( "Value Found at index " + i + ", " + j );
					return;
				}
			}
		}
		System.out.println( "Value not found" );
	}

		public void removeValue( int row, int col ) {

		try {
			arr[ row ][ col ] = Integer.MIN_VALUE;
			return;
		} catch( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}

}
public class TwoDimensionArrayTest {

	public static void main(String[] args) {
		TwoDimensionArray arr = new TwoDimensionArray(5, 5);
		arr.traverseArray();
		arr.insertToLocation(0, 0, 0);
		arr.insertToLocation(0, 1, 1);
		arr.insertToLocation(0, 2, 2);
		arr.insertToLocation(0, 3, 3);
		arr.insertToLocation(0, 4, 4);
		arr.insertToLocation(1, 0, 0);
		arr.insertToLocation(1, 1, 1);
		arr.insertToLocation(1, 2, 2);
		arr.insertToLocation(1, 3, 3);
		arr.insertToLocation(1, 4, 4);
		arr.traverseArray();

		arr.accessSingleValue(1, 3);
		
		arr.searchArray(4);
		arr.removeValue( 0 , 3);
		arr.traverseArray();
	}

}
