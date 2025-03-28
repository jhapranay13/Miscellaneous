package elementsOfProgramming.Strings;

import java.util.Arrays;

/*
 * Replace each 'a' by two 'd's.
 * Delete each entry containing a 'b'.
 */
public class ReplaceAndRemove {

	public static void main(String[] args) {
		String[] arr = { "a", "b", "z", "b", "b", "c", "a" };
		replaceRemoveOperation( arr , 7 );
		System.out.println( Arrays.toString( arr ) );
	}

	private static void replaceRemoveOperation(String[] arr, int size) {
		int indexToPut = -1;
		int count = 0;
		
		for( int i = 0; i < size; i++ ) {
			
			if( arr[ i ].equals( "b" ) ) {
				arr[ i ] = null;
				count++;
				
				if( indexToPut == -1 ) {
					indexToPut = i;
				}
			} else {
				
				if( indexToPut != -1 ) {
					arr[ indexToPut ] = arr[ i ];
					arr[ i ] = null;
					indexToPut++;
				}
			}
		}
		System.out.println( Arrays.toString( arr ) );
		System.out.println( count );
		int maxIndex = arr.length - 1;
		
		for( int i = count; i >= 0; i-- ) {
			String temp = arr[ i ];
			arr[ i ] = null;
			
			if( temp.equals( "a" ) ) {
				arr[ maxIndex-- ] = "a";
				arr[ maxIndex-- ] = "a";
			} else {
				arr[ maxIndex-- ] = temp;
			}
		}
	}
}
