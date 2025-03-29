package datstructureAndAlorithm.Arrays;

class SingleDimensionArray {
	int[] arr = null;

	public SingleDimensionArray( int size ) {
		arr = new int[ size ];

		for( int i = 0; i < arr.length; i++ ) {
			arr[ i ] = Integer.MIN_VALUE;
		}
	}

	public void traverseArray() {

		try {

			for( int i = 0; i < arr.length; i++ ) {
				System.out.println( arr[ i ] );
			}
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}

	public void insertToLocation( int location, int value ) {

		try {

			arr[ location ] = value;
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}

	public void searchArray( int value ) {

		for( int i = 0; i < arr.length; i++ ) {
			
			if( arr[ i ] == value ) {
				System.out.println( "Value Found at index " + i );
				return;
			}
		}
		System.out.println( "Value not found" );
	}
	
	public void removeValue( int value ) {

		for( int i = 0; i < arr.length; i++ ) {
			
			if( arr[ i ] == value ) {
				arr[ i ] = Integer.MIN_VALUE;
				return;
			}
		}
		System.out.println( "Value not found" );
	}
}

public class SingleDimensionArrayTest {

	public static void main(String[] args) {
		SingleDimensionArray arr = new SingleDimensionArray( 10 );
		arr.traverseArray();

		arr.insertToLocation(0, 0);
		arr.insertToLocation(1, 1);
		arr.insertToLocation(2, 2);
		arr.insertToLocation(3, 3);
		arr.insertToLocation(4, 4);
		arr.insertToLocation(5, 5);
		arr.insertToLocation(6, 6);
		arr.insertToLocation(7, 7);
		arr.insertToLocation(8, 8);
		arr.insertToLocation(9, 9);
		arr.traverseArray();
		
		arr.searchArray(3);
		
		arr.removeValue( 4 );
		arr.traverseArray();
	}

}
