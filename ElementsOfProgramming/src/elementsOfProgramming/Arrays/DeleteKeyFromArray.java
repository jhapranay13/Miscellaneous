package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class DeleteKeyFromArray {
	
	public static void main( String args[] ) {
		int array[] = { 2, 3, 4, 5, 4, 3, 4, 9 };
		int key = 3;
		int length = removeTheKeyReturnLength( array, key );
		System.out.println( Arrays.toString( array ) );
		System.out.println( length );
	}

	private static int removeTheKeyReturnLength(int[] array, int key) {
		int length = 0;
		int indexToCopy = -1;
		
		for( int i = 0; i < array.length; i++ ) {
			length++;
			
			if( array[ i ] == key ) {
				length--;
				
				if( indexToCopy == -1 ) {
					indexToCopy = i;
				} 
				array[ i ] = 0;
				continue;
			}
			
			if( indexToCopy != -1 ) {
				array[ indexToCopy ] = array[ i ];
				indexToCopy++;
				array[ i ] = 0;
			}
		}
		return length;
	}
}
